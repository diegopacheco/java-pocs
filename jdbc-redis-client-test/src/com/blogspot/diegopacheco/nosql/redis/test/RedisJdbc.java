package com.blogspot.diegopacheco.nosql.redis.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Sample class made by me to play with redis some testes :D
 * 
 * @author Diego Pacheco
 * @version 1.0
 * @since 04/04/2010 
 *
 */
public class RedisJdbc {
	
	private Connection conn;
	
	private synchronized Connection getConnection(){
		try {
			if (conn==null){
				Class.forName("br.com.svvs.jdbc.redis.RedisDriver");
				conn = DriverManager.getConnection("jdbc:redis://localhost");
			}			
			return conn;
		} catch (Exception e) {			
			throw new RuntimeException(e);
		}              
	}
	
	public String getOneResultItem(Statement stmt){
		try{
			int count = 0;
			ResultSet r = stmt.getResultSet();
			String result = null;
			if (r!=null){
				while(r.next()) {
		        	count++;
		        	result = r.getString(0);
		        }
			}	        
	        if(count==0 || count>=2){
	        	throw new RuntimeException("should return 1 but return more or zero ");
	        }
	        return result; 
		}catch(Exception e){
			throw new RuntimeException(e);
		}		
	}
	
	public List<String> getListResult(Statement stmt){
		try{
			ResultSet r = stmt.getResultSet();
			List<String> result = new ArrayList<String>();
			if (r!=null){
				while(r.next()) {
					result.add(r.getString(0));
		        }
			}	        
	        return result; 
		}catch(Exception e){
			throw new RuntimeException(e);
		}		
	}
	
	public String executeOnRedis(String cmd){
		try{
			Statement statement  = getConnection().createStatement();
			statement.execute(cmd);
			return getOneResultItem(statement);
		}catch(Exception e){
			throw new RuntimeException(e);
		}		
	}
	
	public List<String> executeListOnRedis(String cmd){
		try{
			Statement statement  = getConnection().createStatement();
			statement.execute(cmd);
			return getListResult(statement);
		}catch(Exception e){
			throw new RuntimeException(e);
		}		
	}
	
	public static void main(String[] args) throws Throwable {		
        
		RedisJdbc rj = new RedisJdbc();
		String result = null;
		
		result = rj.executeOnRedis("set diegoKEY pachecoVALUE");
		System.out.println("Result from redis set: " + result);
		
		result = rj.executeOnRedis("get diegoKEY");
        System.out.println("Result from redis get: " + result);
        
        result = rj.executeOnRedis("exists diegoKEY");
        System.out.println("Result from redis exists: " + result);
        
        result = rj.executeOnRedis("randomkey");
        System.out.println("Result from redis randomkey: " + result);
        
        result = rj.executeOnRedis("dbsize");
        System.out.println("Result from redis dbsize: " + result + " keys");
		
        rj.executeOnRedis("incr numIndexDiego");
        result = rj.executeOnRedis("get numIndexDiego");
		System.out.println("Result from redis incr on numIndexDiego: " + result);
		       
		result = rj.executeOnRedis("expire messages 0");
		System.out.println("Result from redis expire on messages: " + result);
		
		result = rj.executeOnRedis("RPUSH messages redis");
		result = rj.executeOnRedis("RPUSH messages diego");
		result = rj.executeOnRedis("RPUSH messages pacheco");
		result = rj.executeOnRedis("RPUSH messages NOSQL");
		result = rj.executeOnRedis("RPUSH messages rocks");
        System.out.println("Result from redis rpush on messages: " + result);
        
		List<String> lResult = rj.executeListOnRedis("lrange messages 0 -1");
        System.out.println("Result from redis lrange on messages: " + lResult);
        
        
		try{
			result = rj.executeOnRedis("quit");
	        System.out.println("Result from redis quit: " + result);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
        
	}
}
