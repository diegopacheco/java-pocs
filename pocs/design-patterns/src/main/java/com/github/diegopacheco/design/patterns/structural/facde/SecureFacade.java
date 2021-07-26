package com.github.diegopacheco.design.patterns.structural.facde;

import javax.crypto.SecretKey;

// Facade
public class SecureFacade {

    private Encryptor encryptor;
    private Hasher hasher;
    private KeyHolder keyHolder;

    public SecureFacade(){
        this.encryptor = new Encryptor();
        this.hasher = new Hasher();
        this.keyHolder = new KeyHolder();
    }

    public SecurePerson encrypt(String name,String password){

        KeyMaterial keyMaterial = keyHolder.getKey("appx.person.name");

        String encName = encryptor.encrypt(name,
                keyMaterial.getKey(),keyMaterial.getIv());

        String encPassword = hasher.hash(password);

        return SecurePerson.from(encName,encPassword);
    }

}
