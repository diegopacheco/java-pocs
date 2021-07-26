package com.github.diegopacheco.design.patterns.structural.facde;

import java.util.Objects;

public class SecurePerson {

    private String encryptedName;
    private String password;

    public SecurePerson(String encryptedName, String password) {
        this.encryptedName = encryptedName;
        this.password = password;
    }

    public String getEncryptedName() {
        return encryptedName;
    }
    public String getPassword() {
        return password;
    }

    public static SecurePerson from(String encryptedName, String password){
        return new SecurePerson(encryptedName,password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecurePerson that = (SecurePerson) o;
        return Objects.equals(encryptedName, that.encryptedName) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(encryptedName, password);
    }

    @Override
    public String toString() {
        return "SecurePerson{" +
                "encryptedName='" + encryptedName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
