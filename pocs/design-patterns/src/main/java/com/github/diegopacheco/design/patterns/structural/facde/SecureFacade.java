package com.github.diegopacheco.design.patterns.structural.facde;

// Facade
public class SecureFacade {

    private Encryptor encryptor;
    private Decryptor decryptor;
    private Hasher hasher;
    private KeyHolder keyHolder;

    public SecureFacade(){
        this.encryptor = new Encryptor();
        this.decryptor = new Decryptor();
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

    public SecurePerson decrypt(String ciphertextName,String password){

        KeyMaterial keyMaterial = keyHolder.getKey("appx.person.name");

        String name = decryptor.decrypt(ciphertextName,keyMaterial.getKey(),keyMaterial.getIv());

        return SecurePerson.from(name,password);
    }

}
