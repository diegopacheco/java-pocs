package com.github.diegopacheco.javapocs.codeorg.ddd.infrastructure.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;

import com.github.diegopacheco.javapocs.codeorg.ddd.domain.preference.Preference;

import java.util.List;

public interface SpringDataPreferenceRepository extends CrudRepository<Preference, String> {
    
    @Query("SELECT * FROM preferences WHERE userid = :userId")
    List<Preference> findByUserId(@Param("userId") String userId);
    
    @Query("SELECT * FROM preferences WHERE is_active = :isActive")
    List<Preference> findByIsActive(@Param("isActive") boolean isActive);
}