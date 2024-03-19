package com.github.diegopacheco.pocs.seda.controller;

import com.github.diegopacheco.pocs.seda.batch.SimpleBatchJob;
import com.github.diegopacheco.pocs.seda.metrics.MetricsManager;
import com.github.diegopacheco.pocs.seda.synthetic.RequestGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BatchController {

    @Autowired
    SimpleBatchJob batch;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/stat")
    public Map<String,String> statistics() {
        return MetricsManager.statistics();
    }

    @RequestMapping("/events/{amount}")
    public String events(@PathVariable("amount") Integer amount){
        long init = System.currentTimeMillis();
        List<String> result = generate(amount);

        result.forEach(batch::submitWork);

        long end = System.currentTimeMillis();
        return  amount + " events generated in " + (end-init) + " ms";
    }

    private List<String> generate(int amount){
        RequestGenerator generator = new RequestGenerator();
        List<String> result = generator.generate(amount);
        System.out.println("* >>> " + amount + " events generated! ");
        return result;
    }

}
