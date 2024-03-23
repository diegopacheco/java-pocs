# POC V7

* Added proper backpressure with LeakyBucket
* Virtual Threads instead of Direct OS Threads.
* Switch to Netty.
* Spring Boot 3.x Application now
* Design was simplified
* SEDA Manager is the main orchestrator
  * Now managed by Spring
  * Much more simple now
* HUGE CPU improvements
  * No while true / no busy waiting
  * SEDA pipeline is LAZY
  * remove double queue - leveraging executors queue
* Added Event and EventMetadata 
  + Now events have "tags" called "stamps"
  + Stamps are just a map with k/v pairs
  + Main stamps today is the stage and timestamp
  + Since is a map we can attach any metadata.
* Realtime-metrics
  * http://localhost:8080/stat
* Flow control via time backpressure and feature flags that can be changed dynamically 
  * You can list FF http://localhost:8080/flags
  * Flags can ge changed in realime
    * i.e: http://localhost:8080/flag/$QUEUE_SANITIZER_TIME_BACKPRESSURE_MS/3
* Dynamic Thread Management via PipelineManager
  * 3 Executors Pools per Stage 
  * QueueManager queue data structure has changed to LinkedBlockingDeque
  * Process much faster but uses much more CPU them previous variations v1 and v2
* Drainable/Resunable behavior via DynamicBaseWorker
  * To drain a poll /drain/{poolCode}
  * To resume a poll /resume/{poolCode}
  * This feature was removed for now - will come back in the future
* Metadata CEP-like, another thing I tought was to create stacked stamps with evnts
  imagine like a email thread where you could see the first email, second email, thrid email.
  this feature would suck more space because messages it would bigger if we impl dumb
  but this could be useful for debugging and troubleshooting.

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

* Queues could be externalized to Redis/SQS however it would have more latency to process.
  + Another thing is if you run with 3 instances, you will have everything multiplied by 30, there is where external
    State like redis/sqs helps, but if you need to limit or control runtime still possible to coordinate.
* I did not implement snapshotting but it would be done
  + track every state of every queue and persist it, there we go.
  + has to process to resume where it stop - external state could goto s3 for instance.

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
* SEDA Manager 
* 
*                      |-------------------|                |-------------------|                |-------------------| 
* events --> [exe-pool]|-- sanitizer(W1) --|  ==> [exe-pool]|-- cat(W2) --------|  ==> [exe-pool]|-- console(W3) ----| 
*                      |-------------------|                |-------------------|                |-------------------| 
* 
* STARTED !
* >>> 1 events generated! 
* SEDA Manager done provisioned  3  thread pools per worker 
 >> Event{content=raphaello_1504, metadata=EventMetadata{stamps={STAGE=SANITIZER, TIMESTAMP=Wed Mar 20 02:40:41 PDT 2024}}}
Worker[SanitizerWorker~pool-2-thread-1] completed. 
 >> Event{content={ "requester": "raphaello_1504", "result": {"fact":"A cat\u2019s back is extremely flexible because it has up to 53 loosely fitting vertebrae. Humans only have 34.","length":106}}, metadata=EventMetadata{stamps={STAGE=CAT, TIMESTAMP=Wed Mar 20 02:40:44 PDT 2024}}}
Worker[CatWorker~pool-3-thread-1] completed. 
Wed Mar 20 02:40:45 PDT 2024 - event finish pipeline.
 >> Event{content={ "requester": "raphaello_1504", "result": {"fact":"A cat\u2019s back is extremely flexible because it has up to 53 loosely fitting vertebrae. Humans only have 34.","length":106}}, metadata=EventMetadata{stamps={STAGE=CONSOLE, TIMESTAMP=Wed Mar 20 02:40:44 PDT 2024}}}
