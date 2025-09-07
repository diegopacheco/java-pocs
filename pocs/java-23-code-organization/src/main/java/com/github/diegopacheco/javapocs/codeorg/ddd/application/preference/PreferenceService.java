package com.github.diegopacheco.javapocs.codeorg.ddd.application.preference;

import com.github.diegopacheco.javapocs.codeorg.ddd.domain.preference.*;
import com.github.diegopacheco.javapocs.codeorg.ddd.domain.user.UserId;
import com.github.diegopacheco.javapocs.codeorg.ddd.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PreferenceService {
    
    private final PreferenceRepository preferenceRepository;
    private final UserRepository userRepository;
    
    @Autowired
    public PreferenceService(PreferenceRepository preferenceRepository, UserRepository userRepository) {
        this.preferenceRepository = preferenceRepository;
        this.userRepository = userRepository;
    }
    
    public Preference createPreference(String userId, boolean isActive, String solVersion) {
        UserId userIdVO = UserId.of(userId);
        
        if (!userRepository.findById(userIdVO).isPresent()) {
            throw new IllegalArgumentException("User not found: " + userId);
        }
        
        SolVersion solVersionVO = solVersion != null ? SolVersion.of(solVersion) : null;
        Preference preference = Preference.create(userIdVO, isActive, solVersionVO);
        
        return preferenceRepository.save(preference);
    }
    
    public Optional<Preference> findPreferenceById(String preferenceId) {
        return preferenceRepository.findById(PreferenceId.of(preferenceId));
    }
    
    public List<Preference> findPreferencesByUserId(String userId) {
        return preferenceRepository.findByUserId(UserId.of(userId));
    }
    
    public List<Preference> findActivePreferences() {
        return preferenceRepository.findByIsActive(true);
    }
    
    public List<Preference> findInactivePreferences() {
        return preferenceRepository.findByIsActive(false);
    }
    
    public List<Preference> getAllPreferences() {
        return preferenceRepository.findAll();
    }
    
    public Preference updatePreference(String preferenceId, Boolean isActive, String solVersion) {
        PreferenceId preferenceIdVO = PreferenceId.of(preferenceId);
        Preference preference = preferenceRepository.findById(preferenceIdVO)
                .orElseThrow(() -> new IllegalArgumentException("Preference not found: " + preferenceId));
        
        if (isActive != null) {
            if (isActive) {
                preference.activate();
            } else {
                preference.deactivate();
            }
        }
        
        if (solVersion != null) {
            preference.updateSolVersion(SolVersion.of(solVersion));
        }
        
        return preferenceRepository.save(preference);
    }
    
    public void deletePreference(String preferenceId) {
        PreferenceId preferenceIdVO = PreferenceId.of(preferenceId);
        if (!preferenceRepository.findById(preferenceIdVO).isPresent()) {
            throw new IllegalArgumentException("Preference not found: " + preferenceId);
        }
        preferenceRepository.deleteById(preferenceIdVO);
    }
}