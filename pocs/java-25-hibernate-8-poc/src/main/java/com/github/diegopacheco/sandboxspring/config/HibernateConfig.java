package com.github.diegopacheco.sandboxspring.config;

import com.github.diegopacheco.sandboxspring.model.Person;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class HibernateConfig {

    @Value("${app.db.url}")
    private String url;

    @Value("${app.db.username}")
    private String username;

    @Value("${app.db.password}")
    private String password;

    @Value("${app.db.ddl-auto}")
    private String ddlAuto;

    @Value("${app.db.show-sql}")
    private boolean showSql;

    @Value("${app.db.pool-size}")
    private int poolSize;

    @Bean(destroyMethod = "close")
    public SessionFactory sessionFactory() {
        return new Configuration()
                .setProperty("hibernate.connection.provider_class", "org.hibernate.hikaricp.internal.HikariCPConnectionProvider")
                .setProperty("hibernate.connection.url", url)
                .setProperty("hibernate.connection.username", username)
                .setProperty("hibernate.connection.password", password)
                .setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
                .setProperty("hibernate.hikari.maximumPoolSize", String.valueOf(poolSize))
                .setProperty("hibernate.hikari.minimumIdle", "2")
                .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                .setProperty("hibernate.hbm2ddl.auto", ddlAuto)
                .setProperty("hibernate.show_sql", showSql)
                .setProperty("hibernate.format_sql", showSql)
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();
    }
}
