package com.github.diegopacheco.hibernate.conf;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DBConf {

    @Bean
    public DataSource getDataSource(){
        HikariConfig config = new HikariConfig();
        // hibernate.connection.driver_class=com.mysql.cj.jdbc.Driver
        //config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setDriverClassName("com.github.diegopacheco.hibernate.driver.wrapper.MySQLObservableDriver");

        config.setJdbcUrl("jdbc:mysql://127.0.0.1:3325/mydatabase?useSSL=false");
        config.setUsername("root");
        config.setPassword("pass");
        config.addDataSourceProperty("cachePrepStmts" , "true");
        config.addDataSourceProperty("prepStmtCacheSize" , "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit" , "2048");
        HikariDataSource ds = new HikariDataSource( config );
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(getDataSource());
    }

}
