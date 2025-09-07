package com.github.diegopacheco.javapocs.codeorg.ddd.infrastructure.persistence;

import com.github.diegopacheco.javapocs.codeorg.ddd.domain.transaction.Transaction;
import com.github.diegopacheco.javapocs.codeorg.ddd.domain.transaction.TransactionId;
import com.github.diegopacheco.javapocs.codeorg.ddd.domain.transaction.TransactionRepository;
import com.github.diegopacheco.javapocs.codeorg.ddd.domain.transaction.TransactionType;
import com.github.diegopacheco.javapocs.codeorg.ddd.domain.user.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {
    
    private final SpringDataTransactionRepository springDataTransactionRepository;
    
    @Autowired
    public TransactionRepositoryImpl(SpringDataTransactionRepository springDataTransactionRepository) {
        this.springDataTransactionRepository = springDataTransactionRepository;
    }
    
    @Override
    public Transaction save(Transaction transaction) {
        return springDataTransactionRepository.save(transaction);
    }
    
    @Override
    public Optional<Transaction> findById(TransactionId transactionId) {
        return springDataTransactionRepository.findById(transactionId.value());
    }
    
    @Override
    public List<Transaction> findByUserId(UserId userId) {
        return springDataTransactionRepository.findByUserId(userId.value());
    }
    
    @Override
    public List<Transaction> findByType(TransactionType type) {
        return springDataTransactionRepository.findByType(type.getValue());
    }
    
    @Override
    public List<Transaction> findByUserIdAndType(UserId userId, TransactionType type) {
        return springDataTransactionRepository.findByUserIdAndType(userId.value(), type.getValue());
    }
    
    @Override
    public List<Transaction> findAll() {
        return StreamSupport.stream(springDataTransactionRepository.findAll().spliterator(), false)
                .toList();
    }
    
    @Override
    public void deleteById(TransactionId transactionId) {
        springDataTransactionRepository.deleteById(transactionId.value());
    }
}