package com.cl9p.controllers;

import com.cl9p.model.Command;
import com.cl9p.services.CommandServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
public class CommandController {

    @RequestMapping(value = "/adhoc", method = RequestMethod.GET)
    public String home(Model model) throws IOException {
        CommandServiceImpl commandService = new CommandServiceImpl();
        model.addAttribute("cmdResult", commandService.execute(new Command()));
        return "adhoc";
    }
}
