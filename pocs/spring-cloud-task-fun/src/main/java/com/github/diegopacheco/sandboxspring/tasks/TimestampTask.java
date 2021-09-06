package com.github.diegopacheco.sandboxspring.tasks;

import com.github.diegopacheco.sandboxspring.config.TimestampTaskProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampTask implements CommandLineRunner {

    @Autowired
    private TimestampTaskProperties config;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("[TimestampTask] Running: TimestampTask");
        DateFormat dateFormat = new SimpleDateFormat(this.config.getFormat());
        System.out.println("[TimestampTask] " + dateFormat.format(new Date()));

    }
}
