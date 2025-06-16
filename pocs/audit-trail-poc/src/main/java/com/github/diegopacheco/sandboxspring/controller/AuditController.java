package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.model.Audit;
import com.github.diegopacheco.sandboxspring.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audits")
public class AuditController {

    private final AuditService auditService;

    @Autowired
    public AuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    @GetMapping
    public ResponseEntity<List<Audit>> getAllAudits() {
        List<Audit> audits = auditService.findAllAudits();
        return new ResponseEntity<>(audits, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Audit>> searchAudits(@RequestParam String eventText) {
        List<Audit> audits = auditService.findAuditsByEventText(eventText);
        return new ResponseEntity<>(audits, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Audit>> getAuditsByUserId(@PathVariable String userId) {
        if (null==userId || userId.trim().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Audit> audits = auditService.findAuditsByUserId(userId);
        return new ResponseEntity<>(audits, HttpStatus.OK);
    }
}