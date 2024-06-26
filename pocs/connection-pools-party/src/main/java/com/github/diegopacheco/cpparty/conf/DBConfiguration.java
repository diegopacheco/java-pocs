package com.github.diegopacheco.cpparty.conf;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.dbcp2.*;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectState;
import org.apache.commons.pool2.impl.EvictionConfig;
import org.apache.commons.pool2.impl.EvictionPolicy;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.util.Properties;

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

    @Bean(name = "dataSourceC3P0")
    public DataSource get3cp0DataSource(){
        System.out.println("New 3cp0 DataSource requested...");
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setJdbcUrl( "jdbc:mysql://127.0.0.1:3325/person" );
        cpds.setUser("root");
        cpds.setPassword("pass");
        return cpds;
    }

    @Bean(name = "dataSourceDBCP")
    public DataSource getDbcpDtaSource(GenericObjectPool<PoolableConnection> connectionPool){
        System.out.println("New DBCP DataSource requested...");
        PoolingDataSource<PoolableConnection> dataSource = new PoolingDataSource<>(connectionPool);
        return dataSource;
    }

    @Bean
    public GenericObjectPool<PoolableConnection> getDbcpPool() {
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "pass");

        ConnectionFactory cf = new DriverManagerConnectionFactory("jdbc:mysql://127.0.0.1:3325/person", props);
        PoolableConnectionFactory poolCF =  new PoolableConnectionFactory(cf, null);
        GenericObjectPool<PoolableConnection> connectionPool =  new GenericObjectPool<>(poolCF);
        poolCF.setPool(connectionPool);

        connectionPool.setEvictionPolicy(new EvictionPolicy<PoolableConnection>() {
            @Override
            public boolean evict(EvictionConfig config, PooledObject<PoolableConnection> underTest, int idleCount) {
                if (PooledObjectState.IDLE == underTest.getState() ||
                    PooledObjectState.EVICTION == underTest.getState()
                ){
                    return true;
                }
                return false;
            }
        });
        return connectionPool;
    }

    // default to Hikari DS
    @Bean(name = "transactionManager")
    public PlatformTransactionManager txManager(@Qualifier("dataSource") DataSource ds) {
        System.out.println("New TXManager requested...");
        return new DataSourceTransactionManager(ds);
    }

    // default to Hikari DS
    @Bean
    public JdbcTemplate getJDBCTemplate(@Qualifier("dataSource") DataSource ds){
        System.out.println("New JdbcTemplate requested...");
        return new JdbcTemplate(ds);
    }

}
