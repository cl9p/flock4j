package com.cl9p.services;

import com.cl9p.model.Command;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.common.IOUtils;
import net.schmizz.sshj.connection.channel.direct.Session;
import net.schmizz.sshj.transport.verification.HostKeyVerifier;

import java.io.IOException;
import java.security.PublicKey;
import java.util.concurrent.TimeUnit;

public class CommandServiceImpl {

    public String execute(Command command) throws IOException {
        SSHClient client = new SSHClient();
        StringBuffer result = new StringBuffer();
        try {
            client.addHostKeyVerifier(new HostKeyVerifier() {
                @Override
                public boolean verify(String s, int i, PublicKey publicKey) {
                    return true;
                }
            });
            client.connect("192.168.60.135");
            client.authPassword("root", "password");
            Session session = client.startSession();
            try {
                session.allocateDefaultPTY();
                Session.Command cmd = session.exec("ls -la /root");
                result.append(IOUtils.readFully(cmd.getInputStream()).toString());
                cmd.join(5, TimeUnit.SECONDS);
                result.append("\n** Exit Status: " + cmd.getExitStatus());
            } finally {
                session.close();
            }
        } finally {
          client.disconnect();
        }
        return result.toString();
    }
}
