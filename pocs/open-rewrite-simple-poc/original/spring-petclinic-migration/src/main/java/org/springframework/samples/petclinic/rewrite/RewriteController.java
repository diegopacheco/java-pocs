package org.springframework.samples.petclinic.rewrite;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/rewrite")
public class RewriteController {

    @GetMapping("/version")
    public String getRewriteVersion() {
        return "7.x";
    }
}
