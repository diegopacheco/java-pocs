package com.github.diegopacheco.sandbox.java.arrangodb;

import java.util.Iterator;
import java.util.Map;

import com.arangodb.ArangoConfigure;
import com.arangodb.ArangoDriver;
import com.arangodb.ArangoHost;
import com.arangodb.DocumentCursor;
import com.arangodb.entity.CollectionEntity;
import com.arangodb.entity.DocumentEntity;
import com.arangodb.util.MapBuilder;

public class MainApp {
	public static void main(String[] args) throws Throwable {
		
		  ArangoConfigure configure = new ArangoConfigure();
		  configure.setArangoHost(new ArangoHost("127.0.0.1", 8529));
		  configure.init();
		  ArangoDriver arangoDriver = new ArangoDriver(configure);
		  
		  try{
			  arangoDriver.createDatabase("db1"); 
		  }catch(Exception e){
			  System.out.println("DB created already");
		  }
		  arangoDriver.setDefaultDatabase("db1");
		  
		  CollectionEntity myArangoCollection = arangoDriver.createCollection("myCollection");
		  System.out.println(myArangoCollection);
		  
		  try{
			  MyObject myObject = new MyObject("Homer", 38);
			  DocumentEntity<MyObject> myDocument = arangoDriver.createDocument("myCollection", myObject);
			  System.out.println(myDocument);
			  
		      arangoDriver.createDocument("myCollection", new MyObject("Marge", 36));
		      arangoDriver.createDocument("myCollection", new MyObject("Bart", 10));
		      arangoDriver.createDocument("myCollection", new MyObject("Lisa", 8));
		      arangoDriver.createDocument("myCollection", new MyObject("Maggie", 2));
		  }catch(Exception e){
			  System.out.println("Duplicated not adding again...");
		  }
	      
	      String query = "FOR t IN myCollection FILTER t.age >= @age SORT t.age RETURN t";
	      Map<String, Object> bindVars = new MapBuilder().put("age", 3).get();

	      DocumentCursor<MyObject> documentCursor = arangoDriver.executeDocumentQuery(
	        query, bindVars, arangoDriver.getDefaultAqlQueryOptions(), MyObject.class);

	      Iterator<DocumentEntity<MyObject>> iterator = documentCursor.iterator();
	      while (iterator.hasNext()) {
	        DocumentEntity<MyObject> documentEntity = iterator.next();
	        MyObject obj = documentEntity.getEntity();
	        System.out.println(obj.getName());
	      }
	      
	}
}
