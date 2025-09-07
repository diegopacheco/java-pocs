package com.github.diegopacheco.javapocs.codeorg.ddd.domain.preference;

import com.github.diegopacheco.javapocs.codeorg.ddd.domain.user.UserId;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Objects;

@Table("preferences")
public class Preference {
    
    @Id
    private String id;
    
    private String userid;
    
    @Column("is_active")
    private boolean isActive;
    
    @Column("sol_version")
    private String solVersion;
    
    @Column("created_at")
    private LocalDateTime createdAt;
    
    @Column("updated_at")
    private LocalDateTime updatedAt;
    
    public Preference() {
    }
    
    public Preference(PreferenceId id, UserId userId, boolean isActive, SolVersion solVersion) {
        this.id = Objects.requireNonNull(id, "Preference ID cannot be null").value();
        this.userid = Objects.requireNonNull(userId, "User ID cannot be null").value();
        this.isActive = isActive;
        this.solVersion = solVersion != null ? solVersion.value() : null;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    
    public static Preference create(UserId userId, boolean isActive, SolVersion solVersion) {
        return new Preference(PreferenceId.generate(), userId, isActive, solVersion);
    }
    
    public void activate() {
        this.isActive = true;
        this.updatedAt = LocalDateTime.now();
    }
    
    public void deactivate() {
        this.isActive = false;
        this.updatedAt = LocalDateTime.now();
    }
    
    public void updateSolVersion(SolVersion newSolVersion) {
        this.solVersion = newSolVersion != null ? newSolVersion.value() : null;
        this.updatedAt = LocalDateTime.now();
    }
    
    public PreferenceId getPreferenceId() {
        return PreferenceId.of(id);
    }
    
    public UserId getUserId() {
        return UserId.of(userid);
    }
    
    public boolean isActive() {
        return isActive;
    }
    
    public SolVersion getSolVersion() {
        return solVersion != null ? SolVersion.of(solVersion) : null;
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
}