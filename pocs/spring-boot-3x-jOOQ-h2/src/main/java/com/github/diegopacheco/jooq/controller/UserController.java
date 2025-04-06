package com.github.diegopacheco.jooq.controller;

import com.github.diegopacheco.jooq.model.UserDTO;
import com.github.diegopacheco.jooq.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<UserDTO> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable Integer id) {
        return repository.findById(id);
    }

    @PostMapping
    public UserDTO create(@RequestBody UserDTO request) {
        return repository.create(request.name());
    }

    @PutMapping("/{id}")
    public UserDTO update(@PathVariable Integer id, @RequestBody UserDTO request) {
        return repository.update(id, request.name());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.delete(id);
    }
}