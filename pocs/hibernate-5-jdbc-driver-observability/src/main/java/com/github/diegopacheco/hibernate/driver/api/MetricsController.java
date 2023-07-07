package com.github.diegopacheco.hibernate.driver.api;

import com.github.diegopacheco.hibernate.driver.observability.MetricsManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MetricsController {

    @RequestMapping("/metrics")
    @ResponseBody
    public Map<String,String> getStats() {
        return MetricsManager.stats();
    }

}
