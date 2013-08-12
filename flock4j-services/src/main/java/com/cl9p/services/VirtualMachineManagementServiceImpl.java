package com.cl9p.services;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;

@WebService(endpointInterface = "com.cl9p.services.VirtualMachineManagementService",
        name = "VirtualMachineManagementService",
        serviceName = "VirtualMachineManagementService",
        portName = "VirtualMachineManagementPortType",
        targetNamespace = "http://flock4j.cl9p.com/services")
public class VirtualMachineManagementServiceImpl {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void cloneVirtualMachine() {
        logger.info("Hey, I called a service!");
        try {
            long start = System.currentTimeMillis();
            ServiceInstance si = new ServiceInstance(new URL("https://vcenter.faushouse.com/sdk"), "root", "password", true);
            long end = System.currentTimeMillis();
            logger.info("time taken: " + (end-start) + "ms");
            Folder rootFolder = si.getRootFolder();
            String name = rootFolder.getName();
            logger.info("root: " + name);

            ManagedEntity[] mes = new InventoryNavigator(rootFolder).searchManagedEntities("VirtualMachine");
            VirtualMachine vm = (VirtualMachine) mes[2];
            VirtualMachineConfigInfo vminfo = vm.getConfig();
            VirtualMachineCapability vmc = vm.getCapability();
            //vm.getResourcePool();

            logger.info("Hello " + vm.getName());
            logger.info("GuestOS: " + vminfo.getGuestFullName());
            logger.info("IP Addr: " + vm.getGuest().getIpAddress());
            logger.info("Multiple Snapshot Supported: " + vmc.isMultipleSnapshotsSupported());
            si.getServerConnection().logout();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
