package com.cl9p.services;

import com.cl9p.services.VirtualMachineManagementServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-flock4j-services-context.xml")
public class VirtualMachineManagementTest {
    @Autowired
    private VirtualMachineManagementServiceImpl virtualMachineManagementService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testCloneVirtualMachine() throws Exception {
        virtualMachineManagementService.cloneVirtualMachine();
        Assert.notNull(virtualMachineManagementService);
    }
}
