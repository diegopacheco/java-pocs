package com.github.diegopacheco.javapocs.codeorg.ddd.domain.preference;

import com.github.diegopacheco.javapocs.codeorg.ddd.domain.user.UserId;

import java.util.List;
import java.util.Optional;

public interface PreferenceRepository {
    Preference save(Preference preference);
    Optional<Preference> findById(PreferenceId preferenceId);
    List<Preference> findByUserId(UserId userId);
    List<Preference> findAll();
    List<Preference> findByIsActive(boolean isActive);
    void deleteById(PreferenceId preferenceId);
}