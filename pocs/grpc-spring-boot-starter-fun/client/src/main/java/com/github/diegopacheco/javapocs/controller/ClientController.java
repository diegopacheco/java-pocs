package com.github.diegopacheco.javapocs.controller;

import com.github.diegopacheco.javapocs.client.gRPCClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    private gRPCClientService foobarService;

    @RequestMapping("/")
    public String printMessage(@RequestParam(defaultValue = "Hello") String name) {
        return foobarService.receiveGreeting(name);
    }

}
