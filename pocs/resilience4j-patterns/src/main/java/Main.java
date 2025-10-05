import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        RemoteService remoteService = new RemoteService();
        ResilientService resilientService = new ResilientService(remoteService);

        logger.info("=== Circuit Breaker Pattern ===");
        demonstrateCircuitBreaker(resilientService, remoteService);

        logger.info("\n=== Retry Pattern ===");
        demonstrateRetry(resilientService, remoteService);

        logger.info("\n=== Rate Limiter Pattern ===");
        demonstrateRateLimiter(resilientService, remoteService);

        logger.info("\n=== Bulkhead Pattern ===");
        demonstrateBulkhead(resilientService, remoteService);

        logger.info("\n=== Time Limiter Pattern ===");
        demonstrateTimeLimiter(resilientService);

        logger.info("\n=== Combined Patterns ===");
        demonstrateCombinedPatterns(resilientService, remoteService);
    }

    private static void demonstrateCircuitBreaker(ResilientService resilientService, RemoteService remoteService) {
        remoteService.reset();
        for (int i = 0; i < 15; i++) {
            String result = resilientService.callWithCircuitBreaker();
            logger.info("Call {}: {} - Circuit state: {}",
                i + 1, result, resilientService.getCircuitBreaker().getState());
        }
    }

    private static void demonstrateRetry(ResilientService resilientService, RemoteService remoteService) {
        remoteService.reset();
        for (int i = 0; i < 5; i++) {
            String result = resilientService.callWithRetry();
            logger.info("Call {}: {}", i + 1, result);
        }
    }

    private static void demonstrateRateLimiter(ResilientService resilientService, RemoteService remoteService) {
        remoteService.reset();
        for (int i = 0; i < 10; i++) {
            String result = resilientService.callWithRateLimiter();
            logger.info("Call {}: {}", i + 1, result);
        }
    }

    private static void demonstrateBulkhead(ResilientService resilientService, RemoteService remoteService) {
        remoteService.reset();
        for (int i = 0; i < 5; i++) {
            String result = resilientService.callWithBulkhead();
            logger.info("Call {}: {} - Available concurrent calls: {}",
                i + 1, result, resilientService.getBulkhead().getMetrics().getAvailableConcurrentCalls());
        }
    }

    private static void demonstrateTimeLimiter(ResilientService resilientService) {
        for (int i = 0; i < 3; i++) {
            String result = resilientService.callWithTimeLimiter();
            logger.info("Call {}: {}", i + 1, result);
        }
    }

    private static void demonstrateCombinedPatterns(ResilientService resilientService, RemoteService remoteService) {
        remoteService.reset();
        for (int i = 0; i < 5; i++) {
            String result = resilientService.callWithAllPatterns();
            logger.info("Call {}: {}", i + 1, result);
        }
    }
}
