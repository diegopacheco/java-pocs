package com.diegopacheco.pgrustfun.sql;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SqlConsolePageController {

    @GetMapping(value = "/sql-console", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public Resource sqlConsole() {
        return new ClassPathResource("static/sql-console.html");
    }
}

