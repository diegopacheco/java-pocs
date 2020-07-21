package com.github.diegopacheco.sadbox.java.jpasimple.model;

import com.github.diegopacheco.sadbox.java.jpasimple.audit.AuditListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EntityListeners(AuditListener.class)
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;
    private String email;
    private String phone;
}