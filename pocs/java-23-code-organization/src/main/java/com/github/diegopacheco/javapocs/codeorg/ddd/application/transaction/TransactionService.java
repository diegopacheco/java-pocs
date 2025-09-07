package com.github.diegopacheco.javapocs.codeorg.ddd.application.transaction;

import com.github.diegopacheco.javapocs.codeorg.ddd.domain.transaction.*;
import com.github.diegopacheco.javapocs.codeorg.ddd.domain.user.UserId;
import com.github.diegopacheco.javapocs.codeorg.ddd.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    
    @Autowired
    public TransactionService(TransactionRepository transactionRepository, UserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
    }
    
    public Transaction createCreditTransaction(String userId, BigDecimal amount, String notes) {
        UserId userIdVO = UserId.of(userId);
        
        if (!userRepository.findById(userIdVO).isPresent()) {
            throw new IllegalArgumentException("User not found: " + userId);
        }
        
        Amount amountVO = Amount.of(amount);
        Transaction transaction = Transaction.createCredit(userIdVO, amountVO, notes);
        
        return transactionRepository.save(transaction);
    }
    
    public Transaction createDebitTransaction(String userId, BigDecimal amount, String notes) {
        UserId userIdVO = UserId.of(userId);
        
        if (!userRepository.findById(userIdVO).isPresent()) {
            throw new IllegalArgumentException("User not found: " + userId);
        }
        
        Amount amountVO = Amount.of(amount);
        Transaction transaction = Transaction.createDebit(userIdVO, amountVO, notes);
        
        return transactionRepository.save(transaction);
    }
    
    public Optional<Transaction> findTransactionById(String transactionId) {
        return transactionRepository.findById(TransactionId.of(transactionId));
    }
    
    public List<Transaction> findTransactionsByUserId(String userId) {
        return transactionRepository.findByUserId(UserId.of(userId));
    }
    
    public List<Transaction> findCreditTransactions() {
        return transactionRepository.findByType(TransactionType.CREDIT);
    }
    
    public List<Transaction> findDebitTransactions() {
        return transactionRepository.findByType(TransactionType.DEBIT);
    }
    
    public List<Transaction> findTransactionsByUserIdAndType(String userId, String type) {
        UserId userIdVO = UserId.of(userId);
        TransactionType typeVO = TransactionType.fromString(type);
        return transactionRepository.findByUserIdAndType(userIdVO, typeVO);
    }
    
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
    
    public Transaction updateTransactionNotes(String transactionId, String notes) {
        TransactionId transactionIdVO = TransactionId.of(transactionId);
        Transaction transaction = transactionRepository.findById(transactionIdVO)
                .orElseThrow(() -> new IllegalArgumentException("Transaction not found: " + transactionId));
        
        transaction.updateNotes(notes);
        return transactionRepository.save(transaction);
    }
    
    public void deleteTransaction(String transactionId) {
        TransactionId transactionIdVO = TransactionId.of(transactionId);
        if (!transactionRepository.findById(transactionIdVO).isPresent()) {
            throw new IllegalArgumentException("Transaction not found: " + transactionId);
        }
        transactionRepository.deleteById(transactionIdVO);
    }
    
    public BigDecimal calculateUserBalance(String userId) {
        List<Transaction> transactions = findTransactionsByUserId(userId);
        
        return transactions.stream()
                .map(transaction -> {
                    BigDecimal amount = transaction.getAmount().value();
                    return transaction.isCredit() ? amount : amount.negate();
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}