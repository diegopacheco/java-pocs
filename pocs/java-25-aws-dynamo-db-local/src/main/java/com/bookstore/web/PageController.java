package com.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.v3.oas.annotations.Hidden;

@Controller
@Hidden
public class PageController {

    @GetMapping("/")
    public String home() {
        return "redirect:/swagger-ui/index.html";
    }

    @GetMapping("/swagger")
    public String swagger() {
        return "redirect:/swagger-ui/index.html";
    }

    @GetMapping("/swagger-ui")
    public String swaggerUi() {
        return "redirect:/swagger-ui/index.html";
    }

    @GetMapping("/sql-console")
    public String sqlConsole() {
        return "redirect:/sql-console.html";
    }
}
