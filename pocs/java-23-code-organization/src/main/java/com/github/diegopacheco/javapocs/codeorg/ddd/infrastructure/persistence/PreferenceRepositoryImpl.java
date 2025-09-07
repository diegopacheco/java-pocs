package com.github.diegopacheco.javapocs.codeorg.ddd.infrastructure.persistence;

import com.github.diegopacheco.javapocs.codeorg.ddd.domain.preference.Preference;
import com.github.diegopacheco.javapocs.codeorg.ddd.domain.preference.PreferenceId;
import com.github.diegopacheco.javapocs.codeorg.ddd.domain.preference.PreferenceRepository;
import com.github.diegopacheco.javapocs.codeorg.ddd.domain.user.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Repository
public class PreferenceRepositoryImpl implements PreferenceRepository {
    
    private final SpringDataPreferenceRepository springDataPreferenceRepository;
    
    @Autowired
    public PreferenceRepositoryImpl(SpringDataPreferenceRepository springDataPreferenceRepository) {
        this.springDataPreferenceRepository = springDataPreferenceRepository;
    }
    
    @Override
    public Preference save(Preference preference) {
        return springDataPreferenceRepository.save(preference);
    }
    
    @Override
    public Optional<Preference> findById(PreferenceId preferenceId) {
        return springDataPreferenceRepository.findById(preferenceId.value());
    }
    
    @Override
    public List<Preference> findByUserId(UserId userId) {
        return springDataPreferenceRepository.findByUserId(userId.value());
    }
    
    @Override
    public List<Preference> findAll() {
        return StreamSupport.stream(springDataPreferenceRepository.findAll().spliterator(), false)
                .toList();
    }
    
    @Override
    public List<Preference> findByIsActive(boolean isActive) {
        return springDataPreferenceRepository.findByIsActive(isActive);
    }
    
    @Override
    public void deleteById(PreferenceId preferenceId) {
        springDataPreferenceRepository.deleteById(preferenceId.value());
    }
}