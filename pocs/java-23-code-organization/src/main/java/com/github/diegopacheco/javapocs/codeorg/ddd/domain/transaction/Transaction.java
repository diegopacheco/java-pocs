package com.github.diegopacheco.javapocs.codeorg.ddd.domain.transaction;

import com.github.diegopacheco.javapocs.codeorg.ddd.domain.user.UserId;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Table("transactions")
public class Transaction {
    
    @Id
    private String id;
    
    @Column("user_id")
    private String userId;
    
    private BigDecimal amount;
    
    private String type;
    
    private String notes;
    
    @Column("created_at")
    private LocalDateTime createdAt;
    
    @Column("updated_at")
    private LocalDateTime updatedAt;
    
    public Transaction() {
    }
    
    public Transaction(TransactionId id, UserId userId, Amount amount, TransactionType type, String notes) {
        this.id = Objects.requireNonNull(id, "Transaction ID cannot be null").value();
        this.userId = Objects.requireNonNull(userId, "User ID cannot be null").value();
        this.amount = Objects.requireNonNull(amount, "Amount cannot be null").value();
        this.type = Objects.requireNonNull(type, "Transaction type cannot be null").getValue();
        this.notes = notes;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    
    public static Transaction createCredit(UserId userId, Amount amount, String notes) {
        return new Transaction(TransactionId.generate(), userId, amount, TransactionType.CREDIT, notes);
    }
    
    public static Transaction createDebit(UserId userId, Amount amount, String notes) {
        return new Transaction(TransactionId.generate(), userId, amount, TransactionType.DEBIT, notes);
    }
    
    public void updateNotes(String newNotes) {
        this.notes = newNotes;
        this.updatedAt = LocalDateTime.now();
    }
    
    public TransactionId getTransactionId() {
        return TransactionId.of(id);
    }
    
    public UserId getUserId() {
        return UserId.of(userId);
    }
    
    public Amount getAmount() {
        return Amount.of(amount);
    }
    
    public TransactionType getType() {
        return TransactionType.fromString(type);
    }
    
    public String getNotes() {
        return notes;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public String getId() {
        return id;
    }
    
    public boolean isCredit() {
        return TransactionType.CREDIT.equals(getType());
    }
    
    public boolean isDebit() {
        return TransactionType.DEBIT.equals(getType());
    }
}