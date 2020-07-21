package com.github.diegopacheco.sadbox.java.jpasimple.audit;

import com.github.diegopacheco.sadbox.java.jpasimple.model.Contact;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class AuditListener {

    @PrePersist
    public void setCreatedOn(Contact contact) {
        System.out.println("Pre-Persist on :" + contact);
    }

    @PreUpdate
    public void setUpdatedOn(Contact contact) {
        System.out.println("Pre-Update on :" + contact);
    }

}
