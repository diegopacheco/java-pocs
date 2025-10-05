import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.timelimiter.TimeLimiter;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;

import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class ResilientService {
    private final RemoteService remoteService;
    private final CircuitBreaker circuitBreaker;
    private final Retry retry;
    private final RateLimiter rateLimiter;
    private final Bulkhead bulkhead;
    private final TimeLimiter timeLimiter;

    public ResilientService(RemoteService remoteService) {
        this.remoteService = remoteService;

        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .failureRateThreshold(50)
                .waitDurationInOpenState(Duration.ofSeconds(5))
                .slidingWindowSize(10)
                .minimumNumberOfCalls(5)
                .build();
        this.circuitBreaker = CircuitBreaker.of("remoteService", circuitBreakerConfig);

        RetryConfig retryConfig = RetryConfig.custom()
                .maxAttempts(3)
                .waitDuration(Duration.ofMillis(500))
                .build();
        this.retry = Retry.of("remoteService", retryConfig);

        RateLimiterConfig rateLimiterConfig = RateLimiterConfig.custom()
                .limitForPeriod(5)
                .limitRefreshPeriod(Duration.ofSeconds(1))
                .timeoutDuration(Duration.ofSeconds(1))
                .build();
        this.rateLimiter = RateLimiter.of("remoteService", rateLimiterConfig);

        BulkheadConfig bulkheadConfig = BulkheadConfig.custom()
                .maxConcurrentCalls(3)
                .maxWaitDuration(Duration.ofMillis(500))
                .build();
        this.bulkhead = Bulkhead.of("remoteService", bulkheadConfig);

        TimeLimiterConfig timeLimiterConfig = TimeLimiterConfig.custom()
                .timeoutDuration(Duration.ofSeconds(2))
                .build();
        this.timeLimiter = TimeLimiter.of("remoteService", timeLimiterConfig);
    }

    public String callWithCircuitBreaker() {
        Supplier<String> decoratedSupplier = CircuitBreaker
                .decorateSupplier(circuitBreaker, () -> {
                    try {
                        return remoteService.call();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

        try {
            return decoratedSupplier.get();
        } catch (Exception e) {
            return "Circuit breaker fallback: " + e.getMessage();
        }
    }

    public String callWithRetry() {
        Supplier<String> decoratedSupplier = Retry
                .decorateSupplier(retry, () -> {
                    try {
                        return remoteService.call();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

        try {
            return decoratedSupplier.get();
        } catch (Exception e) {
            return "Retry exhausted: " + e.getMessage();
        }
    }

    public String callWithRateLimiter() {
        Supplier<String> decoratedSupplier = RateLimiter
                .decorateSupplier(rateLimiter, () -> {
                    try {
                        return remoteService.call();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

        try {
            return decoratedSupplier.get();
        } catch (Exception e) {
            return "Rate limit exceeded: " + e.getMessage();
        }
    }

    public String callWithBulkhead() {
        Supplier<String> decoratedSupplier = Bulkhead
                .decorateSupplier(bulkhead, () -> {
                    try {
                        return remoteService.call();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

        try {
            return decoratedSupplier.get();
        } catch (Exception e) {
            return "Bulkhead full: " + e.getMessage();
        }
    }

    public String callWithTimeLimiter() {
        Callable<String> callable = () -> remoteService.slowCall();

        Supplier<CompletableFuture<String>> futureSupplier = () ->
                CompletableFuture.supplyAsync(() -> {
                    try {
                        return remoteService.slowCall();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }, Executors.newSingleThreadExecutor());

        try {
            return timeLimiter.executeFutureSupplier(futureSupplier);
        } catch (Exception e) {
            return "Time limit exceeded: " + e.getMessage();
        }
    }

    public String callWithAllPatterns() {
        Supplier<String> decoratedSupplier = CircuitBreaker
                .decorateSupplier(circuitBreaker,
                        Retry.decorateSupplier(retry,
                                RateLimiter.decorateSupplier(rateLimiter,
                                        Bulkhead.decorateSupplier(bulkhead, () -> {
                                            try {
                                                return remoteService.call();
                                            } catch (Exception e) {
                                                throw new RuntimeException(e);
                                            }
                                        }))));

        try {
            return decoratedSupplier.get();
        } catch (Exception e) {
            return "All patterns fallback: " + e.getMessage();
        }
    }

    public CircuitBreaker getCircuitBreaker() {
        return circuitBreaker;
    }

    public Retry getRetry() {
        return retry;
    }

    public RateLimiter getRateLimiter() {
        return rateLimiter;
    }

    public Bulkhead getBulkhead() {
        return bulkhead;
    }

    public TimeLimiter getTimeLimiter() {
        return timeLimiter;
    }
}
