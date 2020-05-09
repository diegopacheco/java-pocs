package com.github.diegopacheco.sandboxspring.repo;

import com.github.diegopacheco.sandboxspring.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, String> {}