package com.github.diegopacheco.javapocs.codeorg.ddd.infrastructure.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;

import com.github.diegopacheco.javapocs.codeorg.ddd.domain.transaction.Transaction;

import java.util.List;

public interface SpringDataTransactionRepository extends CrudRepository<Transaction, String> {
    
    @Query("SELECT * FROM transactions WHERE user_id = :userId")
    List<Transaction> findByUserId(@Param("userId") String userId);
    
    @Query("SELECT * FROM transactions WHERE type = :type")
    List<Transaction> findByType(@Param("type") String type);
    
    @Query("SELECT * FROM transactions WHERE user_id = :userId AND type = :type")
    List<Transaction> findByUserIdAndType(@Param("userId") String userId, @Param("type") String type);
}