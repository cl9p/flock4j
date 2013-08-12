package com.cl9p.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(targetNamespace = "http://flock4j.cl9p.com/services")
public interface VirtualMachineManagementService {

    @WebMethod
    public void cloneVirtualMachine();

}
