package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.Application;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestartController {

    @RequestMapping("/reboot")
    public void reboot(){
        System.out.println("Going to RESTART the APP!");
        new Thread( () -> {
            Application.restart();
        }).run();
    }

}
