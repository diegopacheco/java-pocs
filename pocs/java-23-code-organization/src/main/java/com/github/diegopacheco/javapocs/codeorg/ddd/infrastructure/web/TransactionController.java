package com.github.diegopacheco.javapocs.codeorg.ddd.infrastructure.web;

import com.github.diegopacheco.javapocs.codeorg.ddd.application.transaction.TransactionService;
import com.github.diegopacheco.javapocs.codeorg.ddd.domain.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    
    private final TransactionService transactionService;
    
    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    
    @PostMapping("/credit")
    public ResponseEntity<Transaction> createCreditTransaction(@RequestBody Map<String, Object> request) {
        try {
            String userId = (String) request.get("userId");
            BigDecimal amount = new BigDecimal(request.get("amount").toString());
            String notes = (String) request.get("notes");
            
            Transaction transaction = transactionService.createCreditTransaction(userId, amount, notes);
            return new ResponseEntity<>(transaction, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @PostMapping("/debit")
    public ResponseEntity<Transaction> createDebitTransaction(@RequestBody Map<String, Object> request) {
        try {
            String userId = (String) request.get("userId");
            BigDecimal amount = new BigDecimal(request.get("amount").toString());
            String notes = (String) request.get("notes");
            
            Transaction transaction = transactionService.createDebitTransaction(userId, amount, notes);
            return new ResponseEntity<>(transaction, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable String id) {
        Optional<Transaction> transaction = transactionService.findTransactionById(id);
        return transaction.map(t -> new ResponseEntity<>(t, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Transaction>> getTransactionsByUserId(@PathVariable String userId) {
        List<Transaction> transactions = transactionService.findTransactionsByUserId(userId);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
    
    @GetMapping("/user/{userId}/balance")
    public ResponseEntity<Map<String, BigDecimal>> getUserBalance(@PathVariable String userId) {
        try {
            BigDecimal balance = transactionService.calculateUserBalance(userId);
            return new ResponseEntity<>(Map.of("balance", balance), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/user/{userId}/type/{type}")
    public ResponseEntity<List<Transaction>> getTransactionsByUserIdAndType(
            @PathVariable String userId, 
            @PathVariable String type) {
        try {
            List<Transaction> transactions = transactionService.findTransactionsByUserIdAndType(userId, type);
            return new ResponseEntity<>(transactions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/type/credit")
    public ResponseEntity<List<Transaction>> getCreditTransactions() {
        List<Transaction> transactions = transactionService.findCreditTransactions();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
    
    @GetMapping("/type/debit")
    public ResponseEntity<List<Transaction>> getDebitTransactions() {
        List<Transaction> transactions = transactionService.findDebitTransactions();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
    
    @PutMapping("/{id}/notes")
    public ResponseEntity<Transaction> updateTransactionNotes(@PathVariable String id, @RequestBody Map<String, String> request) {
        try {
            String notes = request.get("notes");
            Transaction transaction = transactionService.updateTransactionNotes(id, notes);
            return new ResponseEntity<>(transaction, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable String id) {
        try {
            transactionService.deleteTransaction(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}