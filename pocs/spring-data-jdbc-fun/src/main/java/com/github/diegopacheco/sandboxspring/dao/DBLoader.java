package com.github.diegopacheco.sandboxspring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DBLoader {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertData() {
        try{
            jdbcTemplate.execute("INSERT INTO person(first_name,last_name) VALUES('Victor', 'Hugo')");
            jdbcTemplate.execute("INSERT INTO person(first_name,last_name) VALUES('Dante', 'Alighieri')");
            jdbcTemplate.execute("INSERT INTO person(first_name,last_name) VALUES('Stefan', 'Zweig')");
            jdbcTemplate.execute("INSERT INTO person(first_name,last_name) VALUES('Oscar', 'Wilde')");
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
