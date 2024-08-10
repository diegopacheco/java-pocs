package com.github.diegopacheco.sandboxspring.controller;

import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class MetricsController {

    @Autowired
    MeterRegistry registry;

    @RequestMapping("/metrics")
    public String metrics() {

        List<String> ignore = Arrays.asList("process.cpu.time","jvm.threads.started","executor.completed",
                                            "jvm.classes.unloaded","tomcat.sessions.rejected",
                                            "tomcat.sessions.created","jvm.compilation.time",
                                            "tomcat.sessions.expired");

        registry.getMeters().forEach(m -> {
            System.out.println("metric: " + m.getId().getName());

            if (!ignore.contains(m.getId().getName())) {
                Meter.Type type = m.getId().getType();
                if (type == Meter.Type.COUNTER) {
                    System.out.println("value: " + registry.get(m.getId().getName()).counter().count());
                } else if (type == Meter.Type.GAUGE) {
                    System.out.println("value: " + registry.get(m.getId().getName()).gauge().value());
                }else{
                    System.out.println("type: " + type + " - ignored");
                }
            }

        });
        return registry.counter("jvm.buffer.memory.used").toString();
    }

}
