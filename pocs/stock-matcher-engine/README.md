### Build 
```bash
./mvnw clean install 
```

### Rationale

OMG diego you lost your mind, no not really. 
This os quadratic time, I know, but this is very useful because allows to think in the worst case scenario.
Even on this case 10k events running against 10k rules took only 2 seconds. 

### How can we optimize and scale

1. Start filtering the rules by users.
2. Cap how many rules a user can have lets say 100 is max.
3. Use threads and process all this in parallel rather a single thread.
4. We can scale to more machines with some seeding or light coordination.

### Benchmark
```bash
Matching 10 events/predicates resulted in: [5] match in 0 ms
Matching 100 events/predicates resulted in: [344] match in 1 ms
Matching 1000 events/predicates resulted in: [30593] match in 40 ms
Matching 10000 events/predicates resulted in: [3203681] match in 2072 ms
Matching 100000 events/predicates resulted in: [313618905] match in 231192 ms (3.8 minutes)
```