package com.github.diegopacheco.hibernate.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Contact {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name="tableGen", strategy="com.github.diegopacheco.hibernate.sequence.SimpleTableGeneratorStrategy",
            parameters={
                    @Parameter(name = org.hibernate.id.enhanced.TableGenerator.TABLE_PARAM, value = "my_table_sequence"),
                    @Parameter(name = org.hibernate.id.enhanced.TableGenerator.SEGMENT_COLUMN_PARAM, value = "name"),
                    @Parameter(name = org.hibernate.id.enhanced.TableGenerator.VALUE_COLUMN_PARAM, value = "value"),
                    @Parameter(name = org.hibernate.id.enhanced.TableGenerator.SEGMENT_VALUE_PARAM, value = "my_seq_val_seq")
            }
    )
    @GeneratedValue(strategy= GenerationType.TABLE, generator="tableGen")
    private Long id;

    @Column(name="name")
    private String name;
    private String email;
    private String phone;

    public Contact(){}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(id, contact.id) && Objects.equals(name, contact.name) && Objects.equals(email, contact.email) && Objects.equals(phone, contact.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, phone);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}