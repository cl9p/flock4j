package com.cl9p.services;

import com.cl9p.model.Command;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-flock4j-services-context.xml")
public class CommandServiceImplTest {
    @Autowired
    private Command command;

    @Autowired
    private CommandServiceImpl commandService;

    @Test
    public void testCreate() throws Exception {
        command.setCommand("ls -la /root");
        command.setServer("192.168.60.135");
        command.setUser("root");
        command.setPassword("password");
        commandService.create(command);
    }

}
