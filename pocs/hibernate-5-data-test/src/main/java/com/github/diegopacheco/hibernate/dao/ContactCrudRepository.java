package com.github.diegopacheco.hibernate.dao;

import com.github.diegopacheco.hibernate.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactCrudRepository extends CrudRepository<Contact, Long> {}
