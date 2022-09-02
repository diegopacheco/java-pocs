package com.github.diegopacheco.sandboxspring.dao;

import com.github.diegopacheco.sandboxspring.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {}