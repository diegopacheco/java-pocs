package com.github.diegopacheco.cpparty.conf;

import com.github.diegopacheco.cpparty.adapter.C3P0DSAdapter;
import com.github.diegopacheco.cpparty.adapter.HikariConfigAdapter;
import com.github.diegopacheco.cpparty.adapter.HikariDSAdapter;
import com.mchange.v2.c3p0.AbstractComboPooledDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.PooledDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.dbcp2.*;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectState;
import org.apache.commons.pool2.impl.EvictionConfig;
import org.apache.commons.pool2.impl.EvictionPolicy;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableScheduling
public class DBConfiguration {

    @Primary
    @Bean(name = "dataSource")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON) // Singleton is the default, but I just want to be explicit
    public DataSource getDataSource(){
        System.out.println("New DataSource requested...");
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl( "jdbc:mysql://127.0.0.1:3325/person" );
        config.setUsername( "root" );
        config.setPassword( "pass" );
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        HikariDataSource ds = new HikariDataSource( new HikariConfigAdapter(config));
        return new HikariDSAdapter(ds);
    }

    @Bean(name = "dataSourceC3P0")
    public AbstractComboPooledDataSource get3cp0DataSource() throws PropertyVetoException {
        System.out.println("New 3cp0 DataSource requested...");
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setJdbcUrl( "jdbc:mysql://127.0.0.1:3325/person" );
        cpds.setUser("root");
        cpds.setPassword("pass");
        cpds.setDriverClass("com.mysql.cj.jdbc.Driver");

        // not working
        //return new C3P0DSAdapter(cpds);
        return cpds;
    }

    // Apache DBCP 2
    @Bean(name = "dataSourceDBCP")
    public PoolingDataSource<PoolableConnection> getDbcpDtaSource(GenericObjectPool<PoolableConnection> connectionPool){
        System.out.println("New DBCP DataSource requested...");
        PoolingDataSource<PoolableConnection> dataSource = new PoolingDataSource<>(connectionPool);
        return dataSource;
    }

    // Apache DBCP 2
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
