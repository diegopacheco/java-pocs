package com.github.diegopacheco.java23.features.JEP_480;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;
import java.util.function.Supplier;

/**
 * JEP 480: Structured Concurrency (Third Preview)
 * https://openjdk.org/jeps/480
 */
public class FeatureJEP480 {

    public class Response {
        private final String user;
        private final int order;
        public Response(String user, int order) {
            this.user = user;
            this.order = order;
        }
        public String getUser() {
            return user;
        }
        public int getOrder() {
            return order;
        }
    }

    private String findUser() {
        return "User123";
    }
    private int fetchOrder() {
        return 456;
    }

    Response handle() throws ExecutionException, InterruptedException {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            Supplier<String> user  = scope.fork(() -> findUser());
            Supplier<Integer> order = scope.fork(() -> fetchOrder());

            scope.join()                // Join both subtasks
                    .throwIfFailed();  // ... and propagate errors

            // Here, both subtasks have succeeded, so compose their results
            return new Response(user.get(), order.get());
        }
    }

    public static void main(String[] args) {
        FeatureJEP480 app = new FeatureJEP480();
        try {
            Response response = app.handle();
            System.out.println(response.getUser());
            System.out.println(response.getOrder());
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
