package com.github.diegopacheco.pocs.seda.controller;

import com.github.diegopacheco.pocs.seda.ff.FeatureFlagManager;
import com.github.diegopacheco.pocs.seda.metrics.MetricsManager;
import com.github.diegopacheco.pocs.seda.pipeline.PipelineManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PipelineController {

    @Autowired
    PipelineManager pipeline;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/stat")
    public Map<String,String> statistics() {
        return MetricsManager.statistics();
    }

    @RequestMapping("/flags")
    public Map<String,String> flags() {
        return FeatureFlagManager.flags();
    }

    @RequestMapping("/flag/{name}/{value}")
    public String changeFlag(@PathVariable("name")  String name,
                             @PathVariable("value") Object value) {
        FeatureFlagManager.set(name,Integer.parseInt(value.toString()));
        return "Flag: " + name + " changed to: " + value;
    }

    @RequestMapping("/events/{amount}")
    public String events(@PathVariable("amount") Integer amount){
        long init = System.currentTimeMillis();
        pipeline.generate(amount);
        long end = System.currentTimeMillis();
        return  amount + " events generated in " + (end-init) + " ms";
    }

}
