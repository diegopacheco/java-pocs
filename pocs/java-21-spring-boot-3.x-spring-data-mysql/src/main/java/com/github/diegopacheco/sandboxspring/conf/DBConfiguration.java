package com.github.diegopacheco.sandboxspring.conf;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableScheduling
public class DBConfiguration {

    @Bean(name = "dataSource")
    public DataSource getDataSource(){
        System.out.println("New DataSource requested...");
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl( "jdbc:mysql://127.0.0.1:3325/person" );
        config.setUsername( "root" );
        config.setPassword( "pass" );
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        HikariDataSource ds = new HikariDataSource( config );
        return ds;
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager txManager() {
        System.out.println("New TXManager requested...");
        return new DataSourceTransactionManager(getDataSource());
    }

}