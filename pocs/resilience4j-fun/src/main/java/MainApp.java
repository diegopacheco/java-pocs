import java.util.function.Supplier;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.retry.Retry;
import io.vavr.control.Try;

public class MainApp {

    public static interface BackendService {
        String doSomething();
    }

    public static class BackendServiceImpl implements BackendService {
        @Override
        public String doSomething() {
            return "ok done";
        }
    }

    public static void main(String[] args) {

        BackendService bs = new BackendServiceImpl();

        CircuitBreaker circuitBreaker = CircuitBreaker.ofDefaults("backendName");
        Retry retry = Retry.ofDefaults("backendName");

        Supplier<String> decoratedSupplier = CircuitBreaker.decorateSupplier(circuitBreaker,bs::doSomething);
        decoratedSupplier = Retry.decorateSupplier(retry, decoratedSupplier);

        String result = Try.ofSupplier(decoratedSupplier).recover(throwable -> "Hello from Recovery").get();
        System.out.println("result 1 : " + result);

        result = circuitBreaker.executeSupplier(bs::doSomething);
        System.out.println("result 2 : " + result);
    }
}