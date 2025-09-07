package com.github.diegopacheco.javapocs.codeorg.ddd.infrastructure.web;

import com.github.diegopacheco.javapocs.codeorg.ddd.application.preference.PreferenceService;
import com.github.diegopacheco.javapocs.codeorg.ddd.domain.preference.Preference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/preferences")
public class PreferenceController {
    
    private final PreferenceService preferenceService;
    
    @Autowired
    public PreferenceController(PreferenceService preferenceService) {
        this.preferenceService = preferenceService;
    }
    
    @PostMapping
    public ResponseEntity<Preference> createPreference(@RequestBody Map<String, Object> request) {
        try {
            String userId = (String) request.get("userId");
            Boolean isActive = (Boolean) request.getOrDefault("isActive", true);
            String solVersion = (String) request.get("solVersion");
            
            Preference preference = preferenceService.createPreference(userId, isActive, solVersion);
            return new ResponseEntity<>(preference, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Preference> getPreferenceById(@PathVariable String id) {
        Optional<Preference> preference = preferenceService.findPreferenceById(id);
        return preference.map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Preference>> getPreferencesByUserId(@PathVariable String userId) {
        List<Preference> preferences = preferenceService.findPreferencesByUserId(userId);
        return new ResponseEntity<>(preferences, HttpStatus.OK);
    }
    
    @GetMapping("/active")
    public ResponseEntity<List<Preference>> getActivePreferences() {
        List<Preference> preferences = preferenceService.findActivePreferences();
        return new ResponseEntity<>(preferences, HttpStatus.OK);
    }
    
    @GetMapping("/inactive")
    public ResponseEntity<List<Preference>> getInactivePreferences() {
        List<Preference> preferences = preferenceService.findInactivePreferences();
        return new ResponseEntity<>(preferences, HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<List<Preference>> getAllPreferences() {
        List<Preference> preferences = preferenceService.getAllPreferences();
        return new ResponseEntity<>(preferences, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Preference> updatePreference(@PathVariable String id, @RequestBody Map<String, Object> request) {
        try {
            Boolean isActive = (Boolean) request.get("isActive");
            String solVersion = (String) request.get("solVersion");
            
            Preference preference = preferenceService.updatePreference(id, isActive, solVersion);
            return new ResponseEntity<>(preference, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePreference(@PathVariable String id) {
        try {
            preferenceService.deletePreference(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}