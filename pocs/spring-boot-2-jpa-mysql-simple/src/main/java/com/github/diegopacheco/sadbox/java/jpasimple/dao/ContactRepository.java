package com.github.diegopacheco.sadbox.java.jpasimple.dao;

import com.github.diegopacheco.sadbox.java.jpasimple.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{}