package com.cl9p.services;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import com.cl9p.model.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CommandServiceImpl {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
   private MongoTemplate mongoTemplate;

    public String create(Command command) {
        mongoTemplate.save(command);
        return "saved";
    }

    public String execute(Command command) throws IOException {
        Connection connection = new Connection(command.getServer());
        connection.connect();
        boolean isAuthenticated = connection.authenticateWithPassword("lfaus", command.getPassword());
        logger.info("authenticated? " + isAuthenticated);
        Session session = connection.openSession();
        session.requestPTY("vt220");
        logger.info("got PTY");
        session.getStdin().write("sudo ls -la /root".getBytes());

//        session.getStdin().write("password".getBytes());
        logger.info("running sudo");
        InputStream stdout = new StreamGobbler(session.getStdout());
        logger.info("got stdout");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stdout));
        logger.info("got buffered reader");
        StringBuffer stringBuffer = new StringBuffer();
//        String result = bufferedReader.readLine();
//        while ((result = bufferedReader.readLine()) != null) {
//            // here we could check for sudo
//            stringBuffer.append(result + "\n");
//        }
        session.getStdin().write("password".getBytes());
        session.close();
        connection.close();
        return stringBuffer.toString();
    }
}
