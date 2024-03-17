# POC V2

* Spring Boot 3.x Application now
* Pipeline is the main orchestrator
  * Now managed by Spring
* Realtime-metrics
  * http://localhost:8080/stat
* Flow control via time backpressure and feature flags that can be changed dynamically 
  * You can list FF http://localhost:8080/flags
  * Flags can ge changed in realime
    * i.e: http://localhost:8080/flag/$WORKER_SANITIZER_TIME_BACKPRESSURE_MS/3
* There is just 1 thread per worker

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