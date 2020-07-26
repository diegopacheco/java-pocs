package com.github.diegopacheco.javapocs.service;

import com.github.diegopacheco.javapocs.model.Gift;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class SantaClausService {

    @Inject
    EntityManager em;

    @Transactional
    public void createGift(String giftDescription) {
        Gift gift = new Gift();
        gift.setName(giftDescription);
        em.persist(gift);
    }

    @Transactional
    public Gift[] findAll(){
        return em.createNamedQuery("Gift.findAll", Gift.class).getResultList().toArray(new Gift[0]);
    }

}