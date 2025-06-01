package com.github.diegopacheco.sandboxspring.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class CODController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot Restful Code on Demand!";
    }

    private final List<String> cars = List.of(
            "Ferrari", "Lamborghini", "Porsche", "Tesla", "BMW",
            "Audi", "Mercedes", "McLaren", "Ford Mustang", "Chevrolet Camaro"
    );

    @GetMapping(value = "/cars/script", produces = "application/javascript")
    public String getCarLoaderScript() {
        return """
                     window.CarLoader = (function() {
                      let nextToken = null;
                
                      async function getNext() {
                        const url = nextToken
                          ? 'http://localhost:8080/cars/next?token=' + encodeURIComponent(nextToken) 
                          : 'http://localhost:8080/cars/next';
                
                        const res = await fetch(url);
                        if (res.ok) {
                          const response = await res.json();
                          if (response._token) {
                            nextToken = response._token;
                            delete response._token;
                          }
                          return response;
                        } else {
                          console.log('No more cars.');
                          return { error: 'No more cars' };
                        }
                      }
                      return { getNext };
                    })();
                """;
    }

    @GetMapping(value = "/cars/next", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getNextCar(@RequestParam(required = false) String token) {
        int i = 0;
        if (token != null) {
            try {
                i = Integer.parseInt(token);
            } catch (NumberFormatException e) {
                return ResponseEntity.badRequest().body(Map.of("error", "Invalid token"));
            }
        }

        if (i >= cars.size()) {
            return ResponseEntity.status(404).body(Map.of("error", "No more cars"));
        }

        Map<String, Object> response = new HashMap<>();
        response.put("name", cars.get(i));
        response.put("_token", String.valueOf(i + 1));
        return ResponseEntity.ok(response);
    }

}

