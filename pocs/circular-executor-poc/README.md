## Rationale

Imagine you must call some 3rd party dependency(downstream dependency) that sucks, it's easily super slow or cranky, or fail at unexpected times or even all options above maybe takes 1h, 10h, 1 day or 3 days to return success. You do not want go on the timeout path because it's dangerous, you might need to tweak forever and might lead to a deny of service (DOS) problem. So we need some different approach, which here will be a circular queue where tasks can a chance to run but if they dont achieve the expected you re-try time to time so the queue it self works are a backpressure mechanism.

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