package com.github.diegopacheco.sandbox.java.mapdb;

import java.util.concurrent.ConcurrentMap;

import org.mapdb.DB;
import org.mapdb.DBMaker;

public class MainMapDB {
	public static void main(String[] args) throws Throwable {
		
		DB db = DBMaker.memoryDB().make();
		ConcurrentMap map = db.hashMap("map").make();
		map.put("something", "here");
		
		System.out.println(map.get("something"));
		
	}
}
