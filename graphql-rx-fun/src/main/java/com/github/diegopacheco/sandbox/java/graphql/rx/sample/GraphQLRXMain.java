package com.github.diegopacheco.sandbox.java.graphql.rx.sample;

import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

import graphql.GraphQL;
import graphql.execution.RxExecutionResult;
import graphql.execution.RxExecutionStrategy;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import rx.Observable;

public class GraphQLRXMain {
	public static void main(String[] args) {
		
		GraphQLObjectType queryType = newObject()
                .name("helloWorldQuery")
                .field(newFieldDefinition()
                        .type(GraphQLString)
                        .name("hello")
                        .staticValue(Observable.just("world"))
                        .build()).build();

        GraphQLSchema schema = GraphQLSchema.newSchema()
                .query(queryType)
                .build();

        Observable<?> result = ((RxExecutionResult)new GraphQL(schema, new RxExecutionStrategy()).execute("{hello}")).getDataObservable();
        result.subscribe(System.out::println);
		
	}
}