Worker[ConsoleWorker~pool-4-thread-1] completed. 
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
  "$QUEUE_CONSOLE_TIME_BACKPRESSURE_MS": "1",
  "$QUEUE_SANITIZER_TIME_BACKPRESSURE_MS": "0",
  "$QUEUE_CAT_TIME_BACKPRESSURE_MS": "2"
}
```

### Drain/Resume

PS: This feature was removed on this poc - will come back on the future.

Simple drain/resume impl, when we drain, we wait for current task per worker to finish them each worker
ends it work by breaking out of the while(true) ending the Runnable task and therefore breaking out of the 
carrier. For Resume, we need to create pool of worker objects again, set them in a resume state, them submit all workers
back to the carriers. This is more intense but saves more cpu/memory.

PS: There is not CAP on resume, so if you keep calling will keep creating new submissions but will not create
new threads.

You can drain any pool by
```
http://localhost:8080/drain/3
```
generate some events
```
http://localhost:8080/events/30
```
See that we have less logs now.
Let's resume worker pool 3
```
http://localhost:8080/resume/3
```
See logs again
```
{ "requester": "conan_2286", "result": {"fact":"In 1987 cats overtook dogs as the number one pet in America.","length":60}}
Sun Mar 17 21:04:50 PDT 2024 - event finish pipeline.
{ "requester": "raphaello_3883", "result": {"fact":"It may take as long as 2 weeks for a kitten to be able to hear well.  Their eyes usually open between 7 and 10 days, but sometimes it happens in as little as 2 days.","length":165}}
Sun Mar 17 21:04:50 PDT 2024 - event finish pipeline.
{ "requester": "splinter_215", "result": {"fact":"There is a species of cat smaller than the average housecat. It is native to Africa and it is the Black-footed cat (Felis nigripes). Its top weight is 5.5 pounds.","length":162}}
Sun Mar 17 21:04:51 PDT 2024 - event finish pipeline.
{ "requester": "raphaello_1191", "result": {"fact":"In Siam, the cat was so revered that one rode in a chariot at the head of a parade celebrating the new king.","length":108}}
Sun Mar 17 21:04:52 PDT 2024 - event finish pipeline.
{ "requester": "babyshark_4369", "result": {"fact":"The first cat show was organized in 1871 in London. Cat shows later became a worldwide craze.","length":93}}
Sun Mar 17 21:04:52 PDT 2024 - event finish pipeline.
{ "requester": "the_cat_569", "result": {"fact":"It has been scientifically proven that owning cats is good for our health and can decrease the occurrence of high blood pressure and other illnesses.","length":149}}
Sun Mar 17 21:04:53 PDT 2024 - event finish pipeline.
{ "requester": "conan_3437", "result": {"fact":"The most expensive cat was an Asian Leopard cat (ALC)-Domestic Shorthair (DSH) hybrid named Zeus. Zeus, who is 90% ALC and 10% DSH, has an asking price of \u00a3100,000 ($154,000).","length":175}}
Sun Mar 17 21:04:54 PDT 2024 - event finish pipeline.
{ "requester": "the_cat_2816", "result": {"fact":"Cats have 30 vertebrae (humans have 33 vertebrae during early development; 26 after the sacral and coccygeal regions fuse)","length":122}}
Sun Mar 17 21:04:54 PDT 2024 - event finish pipeline.
{ "requester": "the_cat_3663", "result": {"fact":" A cat only has the ability to move their jaw up and down, not side to side like a human can.","length":93}}
Sun Mar 17 21:04:55 PDT 2024 - event finish pipeline.
{ "requester": "conan_1379", "result": {"fact":"A cat\u2019s jaw can\u2019t move sideways, so a cat can\u2019t chew large chunks of food.","length":74}}
Sun Mar 17 21:04:57 PDT 2024 - event finish pipeline.
{ "requester": "conan_4542", "result": {"fact":"Cat families usually play best in even numbers. Cats and kittens should be aquired in pairs whenever possible.","length":110}}
Sun Mar 17 21:04:57 PDT 2024 - event finish pipeline.
{ "requester": "conan_203", "result": {"fact":"Abraham Lincoln loved cats. He had four of them while he lived in the White House.","length":82}}
Sun Mar 17 21:04:58 PDT 2024 - event finish pipeline.
{ "requester": "donatello_2053", "result": {"fact":"Cats dislike citrus scent.","length":26}}

```