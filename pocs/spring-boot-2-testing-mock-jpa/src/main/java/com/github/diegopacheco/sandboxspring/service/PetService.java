package com.github.diegopacheco.sandboxspring.service;

import com.github.diegopacheco.sandboxspring.model.Pet;

import java.util.List;

public interface PetService {
    Pet getPetById(Long id);
    Pet getPetByName(String name);
    List<Pet> getAllPets();
    boolean exists(String email);
    Pet save(Pet pet);
}