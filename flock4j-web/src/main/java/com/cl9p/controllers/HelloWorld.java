package com.cl9p.controllers;

import com.cl9p.services.VirtualMachineManagementServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
public class HelloWorld {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) throws IOException {
        return "home";
    }
}
