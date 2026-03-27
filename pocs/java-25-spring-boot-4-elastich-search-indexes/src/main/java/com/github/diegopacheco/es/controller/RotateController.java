package com.github.diegopacheco.es.controller;

import com.github.diegopacheco.es.es.RotateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/api/rotate")
public class RotateController {

    private final RotateService rotateService;

    public RotateController(RotateService rotateService) {
        this.rotateService = rotateService;
    }

    @PostMapping("/{date}")
    public ResponseEntity<Map<String, Object>> rotate(@PathVariable String date) throws IOException {
        LocalDate targetDate = LocalDate.parse(date);
        Map<String, Object> result = rotateService.rotate(targetDate);
        return ResponseEntity.ok(result);
    }
}
