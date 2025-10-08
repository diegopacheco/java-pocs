package com.github.diegopacheco.javapocs.debezium;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
public class DataController {

    @Autowired
    private DataEventRepository repository;

    @GetMapping("/generate")
    public DataEvent generate() {
        String randomData = "Data-" + UUID.randomUUID().toString();
        DataEvent event = new DataEvent(randomData);
        return repository.save(event);
    }

    @GetMapping("/getdata")
    public List<DataEvent> getData() {
        return repository.findAll();
    }
}
