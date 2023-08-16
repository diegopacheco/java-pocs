### Build 
```bash
./mvnw clean install 
```

### Rationale

OMG Diego you lost your mind, no not really. 
This is quadratic time(for inside for), I know, but this is very useful because allows to think in the worst case scenario.

Let's recap: Single Threaded, no JVM tunning, poorly implemented, no tuning:
 * Even on this case 10k events running against 10k rules took only 2 seconds is pretty fast for worst case.
 * Sure 100k starts to get slow, but for something in the background, 3.8 minutes is not bad! :-) We can do better. 

### How can we optimize and scale

1. Start filtering the rules by users(uuid, id, hash, or symbol, whatever).
2. CAP how many rules a user can have lets say 100 is max.
3. Use thread pool, process all in parallel rather a single thread, is all cpu bound (2 threads per core).
4. Simple things, integers instead of strings for symbols, it would speed up things and use less memory. 
5. More machines with some seeding or light coordination(zookeeper like).
6. Optimized languages like Go, Rust or Zig.

### Benchmark
```bash
Matching 10 events/predicates resulted in: [2] match in 0 ms
Matching 100 events/predicates resulted in: [378] match in 2 ms
Matching 1000 events/predicates resulted in: [29163] match in 38 ms
Matching 10000 events/predicates resulted in: [3131126] match in 2052 ms
Matching 100000 events/predicates resulted in: [313618905] match in 231192 ms (3.8 minutes)
```