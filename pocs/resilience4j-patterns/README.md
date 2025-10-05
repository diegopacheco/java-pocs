### Resilience4j Patterns POC

This POC demonstrates various resilience patterns using Resilience4j library.

### Patterns Implemented

1. Circuit Breaker - Prevents cascade failures by stopping calls to failing services
2. Retry - Automatically retries failed operations with configurable delays
3. Rate Limiter - Controls the rate of requests to prevent overload
4. Bulkhead - Limits concurrent calls to prevent resource exhaustion
5. Time Limiter - Sets timeout for long-running operations

### Build

```bash
./mvnw clean install
```

### Run

```bash
./run.sh
```

### Result

```
2025-10-05 00:30:11 INFO  Main:11 - === Circuit Breaker Pattern ===
2025-10-05 00:30:11 INFO  Main:34 - Call 1: Service response for call #1 - Circuit state: CLOSED
2025-10-05 00:30:11 INFO  Main:34 - Call 2: Service response for call #2 - Circuit state: CLOSED
2025-10-05 00:30:11 INFO  Main:34 - Call 3: Circuit breaker fallback: java.lang.Exception: Service temporarily unavailable - Circuit state: CLOSED
2025-10-05 00:30:11 INFO  Main:34 - Call 4: Service response for call #4 - Circuit state: CLOSED
2025-10-05 00:30:11 INFO  Main:34 - Call 5: Service response for call #5 - Circuit state: CLOSED
2025-10-05 00:30:11 INFO  Main:34 - Call 6: Circuit breaker fallback: java.lang.Exception: Service temporarily unavailable - Circuit state: CLOSED
2025-10-05 00:30:11 INFO  Main:34 - Call 7: Service response for call #7 - Circuit state: CLOSED
2025-10-05 00:30:12 INFO  Main:34 - Call 8: Service response for call #8 - Circuit state: CLOSED
2025-10-05 00:30:12 INFO  Main:34 - Call 9: Circuit breaker fallback: java.lang.Exception: Service temporarily unavailable - Circuit state: CLOSED
2025-10-05 00:30:15 INFO  Main:34 - Call 10: Circuit breaker fallback: java.lang.Exception: Timeout after 3 seconds - Circuit state: CLOSED
2025-10-05 00:30:15 INFO  Main:34 - Call 11: Service response for call #11 - Circuit state: CLOSED
2025-10-05 00:30:15 INFO  Main:34 - Call 12: Circuit breaker fallback: java.lang.Exception: Service temporarily unavailable - Circuit state: OPEN
2025-10-05 00:30:15 INFO  Main:34 - Call 13: Circuit breaker fallback: CircuitBreaker 'remoteService' is OPEN and does not permit further calls - Circuit state: OPEN
2025-10-05 00:30:15 INFO  Main:34 - Call 14: Circuit breaker fallback: CircuitBreaker 'remoteService' is OPEN and does not permit further calls - Circuit state: OPEN
2025-10-05 00:30:15 INFO  Main:34 - Call 15: Circuit breaker fallback: CircuitBreaker 'remoteService' is OPEN and does not permit further calls - Circuit state: OPEN

2025-10-05 00:30:15 INFO  Main:14 - === Retry Pattern ===
2025-10-05 00:30:15 INFO  Main:43 - Call 1: Service response for call #1
2025-10-05 00:30:15 INFO  Main:43 - Call 2: Service response for call #2
2025-10-05 00:30:15 INFO  Main:43 - Call 3: Service response for call #4
2025-10-05 00:30:16 INFO  Main:43 - Call 4: Service response for call #5
2025-10-05 00:30:16 INFO  Main:43 - Call 5: Service response for call #7

2025-10-05 00:30:16 INFO  Main:17 - === Rate Limiter Pattern ===
2025-10-05 00:30:16 INFO  Main:51 - Call 1: Service response for call #1
2025-10-05 00:30:16 INFO  Main:51 - Call 2: Service response for call #2
2025-10-05 00:30:16 INFO  Main:51 - Call 3: Rate limit exceeded: java.lang.Exception: Service temporarily unavailable
2025-10-05 00:30:16 INFO  Main:51 - Call 4: Service response for call #4
2025-10-05 00:30:17 INFO  Main:51 - Call 5: Service response for call #5
2025-10-05 00:30:17 INFO  Main:51 - Call 6: Rate limit exceeded: java.lang.Exception: Service temporarily unavailable
2025-10-05 00:30:17 INFO  Main:51 - Call 7: Service response for call #7
2025-10-05 00:30:17 INFO  Main:51 - Call 8: Service response for call #8
2025-10-05 00:30:17 INFO  Main:51 - Call 9: Rate limit exceeded: java.lang.Exception: Service temporarily unavailable
2025-10-05 00:30:20 INFO  Main:51 - Call 10: Rate limit exceeded: java.lang.Exception: Timeout after 3 seconds

2025-10-05 00:30:20 INFO  Main:20 - === Bulkhead Pattern ===
2025-10-05 00:30:20 INFO  Main:59 - Call 1: Service response for call #1 - Available concurrent calls: 3
2025-10-05 00:30:20 INFO  Main:59 - Call 2: Service response for call #2 - Available concurrent calls: 3
2025-10-05 00:30:20 INFO  Main:59 - Call 3: Bulkhead full: java.lang.Exception: Service temporarily unavailable - Available concurrent calls: 3
2025-10-05 00:30:20 INFO  Main:59 - Call 4: Service response for call #4 - Available concurrent calls: 3
2025-10-05 00:30:21 INFO  Main:59 - Call 5: Service response for call #5 - Available concurrent calls: 3

2025-10-05 00:30:21 INFO  Main:23 - === Time Limiter Pattern ===
2025-10-05 00:30:23 INFO  Main:67 - Call 1: Time limit exceeded: TimeLimiter 'remoteService' recorded a timeout exception.
2025-10-05 00:30:25 INFO  Main:67 - Call 2: Slow response
2025-10-05 00:30:27 INFO  Main:67 - Call 3: Time limit exceeded: TimeLimiter 'remoteService' recorded a timeout exception.

2025-10-05 00:30:27 INFO  Main:26 - === Combined Patterns ===
2025-10-05 00:30:27 INFO  Main:75 - Call 1: Service response for call #1
2025-10-05 00:30:27 INFO  Main:75 - Call 2: Service response for call #2
2025-10-05 00:30:27 INFO  Main:75 - Call 3: Service response for call #4
2025-10-05 00:30:27 INFO  Main:75 - Call 4: Service response for call #5
2025-10-05 00:30:28 INFO  Main:75 - Call 5: Service response for call #7
```
