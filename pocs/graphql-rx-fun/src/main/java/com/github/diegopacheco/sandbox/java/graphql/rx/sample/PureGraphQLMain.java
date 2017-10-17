package com.github.diegopacheco.sandbox.java.graphql.rx.sample;

import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

import graphql.GraphQL;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;

public class PureGraphQLMain {

	public static void main(String[] args) {

		GraphQLObjectType queryType = newObject()
				.name("helloWorldQuery")
				.field(newFieldDefinition()
				.type(GraphQLString)
				.name("hello")
				.staticValue("world")
				.build()).build();

		GraphQLSchema schema = GraphQLSchema.newSchema().query(queryType).build();
		Object result = new GraphQL(schema).execute("{hello}").getData();

		System.out.println(result);

	}

}
