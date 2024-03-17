# POC V3

* Spring Boot 3.x Application now
* Pipeline is the main orchestrator
  * Now managed by Spring
* Realtime-metrics
  * http://localhost:8080/stat
* Flow control via time backpressure and feature flags that can be changed dynamically 
  * You can list FF http://localhost:8080/flags
  * Flags can ge changed in realime
    * i.e: http://localhost:8080/flag/$WORKER_SANITIZER_TIME_BACKPRESSURE_MS/3
* Dynamic Thread Management via PipelineManager
  * 7 Thread Pools per Stage 
  * QueueManager queue data structure has changed to LinkedBlockingDeque
  * Process much faster but uses much more CPU them previous variations v1 and v2

## SEDA (Staged Event Driven Architecture)

* Decompose complex event in queues
* Avoid high overhead with threads
* Decouple events and threads from application
* Dynamic control - can be tuned at runtime+
* Funny fact: Same guy who created NoSQL created SEDA!

## Resources

* SEDA https://en.wikipedia.org/wiki/Staged_event-driven_architecture
* SEDA camel / Spring https://www.baeldung.com/spring-apache-camel-seda-integration
* SEDA Deck https://pages.cs.wisc.edu/~remzi/Classes/739/Fall2016/Papers/seda.pdf
* SEDA paper https://sosp.org/2001/papers/welsh.pdf

### Important things for future POCs

* Could be using Virtual Threads but them we would need to have some other form of backpressure
* Virtual Threads it would be better since is IO bound the nature of the problem, so we will use less CPU
* However the Cat website might not handle the load so we might some other form of beackpressure that is not time based  
  some proper algo like leak bucket or other algo.
* Queues could be externalized to Redis/SQS howeever it would have more latency to process.
* I did not implement snapshoting but it would be done
  * track every state of every queue and persisnt it, there we go.
  * has to process to resume where it stop - external state could goto s3 for instance.
* We should not be creating a destroying threads dynamically. However with virtual threads 
  we could be doing something more dynamic and have a FF controlling the cap(threads per worker)
  howeever I did not implemeted, easily we could implement a drain mechanism for it.
* I did not code a EventMetadata but this could be useful, a class that has timestamp of the event creating 
  and "stamps" of all parts the envet travel in the states of the pipeline, it would be usefull 
  for debugging and bookeeping as well, we could attach metrics to the event this way.

### Build 
```bash
./mvnw clean install 
```

### Output
```
**************************
*** Quem tem SEDA ? ******
**************************
* 
* Pipeline Manager 
* 
*                      |-------------------|                |-------------------|                |-------------------| 
* events --> [in-queue]|-- sanitizer(W1) --|  ==> [in-queue]|-- cat(W2) --------|  ==> [in-queue]|-- console(W3) ----| 
*                      |-------------------|                |-------------------|                |-------------------| 
* 
* STARTED !
* >>> 500 events generated! 
Sat Mar 16 01:59:27 PDT 2024 - event finish pipeline.
{ "requester": "babyshark_2422", "result": {"fact":"Despite imagery of cats happily drinking milk from saucers, studies indicate that cats are actually lactose intolerant and should avoid it entirely.","length":148}}
Sat Mar 16 01:59:30 PDT 2024 - event finish pipeline.
{ "requester": "the_cat_3283", "result": {"fact":"The Cat Fanciers Association (CFA) recognizes 44 breeds of cats.","length":64}}
Sat Mar 16 01:59:33 PDT 2024 - event finish pipeline.
{ "requester": "raphaello_635", "result": {"fact":"The way you treat kittens in the early stages of it's life will render it's personality traits later in life.","length":109}}
Sat Mar 16 01:59:36 PDT 2024 - event finish pipeline.
{ "requester": "conan_3706", "result": {"fact":"Ailurophile is the word cat lovers are officially called.","length":57}}
Sat Mar 16 01:59:40 PDT 2024 - event finish pipeline.
{ "requester": "ryu_3980", "result": {"fact":"There are up to 60 million feral cats in the United States alone.","length":65}}
```

### Metrics
```
http://localhost:8080/stat
```
```
// 20240316225729
// http://localhost:8080/stat

{
  "ConsoleWorker-queue-console": "15",
  "CatWorker-queue-console": "15",
  "SanitizerWorker-queue-cat": "500"
}
```

### Feature Flags (FF)
```
http://localhost:8080/flags
```
```
// 20240316232227
// http://localhost:8080/flags

{
  "$WORKER_CONSOLE_TIME_BACKPRESSURE_MS": "1",
  "$WORKER_SANITIZER_TIME_BACKPRESSURE_MS": "0",
  "$WORKER_CAT_TIME_BACKPRESSURE_MS": "2"
}
```