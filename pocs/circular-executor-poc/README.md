### Build

```bash
./mvnw clean install
```

### Result

```bash
>>> pool-2-thread-10 attempts: 0 calling some bad service takes time to be successful
>>> pool-2-thread-4 attempts: 0 isSuccess? true
>>> Metrics - Active tasks: 10
>>> Metrics - Queue size: 4
> Done! Result: Wed Jul 30 19:52:01 PDT 2025
>>> pool-2-thread-1 attempts: 0 isSuccess? false
>>> Metrics - Active tasks: 10
>>> Metrics - Queue size: 4
> Not done yet, so we will add to the queue and try again...
>>> pool-2-thread-6 attempts: 0 isSuccess? true
>>> Metrics - Active tasks: 10
>>> Metrics - Queue size: 5
>>> pool-2-thread-6 attempts: 0 calling some bad service takes time to be successful
> Done! Result: Wed Jul 30 19:52:02 PDT 2025
```