package com.cl9p.services;

import com.cl9p.model.Command;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-flock4j-services-context.xml")
public class CommandServiceImplTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Command command;

    @Autowired
    private CommandServiceImpl commandService;

    @Before
    public final void setUp() {
        command.setCommand("ls -la /root");
        command.setServer("192.168.60.135");
        command.setUser("root");
        command.setPassword("password");
    }

    @Test
    public void testCreate() throws Exception {
        commandService.create(command);
        Assert.notNull(command);
    }

    @Test
    public void testExecute() {
        String result = null;
        try {
            result = commandService.execute(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("result: " + result);
        Assert.notNull(result);
    }

}
