# POC V1

* There is just 1 thread per worker
* There is no dynamic flow control
* There is no realtime-metrics
* Pipeline is the main orchestrator

## SEDA (Staged Event Driven Architecture)

* Decompose complex event in queues
* Avoid high overhead with threads
* Decouple events and threads from application
* Dynamic control - can be tuned at runtime+
* Funny fact: Same guy who created NoSQL created SEDA!

### Build 
```bash
./mvnw clean install 
```

## Resources

* SEDA https://en.wikipedia.org/wiki/Staged_event-driven_architecture
* SEDA camel / Spring https://www.baeldung.com/spring-apache-camel-seda-integration
* SEDA Deck https://pages.cs.wisc.edu/~remzi/Classes/739/Fall2016/Papers/seda.pdf
* SEDA paper https://sosp.org/2001/papers/welsh.pdf
