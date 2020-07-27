package com.github.diegopacheco.javapocs.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Entity
@NamedQuery(name="Gift.findAll", query="SELECT g FROM Gift g")
@XmlRootElement
public class Gift extends PanacheEntity {

    private String name;
    private boolean active;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    public static Gift findByName(String name){
        if ("".equals(name)){
            throw new IllegalArgumentException("Name cannot be null nor empty");
        }
        return find("name", name).firstResult();
    }

    public static List<Gift> findAlive(){
        return list("active",true);
    }

    public static void delete(String name){
        if ("".equals(name)){
            throw new IllegalArgumentException("Name cannot be null nor empty");
        }
        delete("name", name);
    }

}