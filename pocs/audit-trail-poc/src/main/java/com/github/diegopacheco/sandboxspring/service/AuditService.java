package com.github.diegopacheco.sandboxspring.service;

import com.github.diegopacheco.sandboxspring.model.Audit;
import com.github.diegopacheco.sandboxspring.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AuditService {

    private final AuditRepository auditRepository;

    @Autowired
    public AuditService(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    public void logEvent(String event, String userId) {
        Audit audit = new Audit(event, userId);
        auditRepository.save(audit);
    }

    public List<Audit> findAllAudits() {
        return StreamSupport.stream(auditRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public List<Audit> findAuditsByUserId(String userId) {
        return auditRepository.findByUserId(userId);
    }

    public List<Audit> findAuditsByEventText(String text) {
        return auditRepository.findByEventContaining(text);
    }
}