package com.github.diegopacheco.sandbox.java.rethinkdb;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.RethinkDBConnection;
import com.rethinkdb.model.MapObject;

public class MainApp {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		RethinkDB r = RethinkDB.r;
		RethinkDBConnection con = r.connect();

		r.db("test").tableCreate("heros").run(con);
		con.use("test");

		r.table("heros").insert(
		        new MapObject().with("name", "Heman").with("age", 33).with("skill", "sword"),
		        new MapObject().with("name", "Spiderman").with("age", 27).with("skill", "jumping"),
		        new MapObject().with("name", "Superman").with("age", 133).with("skill", "flying"),
		        new MapObject().with("name", "Xena").with("age", 29).with("skill", "wowza")
		).run(con);

		System.out.println(
		        r.table("heros").filter(hero->hero.field("age").gt(100)).pluck("age").run(con)
		); 

		System.out.println(
		        r.table("heros").orderBy(r.desc("age")).map(hero -> hero.field("name").upcase()).run(con)
		);

		System.out.println(
		        r.table("heros").update(row ->
		                        r.branch(
		                                row.field("age").gt(100),
		                                new MapObject().with("newAttribute", "old"),
		                                new MapObject().with("newAttribute", "young")
		                        )
		        ).run(con)
		);

		System.out.println(
		        r.table("heros").pluck("name","newAttribute").run(con)
		);
		
	}
}
