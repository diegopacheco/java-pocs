package com.github.diegopacheco.sandbox.java.titan;

import java.io.File;
import java.util.Date;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Vertex;

import com.thinkaurelius.titan.core.Cardinality;
import com.thinkaurelius.titan.core.PropertyKey;
import com.thinkaurelius.titan.core.TitanFactory;
import com.thinkaurelius.titan.core.TitanGraph;
import com.thinkaurelius.titan.core.TitanVertex;
import com.thinkaurelius.titan.core.schema.Mapping;
import com.thinkaurelius.titan.core.schema.TitanManagement;

/**
 * 
 * 1. Run: bin/titan.sh 
 * 2. Clean up es: curl -XDELETE localhost:9200/*
 * 3. Clean up cass: bin/cqlsh 127.0.0.1 9042 --cqlversion="3.2.0"
 * 4. drop keyspace titan;
 * 5. Run TitanDBCassESSimple
 * 6. goto ES http://localhost:9200/_all/_search?pretty=true&q=*:*
 * 7. bin/cqlsh 127.0.0.1 9042 --cqlversion="3.2.0"
 * 8. select * from titan_ids;
 * 
 * @author diegopacheco
 *
 */
public class TitanDBCassESSimple {
	public static void main(String[] args) {
		TitanGraph graph = connect();
		insertData(graph);
		anwserQuestions(graph);
	}

	private static void anwserQuestions(TitanGraph graph) {
		try{
			
			GraphTraversalSource g = graph.traversal();
			
				System.out.println("Diego's tweets: " + 
					 g.V().has("owner", "1").values("id","desc").toList() 
				);
				
				System.out.println("Tweets by HashTags: " + 
					 g.V().has("hashTags", "#titan").values("id","desc").toList() 
				);
				
				System.out.println("Poletto follows: "  +
					 g.V().has("name","poletto").out("follows").values("name").toList()
				);
				
				System.out.println("Poletto Timeline: "  +
					g.V().has("name","poletto").out("follows").out("tweets").values("desc").toList()
				);
				
		}catch(Exception e){
			System.out.println(e);
		}
	}

	private static void insertData(TitanGraph graph) {
		try{
			
			TitanManagement mgmt = graph.openManagement();
			PropertyKey nameProperty = mgmt.makePropertyKey("desc").dataType(String.class).cardinality(Cardinality.SET).make();
			mgmt.buildIndex("search", Vertex.class).addKey(nameProperty, Mapping.STRING.asParameter()).buildMixedIndex("search");
			mgmt.commit();
			
			TitanVertex diego = graph.addVertex("id", 1, "type", "user", "name", "diego");
			
			TitanVertex tweet = graph.addVertex("id", 2, "type", "tweet",
					"owner", "1",
					"desc", "I like twitter when Is a graph db",
					"hashTags", "#titan",
					"dateCreated", new Date()
			);
			diego.addEdge("tweets", tweet);
			
			TitanVertex tweet2 = graph.addVertex("id", 3, "type", "tweet",
					"owner", "1",
					"desc", "I like twitter when Is a graph db so so much",
					"hashTags", "#titan",
					"dateCreated", new Date()
			);
			diego.addEdge("tweets", tweet2);
			
			TitanVertex poletto = graph.addVertex("id", 4, "type", "user", "name", "poletto");
			poletto.addEdge("follows", diego);
			
			graph.tx().commit();
			
		}catch(Exception e){
			System.out.println(e);
		}
	}

	private static TitanGraph connect() {
		try{
			PropertiesConfiguration pc = new PropertiesConfiguration(new File(".").getCanonicalFile() + "/src/main/resources/titan-cassandra-es.properties");
			return TitanFactory.open(pc);
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
}
