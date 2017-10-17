package com.github.diegopacheco.sandbox.java.titan;

import java.util.Date;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.apache.tinkerpop.gremlin.tinkergraph.structure.TinkerGraph;

public class SimpleInMemoryGraph {
	public static void main(String[] args) {
		
		Graph  graph = TinkerGraph.open();
		
		Vertex diego = graph.addVertex("id", 1, "type", "user", "name", "diego");
		
		Vertex tweet = graph.addVertex("id", 2, "type", "tweet",
				"owner", "1",
				"desc", "I like twitter when Is a graph db",
				"hashTags", "#titan",
				"dateCreated", new Date()
		);
		diego.addEdge("tweets", tweet);
		
		Vertex tweet2 = graph.addVertex("id", 3, "type", "tweet",
				"owner", "1",
				"desc", "I like twitter when Is a graph db so so much",
				"hashTags", "#titan",
				"dateCreated", new Date()
		);
		diego.addEdge("tweets", tweet2);
		
		Vertex poletto = graph.addVertex("id", 4, "type", "user", "name", "poletto");
		poletto.addEdge("follows", diego);
		
		GraphTraversalSource g = graph.traversal();
		
		System.out.println("Diego's tweets: " + 
			 g.V().has("owner", "1").values("id","desc").toList() 
		);
		
		System.out.println("Tweets by HashTags: " + 
			 g.V().has("hashTags", "#titan").values("id","desc").toList() 
		);
		
		System.out.println("Poletto follows: "  +
			 g.V(poletto).out("follows").values("name").toList()
		);
		
		System.out.println("Poletto Timeline: "  +
			g.V(poletto).out("follows").out("tweets").values("desc").toList()
		);
		
	}
}
