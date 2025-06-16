package com.github.diegopacheco.sandboxspring.repository;

import com.github.diegopacheco.sandboxspring.model.Audit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AuditRepository extends CrudRepository<Audit, Integer> {
    List<Audit> findAll();
    List<Audit> findByUserId(String userId);
    List<Audit> findByEventContaining(String eventText);
}