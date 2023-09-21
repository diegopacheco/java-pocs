package com.github.diegopacheco.javapocs.features21.structuredconcurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;
import java.util.function.Supplier;

public class SCMain {

    class Response{

        private int order;
        private String user;

        public Response(String user,int order) {
            this.order = order;
            this.user = user;
        }

        @Override
        public String toString() {
            return "Response{" +
                    "order=" + order +
                    ", user='" + user + '\'' +
                    '}';
        }

    }

    Response handle() throws ExecutionException, InterruptedException {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            Supplier<String>  user  = scope.fork(() -> findUser());
            Supplier<Integer> order = scope.fork(() -> fetchOrder());

            scope.join()               // Join both subtasks
                    .throwIfFailed();  // ... and propagate errors

            // Here, both subtasks have succeeded, so compose their results
            return new Response(user.get(), order.get());
        }
    }

    private Integer fetchOrder() {
        return 1;
    }

    private String findUser() {
        return "John Due";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Response res = new SCMain().handle();
        System.out.println(res);
    }
}
