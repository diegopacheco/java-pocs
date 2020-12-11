package com.github.diegopacheco.sandboxspring.service;

import com.github.diegopacheco.sandboxspring.dao.PetRepository;
import com.github.diegopacheco.sandboxspring.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SimplePetService implements PetService{

    @Autowired
    private PetRepository petRepository;

    @Override
    public Pet getPetById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet getPetByName(String name) {
        return petRepository.findByName(name);
    }

    @Override
    public boolean exists(String name) {
        if (petRepository.findByName(name) != null) {
            return true;
        }
        return false;
    }

    @Override
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }
}