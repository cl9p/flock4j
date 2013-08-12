package com.cl9p;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

public class StaticClassMain {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String args[]) {
        StaticClassMain clazz = new StaticClassMain();

        ServiceInstance si = null;
        try {
            String cloneName = "puppet-master";
            long start = System.currentTimeMillis();
            si = new ServiceInstance(new URL("https://vcenter.faushouse.com/sdk"), "root", "password", true);
            long end = System.currentTimeMillis();
            clazz.logger.info("time taken: " + (end-start) + "ms");
            Folder rootFolder = si.getRootFolder();
            ManagedEntity me = new InventoryNavigator(rootFolder).searchManagedEntity("VirtualMachine", "centos-jeos");
            VirtualMachine vm = (VirtualMachine) me;

            VirtualMachineConfigSpec configSpec = new VirtualMachineConfigSpec();
            configSpec.setMemoryMB(new Long("1024"));
            configSpec.setNumCPUs(new Integer("1"));

            VirtualMachineCloneSpec cloneSpec = new VirtualMachineCloneSpec();
            VirtualMachineRelocateSpec relocateSpec = new VirtualMachineRelocateSpec();
            //relocateSpec.diskMoveType = "createNewChildDiskBacking";
            cloneSpec.setConfig(configSpec);
            cloneSpec.setLocation(relocateSpec);
            cloneSpec.setPowerOn(true);
            cloneSpec.setTemplate(false);
            // cloneSpec.snapshot = vm.getRootSnapshot()[0].getMOR();
            clazz.logger.info("Cloning " + vm.getName() + " into " + cloneName);
            Folder f = (Folder) new InventoryNavigator(rootFolder).searchManagedEntity("Folder", "Administrative");
            Task task = vm.cloneVM_Task(f, cloneName, cloneSpec );
            String status = task.waitForTask();
            if (status.equals(Task.SUCCESS)) {
                clazz.logger.info("Cloned Successfully!");
            } else {
                throw new Exception("Cloning Error");
            }

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
