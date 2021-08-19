package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.metrics.OperationMonitor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MetricsController {

    @RequestMapping("/metrics")
    public Map<String, Object> metrics() {
        return OperationMonitor.dump();
    }

}
