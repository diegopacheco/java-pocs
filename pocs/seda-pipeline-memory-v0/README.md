# Batch

This POC is back to the basics, is a very very easy and simple implementation
just having a silly single batch job that run based on some submittions.
We could have a task to check for submitions every 30s or 1m or we could just submit when we know
we have work. There is metrics but no feature flags, no drain.

# POC V0

* Spring Boot 3.x Application now
* Pipeline is the main orchestrator
  * Now managed by Spring
* Realtime-metrics
  * http://localhost:8080/stat
* Fixed Pool of Threads
  * 3 Thread Pools all tasks 
  * No Queues
* No SEDA anymore - just a very simple batch job.

### Build 
```bash
./mvnw clean install 
```

### Output
```
*************************************
*** Batch Job [SimpleBatchJob] ******
*************************************
* 
*                      |-----------------|        |-------------------|      |-------------------| 
* events --> [executor]|-- step(M1)    --|  ==>   |-- cat(M2) --------|  ==> |-- console(M3) ----| 
*                      |-----------------|        |-------------------|      |-------------------| 
* 
* STARTED !
* 
2024-03-19T01:01:54.938-07:00  INFO 2331827 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint(s) beneath base path '/actuator'
2024-03-19T01:01:55.006-07:00  INFO 2331827 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path ''
2024-03-19T01:01:55.024-07:00  INFO 2331827 --- [           main] c.g.diegopacheco.pocs.seda.Application   : Started Application in 3.124 seconds (process running for 3.547)
```

### Metrics
```
http://localhost:8080/stat
```
```
// 20240319010413
// http://localhost:8080/stat
{
  "batch-job": "6"
}
```