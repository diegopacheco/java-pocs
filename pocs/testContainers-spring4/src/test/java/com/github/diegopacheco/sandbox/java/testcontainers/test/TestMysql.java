package com.github.diegopacheco.sandbox.java.testcontainers.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testcontainers.containers.MySQLContainer;

import com.github.diegopacheco.sandbox.java.testcontainers.AppConfig;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@SuppressWarnings({"rawtypes"})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class TestMysql {

	@Test
	public void testSimple() throws Throwable {
		
		MySQLContainer mysql = new MySQLContainer();
		mysql.start();
		
		try {
			tryExecute(mysql);
		} finally {
			mysql.stop();
		}
	}
	
	private void tryExecute(MySQLContainer mysql) {
		try{
			
			ResultSet resultSet = performQuery(mysql,"SELECT 1");
			int resultSetInt = resultSet.getInt(1);
			Assert.assertEquals("A basic SELECT query succeeds", 1, resultSetInt);
			
			System.out.println("It works: " + resultSetInt);
			System.out.println("DONE");
		}catch(Exception e){
			System.out.println("Error " + e);
			Assert.fail(e.toString());
		}
	}
	
    protected ResultSet performQuery(MySQLContainer mysql,String sql) throws SQLException {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(mysql.getJdbcUrl());
        hikariConfig.setUsername(mysql.getUsername());
        hikariConfig.setPassword(mysql.getPassword());

        HikariDataSource ds = new HikariDataSource(hikariConfig);
        Statement statement = ds.getConnection().createStatement();
        statement.execute(sql);
        ResultSet resultSet = statement.getResultSet();

        resultSet.next();
        ResultSet rs = resultSet;
        ds.close();
        return rs;
    }

}
