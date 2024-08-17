### Build 
```bash
./mvnw clean install 
```

### Rationale

* arrival rate = number of tasks submitted to the pool / time taken to submit the tasks
* departure rate = number of tasks completed by the pool / time taken to complete the tasks
* throughput = departure rate - arrival rate

### Result

```
mul
```
```
ForkJoinPool.commonPool()
Size 0
Parallelism 11
Queued 0
Steal 0
Thread count 2
Tasks Submitted: 0
Tasks Completed: 0
Arrival Rate: Infinity tasks/sec
Departure Rate: NaN tasks/sec

ForkJoinPool.commonPool()
Size 1
Parallelism 11
Queued 0
Steal 1
Thread count 3
Tasks Submitted: 1
Tasks Completed: 1
Arrival Rate: 0.9727626459143969 tasks/sec
Departure Rate: 0.9727626459143969 tasks/sec
result: 2
```

```
sub
```
```
ForkJoinPool.commonPool()
Size 1
Parallelism 11
Queued 0
Steal 1
Thread count 3
Tasks Submitted: 0
Tasks Completed: 0
Arrival Rate: Infinity tasks/sec
Departure Rate: NaN tasks/sec

ForkJoinPool.commonPool()
Size 1
Parallelism 11
Queued 0
Steal 2
Thread count 3
Tasks Submitted: 1
Tasks Completed: 1
Arrival Rate: 1.0 tasks/sec
Departure Rate: 1.0 tasks/sec
result: -1

```

```
sum
```
```
ForkJoinPool.commonPool()
Size 1
Parallelism 11
Queued 0
Steal 2
Thread count 3
Tasks Submitted: 0
Tasks Completed: 0
Arrival Rate: Infinity tasks/sec
Departure Rate: NaN tasks/sec

ForkJoinPool.commonPool()
Size 1
Parallelism 11
Queued 0
Steal 2
Thread count 3
Tasks Submitted: 1
Tasks Completed: 1
Arrival Rate: 1.0 tasks/sec
Departure Rate: 1.0 tasks/sec
result: 3

```