package com.github.diegopacheco.javapocs.codeorg.ddd.domain.transaction;

import com.github.diegopacheco.javapocs.codeorg.ddd.domain.user.UserId;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository {
    Transaction save(Transaction transaction);
    Optional<Transaction> findById(TransactionId transactionId);
    List<Transaction> findByUserId(UserId userId);
    List<Transaction> findByType(TransactionType type);
    List<Transaction> findByUserIdAndType(UserId userId, TransactionType type);
    List<Transaction> findAll();
    void deleteById(TransactionId transactionId);
}