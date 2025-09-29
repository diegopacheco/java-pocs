### Build 

```bash
./mvnw clean install 
```

### Result

```
2025-09-28 19:11:45 INFO  Scheduler:191 - Scheduling job 'Main$$Lambda/0x00002000010ce230@76508ed1' to run every 1000ms
2025-09-28 19:11:46 DEBUG Scheduler:490 - Job 'Main$$Lambda/0x00002000010ce230@76508ed1' execution is 8ms late
My first job executed at: 2025-09-28T19:11:46.014825
2025-09-28 19:11:46 DEBUG Scheduler:506 - Job 'Main$$Lambda/0x00002000010ce230@76508ed1' executed in 3ms
2025-09-28 19:11:47 DEBUG Scheduler:490 - Job 'Main$$Lambda/0x00002000010ce230@76508ed1' execution is 4ms late
My first job executed at: 2025-09-28T19:11:47.021934
2025-09-28 19:11:47 DEBUG Scheduler:506 - Job 'Main$$Lambda/0x00002000010ce230@76508ed1' executed in 1ms
2025-09-28 19:11:48 INFO  Scheduler:309 - Shutting down...
```
