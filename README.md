# java-pocs

Hands-on Java POCs, from Java 8 all the way to JDK 27. Every project lives under [pocs/](pocs/) and builds on its own with Maven or Gradle.

## ☕ Java Language & JDK Releases

Each Java release adds new language features and new APIs.
These POCs try them one version at a time.

* [java.8.playground](pocs/java.8.playground/) - Java 8 lambdas, streams and default methods
* [Java8-samples](pocs/Java8-samples/) - Java 8 features, one small class each
* [java8-luna](pocs/java8-luna/) - Java 8 on Eclipse Luna
* [java8-enum-consumer-tricks](pocs/java8-enum-consumer-tricks/) - Enums holding Consumers to replace branching
* [java9-simple-poc](pocs/java9-simple-poc/) - Java 9 first steps
* [java-13-fun](pocs/java-13-fun/) - Java 13 features
* [java-14-fun](pocs/java-14-fun/) - Java 14 features
* [java-15-fun](pocs/java-15-fun/) - Java 15 features
* [java-21-hello](pocs/java-21-hello/) - Java 21 hello world
* [java-21-features](pocs/java-21-features/) - Java 21 features tour
* [java21-maven-exec-experimental-preview](pocs/java21-maven-exec-experimental-preview/) - Java 21 preview features run through Maven exec
* [java-22-fun](pocs/java-22-fun/) - Java 22 unnamed variables and patterns and more
* [java23-helloworld](pocs/java23-helloworld/) - Java 23 hello world
* [java23-java-info](pocs/java23-java-info/) - Print JVM and runtime info on Java 23
* [jdk-23-features](pocs/jdk-23-features/) - JDK 23 features
* [java-23-module-info-system](pocs/java-23-module-info-system/) - Java module system with module-info
* [java-23-code-organization](pocs/java-23-code-organization/) - Different ways to organize the code of a service
* [java-25-helloworld](pocs/java-25-helloworld/) - Java 25 hello world
* [java-25-playground-features](pocs/java-25-playground-features/) - Java 25 JEPs, including PEM encodings of crypto objects
* [java-25-stable-values-rulez](pocs/java-25-stable-values-rulez/) - Java 25 Stable Values for lazy constants
* [java-26-playground](pocs/java-26-playground/) - Java 26 features
* [java-27-fun](pocs/java-27-fun/) - Every JEP shipped in JDK 27, nine of them
* [java-simd-fun](pocs/java-simd-fun/) - SIMD with the Vector API
* [java-optional-fun](pocs/java-optional-fun/) - Optional done right and done wrong
* [for-range](pocs/for-range/) - Ranges instead of classic for loops
* [loops-poc](pocs/loops-poc/) - Different ways to write loops
* [java-array-index1](pocs/java-array-index1/) - Array indexing corner cases
* [sun-array-fun](pocs/sun-array-fun/) - Summing an array range and the off-by-one trap
* [java-nan](pocs/java-nan/) - How NaN behaves in Java
* [java-double-precision](pocs/java-double-precision/) - Double precision surprises
* [double-initialization](pocs/double-initialization/) - Double brace initialization and its cost
* [string-format-fun](pocs/string-format-fun/) - String formatting options
* [string-encodings](pocs/string-encodings/) - String charsets and encodings
* [regex-fun-styles](pocs/regex-fun-styles/) - Regex styles in Java
* [date-hell-api](pocs/date-hell-api/) - Why the old Date API hurts
* [jsr-310-java-date](pocs/jsr-310-java-date/) - JSR-310 java.time API
* [modern-java-io](pocs/modern-java-io/) - Modern java.nio file IO
* [nio-memory-mapped-files-fun](pocs/nio-memory-mapped-files-fun/) - NIO memory-mapped files
* [java-print-stacktrace-string](pocs/java-print-stacktrace-string/) - Turn a stack trace into a String
* [stack-trace-to-string-fun](pocs/stack-trace-to-string-fun/) - Stack trace to String, another take
* [caller-fun](pocs/caller-fun/) - Finding out who called a method
* [weakref-fun](pocs/weakref-fun/) - Weak references and the GC
* [packagelevel-fun](pocs/packagelevel-fun/) - Package-private visibility
* [process-builder-fun](pocs/process-builder-fun/) - Run OS processes with ProcessBuilder
* [linux-process](pocs/linux-process/) - Call Linux processes from Java
* [java-props-iso-simple](pocs/java-props-iso-simple/) - Isolated system properties
* [properties-find-load-fun](pocs/properties-find-load-fun/) - Find and load properties files
* [java-sandbox](pocs/java-sandbox/) - Java sandbox for quick ideas
* [debug-playground](pocs/debug-playground/) - Debugging playground
* [gr34](pocs/gr34/) - Gradle, asserts and TestNG basics
* [dop-exp-simple](pocs/dop-exp-simple/) - Data oriented programming experiment with a small bench
* [effective-java-3-code](pocs/effective-java-3-code/) - Code from Effective Java 3rd edition
* [java-refactoring](pocs/java-refactoring/) - Refactoring exercises

## 🧵 Concurrency & Virtual Threads

Threads, executors and futures let one JVM do many things at once.
Virtual threads make blocking code cheap again.

* [10m-virtual-threads](pocs/10m-virtual-threads/) - Spawning 10 million virtual threads
* [1m-concurrent-connections-java](pocs/1m-concurrent-connections-java/) - One million concurrent connections
* [virtual-threads-fun](pocs/virtual-threads-fun/) - Virtual threads basics
* [virtual-threads-limit-os-threads-java](pocs/virtual-threads-limit-os-threads-java/) - Virtual threads with a limited number of OS threads
* [java21-virtual-threads-and-threadlocal](pocs/java21-virtual-threads-and-threadlocal/) - Virtual threads and ThreadLocal
* [green-threads-java19](pocs/green-threads-java19/) - Green threads preview on Java 19
* [completablefuture-21](pocs/completablefuture-21/) - CompletableFuture on Java 21
* [async-java8-composition](pocs/async-java8-composition/) - Composing async calls with Java 8
* [future-land](pocs/future-land/) - Futures playground
* [java-concurrent](pocs/java-concurrent/) - java.util.concurrent tour
* [java8-producer-consumer](pocs/java8-producer-consumer/) - Producer and consumer with Java 8
* [concurrent-hashmap-fun](pocs/concurrent-hashmap-fun/) - ConcurrentHashMap behavior
* [cow-copy-onwrite-arraylist](pocs/cow-copy-onwrite-arraylist/) - CopyOnWriteArrayList
* [reset-atomic-interger-fun](pocs/reset-atomic-interger-fun/) - Resetting an AtomicInteger safely
* [data-corruption-threads](pocs/data-corruption-threads/) - Data corruption from unsafe sharing between threads
* [dont-do-it-stop-threads](pocs/dont-do-it-stop-threads/) - Why you should not stop threads
* [java-timeout-fun](pocs/java-timeout-fun/) - Timeouts on blocking work
* [executors-metrics](pocs/executors-metrics/) - Metrics for executor pools
* [task-scheduller-poc](pocs/task-scheduller-poc/) - Task scheduler with reused threads
* [dynamic-queues](pocs/dynamic-queues/) - Queues created at runtime
* [lock-seq-generator](pocs/lock-seq-generator/) - Sequence generator with locks
* [poison-pill-pattern](pocs/poison-pill-pattern/) - Stopping consumers with a poison pill
* [jctools-fun](pocs/jctools-fun/) - JCTools lock-free queues
* [agrona-fun](pocs/agrona-fun/) - Agrona high performance primitives
* [parseq-fun](pocs/parseq-fun/) - LinkedIn ParSeq async tasks
* [akka-playground](pocs/akka-playground/) - Akka actors from Java
* [MBassador-fun](pocs/MBassador-fun/) - MBassador event bus
* [seda-pipeline-memory-v0](pocs/seda-pipeline-memory-v0/) - SEDA pipeline in memory, back to basics
* [seda-pipeline-memory](pocs/seda-pipeline-memory/) - SEDA pipeline in memory, one thread per worker
* [seda-pipeline-memory-v2](pocs/seda-pipeline-memory-v2/) - SEDA pipeline v2 on Spring Boot 3
* [seda-pipeline-memory-v3](pocs/seda-pipeline-memory-v3/) - SEDA pipeline v3
* [seda-pipeline-memory-v4](pocs/seda-pipeline-memory-v4/) - SEDA pipeline v4
* [seda-pipeline-memory-v5](pocs/seda-pipeline-memory-v5/) - SEDA pipeline v5
* [seda-pipeline-memory-v6](pocs/seda-pipeline-memory-v6/) - SEDA pipeline v6 with virtual threads
* [seda-pipeline-memory-v7](pocs/seda-pipeline-memory-v7/) - SEDA pipeline v7 with leaky bucket backpressure
* [seda-pipeline-memory-v8](pocs/seda-pipeline-memory-v8/) - SEDA pipeline v8 with leaky bucket backpressure
* [seda-pipeline-memory-v9](pocs/seda-pipeline-memory-v9/) - SEDA pipeline v9 with a restore process

## λ Functional Programming & Collections

Lambdas and streams bring a functional style to Java.
Collection libraries add immutable, persistent and primitive collections.

* [fp-java](pocs/fp-java/) - Functional programming in Java
* [java8-fp](pocs/java8-fp/) - Functional programming with Java 8
* [java-23-fp-ideas](pocs/java-23-fp-ideas/) - Functional programming ideas on Java 23
* [lazy-fp-fun](pocs/lazy-fp-fun/) - Lazy evaluation
* [high-order-functions-like](pocs/high-order-functions-like/) - High order functions
* [functional-interfaces-fun](pocs/functional-interfaces-fun/) - Functional interfaces
* [functional-interfaces-land-fun](pocs/functional-interfaces-land-fun/) - More functional interfaces
* [simple-streams](pocs/simple-streams/) - Streams basics
* [java-streams-pipes](pocs/java-streams-pipes/) - Streams as pipes
* [collectors-fun](pocs/collectors-fun/) - Stream collectors
* [groupping-map-reduce](pocs/groupping-map-reduce/) - Grouping and map-reduce with streams
* [simple-iterator](pocs/simple-iterator/) - Custom iterator
* [vavr_fun](pocs/vavr_fun/) - Vavr functional library
* [java-slang-playground](pocs/java-slang-playground/) - Javaslang, the old name of Vavr
* [cactoos-fun](pocs/cactoos-fun/) - Cactoos object oriented primitives
* [noexception-fun](pocs/noexception-fun/) - NoException for checked exceptions in lambdas
* [noexceptions-fun](pocs/noexceptions-fun/) - Handling exceptions in lambdas
* [eclipse-collections-fun](pocs/eclipse-collections-fun/) - Eclipse Collections
* [java23-eclipse-collections](pocs/java23-eclipse-collections/) - Eclipse Collections on Java 23
* [java23-eclipse-collections-containers](pocs/java23-eclipse-collections-containers/) - Eclipse Collections containers
* [java23-eclipse-collections-primitives](pocs/java23-eclipse-collections-primitives/) - Eclipse Collections primitive collections
* [pcollections-fun](pocs/pcollections-fun/) - PCollections persistent collections
* [immutables-fun](pocs/immutables-fun/) - Immutables value objects
* [larray-fun](pocs/larray-fun/) - LArray for arrays bigger than 2GB

## 🌀 Reactive Programming

Reactive libraries model data as streams with backpressure.
They let a few threads handle a lot of IO.

* [reactor-fun](pocs/reactor-fun/) - Project Reactor basics
* [reactor-fun-p2](pocs/reactor-fun-p2/) - Project Reactor part 2
* [flux-mono-ctx](pocs/flux-mono-ctx/) - Passing a message id through the Reactor context
* [reactor-netty-simple](pocs/reactor-netty-simple/) - Reactor Netty HTTP
* [reactor-netty-tcp-fun](pocs/reactor-netty-tcp-fun/) - Reactor Netty TCP
* [rxJavaFun](pocs/rxJavaFun/) - RxJava
* [rxjava3_fun](pocs/rxjava3_fun/) - RxJava 3
* [rxjava-local-continnuations](pocs/rxjava-local-continnuations/) - RxJava and thread local continuations
* [graphql-rx-fun](pocs/graphql-rx-fun/) - GraphQL with RxJava
* [webflux-rest-client](pocs/webflux-rest-client/) - WebFlux WebClient
* [vertx-postgres-reactive-fun](pocs/vertx-postgres-reactive-fun/) - Vert.x reactive Postgres client
* [hibernate-reactive-fun](pocs/hibernate-reactive-fun/) - Hibernate Reactive

## 🌱 Spring Boot

Spring Boot is the most used way to build Java services.
These POCs go from Boot 1.x up to Boot 4 on Java 25.

* [simple-sandbox-boot-1x](pocs/simple-sandbox-boot-1x/) - Spring Boot 1.x sandbox
* [spring-boot-2-4-0-java-15-simple](pocs/spring-boot-2-4-0-java-15-simple/) - Spring Boot 2.4 on Java 15
* [jdk-17-spring-boot-2.5.5](pocs/jdk-17-spring-boot-2.5.5/) - Spring Boot 2.5 on JDK 17
* [spring-boot-2-console-app](pocs/spring-boot-2-console-app/) - Spring Boot 2 console app
* [spring-boot-2-fun-config](pocs/spring-boot-2-fun-config/) - Spring Cloud Config server
* [spring-boot-2-fun-eureka](pocs/spring-boot-2-fun-eureka/) - Eureka service discovery
* [spring-boot-2-fun-web](pocs/spring-boot-2-fun-web/) - Spring Boot 2 web app
* [spring-boot-2-fun-zuul](pocs/spring-boot-2-fun-zuul/) - Zuul gateway
* [spring-boot-2-lightclient](pocs/spring-boot-2-lightclient/) - Light HTTP client on Boot 2
* [spring-boot-2-mTLS-fun](pocs/spring-boot-2-mTLS-fun/) - Mutual TLS on Boot 2
* [spring-boot-2-tls](pocs/spring-boot-2-tls/) - TLS on Boot 2
* [spring-boot-2-netty-fun](pocs/spring-boot-2-netty-fun/) - Boot 2 on Netty
* [spring-boot-2-netty-post](pocs/spring-boot-2-netty-post/) - POST handling on Boot 2 with Netty
* [spring-boot2-netty-fun](pocs/spring-boot2-netty-fun/) - Boot 2 with Netty, another take
* [spring2-web-netty](pocs/spring2-web-netty/) - Spring 2 web on Netty
* [spring-boot-2-swagger-fun](pocs/spring-boot-2-swagger-fun/) - Swagger API docs
* [spring-boot-2.6.6-http2](pocs/spring-boot-2.6.6-http2/) - HTTP/2 on Boot 2.6
* [spring-boot-26-caffeine-fun](pocs/spring-boot-26-caffeine-fun/) - Caffeine cache on Boot 2.6
* [spring-boot-2x-exception-handler](pocs/spring-boot-2x-exception-handler/) - Global exception handler
* [spring-boot-2x-logs-fun](pocs/spring-boot-2x-logs-fun/) - Logging on Boot 2
* [spring-boot-2x-multipart-upload](pocs/spring-boot-2x-multipart-upload/) - Multipart file upload
* [spring-boot-2x-web-security](pocs/spring-boot-2x-web-security/) - Spring Security on Boot 2
* [spring-boot2-aop-fun](pocs/spring-boot2-aop-fun/) - AOP with Spring
* [springboot2-endpoints-by-actuator-fun](pocs/springboot2-endpoints-by-actuator-fun/) - Custom Actuator endpoints
* [spring-boot3x-first](pocs/spring-boot3x-first/) - First Spring Boot 3 app
* [spring-boot-3.1x-fun](pocs/spring-boot-3.1x-fun/) - Spring Boot 3.1
* [spring-boot-3.1-async-fun](pocs/spring-boot-3.1-async-fun/) - Async on Boot 3.1
* [spring-boot-3.2-fun](pocs/spring-boot-3.2-fun/) - Spring Boot 3.2
* [spring-boot-3.2-Scheduled](pocs/spring-boot-3.2-Scheduled/) - @Scheduled on Boot 3.2
* [spring-boot-3.2-ws-simple-fun](pocs/spring-boot-3.2-ws-simple-fun/) - Web services on Boot 3.2
* [java-21-spring-boot-3x](pocs/java-21-spring-boot-3x/) - Spring Boot 3 on Java 21
* [java-21-spring-boot-3-async](pocs/java-21-spring-boot-3-async/) - Async on Boot 3 and Java 21
* [java-21-spring-boot-3-async-tomcat](pocs/java-21-spring-boot-3-async-tomcat/) - Async on Tomcat
* [java-21-spring-boot-3-async-virtual-threads](pocs/java-21-spring-boot-3-async-virtual-threads/) - Async on virtual threads
* [java23-springboot-3x](pocs/java23-springboot-3x/) - Spring Boot 3 on Java 23
* [java-25-spring-boot-3.5](pocs/java-25-spring-boot-3.5/) - Spring Boot 3.5 on Java 25
* [java-25-sb-4x](pocs/java-25-sb-4x/) - Spring Boot 4 on Java 25
* [java-25-sb-4-api-versioning](pocs/java-25-sb-4-api-versioning/) - API versioning in Spring Boot 4
* [spring-boot-3x-rest-pure](pocs/spring-boot-3x-rest-pure/) - Plain REST on Boot 3
* [spring-boot-3x-gson](pocs/spring-boot-3x-gson/) - Gson instead of Jackson
* [spring-boot-3x-http2](pocs/spring-boot-3x-http2/) - HTTP/2 on Boot 3
* [spring-boot-3x-startup-info](pocs/spring-boot-3x-startup-info/) - Startup info and timings
* [spring-boot-3x-shutdown-executors](pocs/spring-boot-3x-shutdown-executors/) - Graceful shutdown of executors
* [spring-boot-3x-actuator-netty-shutdown](pocs/spring-boot-3x-actuator-netty-shutdown/) - Shutdown through Actuator on Netty
* [spring-boot-3x-actuator-get-internal-metrics](pocs/spring-boot-3x-actuator-get-internal-metrics/) - Reading Actuator metrics from inside the app
* [spring-boot-3x-actuator-health-checker-experiments](pocs/spring-boot-3x-actuator-health-checker-experiments/) - Custom health checks
* [spring-boot-long-pooling-3x](pocs/spring-boot-long-pooling-3x/) - Long polling
* [spring-boot-websockets-fun](pocs/spring-boot-websockets-fun/) - WebSockets
* [spring-boot-rest-client-pool](pocs/spring-boot-rest-client-pool/) - REST client with a connection pool
* [spring-boot-native-image-fun](pocs/spring-boot-native-image-fun/) - Native image with GraalVM
* [native-creds-sc](pocs/native-creds-sc/) - WebFlux service built as a native image
* [spring-boot-gradlew](pocs/spring-boot-gradlew/) - Spring Boot with Gradle
* [spring-boot-cli-fun](pocs/spring-boot-cli-fun/) - Spring Boot CLI
* [spring-boot-propertysource](pocs/spring-boot-propertysource/) - @PropertySource
* [property-sources-spring-fun](pocs/property-sources-spring-fun/) - Custom property sources
* [spring-boot-groovy-prop-dumper](pocs/spring-boot-groovy-prop-dumper/) - Dump properties with Groovy
* [spring-boot-groovy-script-evail-deps](pocs/spring-boot-groovy-script-evail-deps/) - Evaluating Groovy scripts with dependencies
* [spring-restart-app](pocs/spring-restart-app/) - Restart the app from inside
* [spring-web-conditional-beans-jars](pocs/spring-web-conditional-beans-jars/) - @ConditionalOnClass and @ConditionalOnMissingClass
* [spring-configuration-order-poc](pocs/spring-configuration-order-poc/) - Configuration ordering
* [spring-value-fun](pocs/spring-value-fun/) - @Value injection
* [spring-validation-fun](pocs/spring-validation-fun/) - Bean validation
* [spring-retry-fun](pocs/spring-retry-fun/) - Spring Retry
* [spring-security-boot-simple](pocs/spring-security-boot-simple/) - Spring Security basics
* [okta-spring-boot-26](pocs/okta-spring-boot-26/) - Okta login on Boot 2.6
* [okta-spring-boot-security-27x](pocs/okta-spring-boot-security-27x/) - Okta and Spring Security on Boot 2.7
* [java-25-spring-session-redis](pocs/java-25-spring-session-redis/) - Spring Session in Redis
* [java-25-spring-ws-fun](pocs/java-25-spring-ws-fun/) - Spring Web Services on Java 25
* [spring-shell-fun](pocs/spring-shell-fun/) - Spring Shell
* [spring-statemachine-fun](pocs/spring-statemachine-fun/) - Spring Statemachine
* [spring-vault](pocs/spring-vault/) - Spring Vault for secrets
* [spring-cloud-functions-fun](pocs/spring-cloud-functions-fun/) - Spring Cloud Function
* [spring-cloud-task-fun](pocs/spring-cloud-task-fun/) - Spring Cloud Task
* [spring-cloud-data-flow-fun](pocs/spring-cloud-data-flow-fun/) - Spring Cloud Data Flow
* [spring-dummy-factory-tst](pocs/spring-dummy-factory-tst/) - Factory beans
* [xmas-spring-boot](pocs/xmas-spring-boot/) - Christmas WebFlux app
* [audible_fun](pocs/audible_fun/) - Domain mapping with Orika on Spring
* [gs-contract-rest](pocs/gs-contract-rest/) - Spring guide: consumer driven contracts
* [gs-rest-service-cors](pocs/gs-rest-service-cors/) - Spring guide: REST with CORS
* [code-on-demand-restful-boot-js](pocs/code-on-demand-restful-boot-js/) - Code on Demand REST with HATEOAS

## 🍃 Classic Spring & Dependency Injection

Before Boot there was plain Spring with XML and JNDI.
Other DI containers like Guice and Avaje do the same job in different ways.

* [spring4-playground](pocs/spring4-playground/) - Spring 4 playground
* [spring4-java8-luna4-fun](pocs/spring4-java8-luna4-fun/) - Spring 4 on Java 8
* [spring-framework-3-tests](pocs/spring-framework-3-tests/) - Spring 3 tests
* [Exercicios-Spring-Framework](pocs/Exercicios-Spring-Framework/) - Spring Framework exercises
* [Adendo-Curso-Spring](pocs/Adendo-Curso-Spring/) - Spring course addendum
* [Adendo-Curso-Spring-JSF](pocs/Adendo-Curso-Spring-JSF/) - Spring and JSF course addendum
* [Spring-Integration](pocs/Spring-Integration/) - Spring Integration
* [spring-reflections-war](pocs/spring-reflections-war/) - Reflection inside a Spring WAR
* [spring-jndi-beans-jar](pocs/spring-jndi-beans-jar/) - Spring beans over JNDI, jar module
* [spring-jndi-beans-war](pocs/spring-jndi-beans-war/) - Spring beans over JNDI, war module
* [spring-jndi-beans-ejb-mdb](pocs/spring-jndi-beans-ejb-mdb/) - Spring beans over JNDI, EJB MDB module
* [spring-jndi-beans-ear](pocs/spring-jndi-beans-ear/) - Spring beans over JNDI, ear module
* [spring-shared-context-jar](pocs/spring-shared-context-jar/) - Shared Spring context, jar module
* [spring-shared-context-war](pocs/spring-shared-context-war/) - Shared Spring context, war module
* [spring-shared-context-ejb-mdb](pocs/spring-shared-context-ejb-mdb/) - Shared Spring context, EJB MDB module
* [spring-shared-context-ear](pocs/spring-shared-context-ear/) - Shared Spring context, ear module
* [ioc](pocs/ioc/) - Inversion of control from scratch
* [guice3](pocs/guice3/) - Google Guice 3
* [guice4-java-servlets](pocs/guice4-java-servlets/) - Guice 4 with servlets
* [guice-gdrl-fun](pocs/guice-gdrl-fun/) - Guice with Drools
* [governator-annotations](pocs/governator-annotations/) - Netflix Governator
* [avaje-inject-fun](pocs/avaje-inject-fun/) - Avaje Inject compile time DI

## 🚀 Other Frameworks & Runtimes

Lighter or different takes on building services in Java.
Most start faster and use less memory than a full Spring app.

* [quarkus-fun](pocs/quarkus-fun/) - Quarkus
* [quarkus-fun2](pocs/quarkus-fun2/) - Quarkus, second take
* [quarkus-hibernate-panache-fun](pocs/quarkus-hibernate-panache-fun/) - Quarkus with Hibernate Panache
* [quarkus-jpa-mysql-fun](pocs/quarkus-jpa-mysql-fun/) - Quarkus JPA on MySQL
* [quarkus-jpa-postgres-fun](pocs/quarkus-jpa-postgres-fun/) - Quarkus JPA on Postgres
* [qute-fun](pocs/qute-fun/) - Qute templates
* [micronaut-fun](pocs/micronaut-fun/) - Micronaut
* [micronaut-simple-mvn](pocs/micronaut-simple-mvn/) - Micronaut with Maven
* [helidon](pocs/helidon/) - Helidon
* [javalin-fun](pocs/javalin-fun/) - Javalin
* [vert.x-fun](pocs/vert.x-fun/) - Vert.x
* [vert.x-simple](pocs/vert.x-simple/) - Vert.x basics
* [vertx-epoll](pocs/vertx-epoll/) - Vert.x with native epoll
* [jooby-my-app](pocs/jooby-my-app/) - Jooby
* [blade-java-fun](pocs/blade-java-fun/) - Blade
* [lets-blade-fun](pocs/lets-blade-fun/) - Blade, second take
* [pippo-fun](pocs/pippo-fun/) - Pippo
* [inverno-fun](pocs/inverno-fun/) - Inverno
* [armerica-fun](pocs/armerica-fun/) - Armeria client and server
* [java-america-fun](pocs/java-america-fun/) - Armeria with Thrift
* [servicetalk-fun](pocs/servicetalk-fun/) - Apple ServiceTalk
* [baratine-pojo-microservices](pocs/baratine-pojo-microservices/) - Baratine POJO microservices
* [wilfly-swarm-fun](pocs/wilfly-swarm-fun/) - WildFly Swarm
* [NetflixOSS-pocs](pocs/NetflixOSS-pocs/) - NetflixOSS stack

## 🏛️ Java EE, App Servers & SOAP

The enterprise Java world: servlets, EJBs, JMS and app servers.
SOAP web services still run a lot of integrations.

* [jbossas7-jee6-playground](pocs/jbossas7-jee6-playground/) - JBoss AS 7 with Java EE 6
* [wildfly82-spring41-playground](pocs/wildfly82-spring41-playground/) - WildFly 8.2 with Spring 4.1
* [wildfly82-activemq510-mdb-playground](pocs/wildfly82-activemq510-mdb-playground/) - WildFly 8.2 MDBs on ActiveMQ 5.10
* [tomcat10-jakartaee9-simple](pocs/tomcat10-jakartaee9-simple/) - Tomcat 10 with Jakarta EE 9
* [tomcat10--spring-2-6-6-poc](pocs/tomcat10--spring-2-6-6-poc/) - Spring Boot 2.6 WAR on Tomcat 10
* [jetty-shutdown](pocs/jetty-shutdown/) - Jetty graceful shutdown
* [embeded-http-server-std-jdk-fun](pocs/embeded-http-server-std-jdk-fun/) - The HTTP server inside the JDK
* [jsp-counter-poc](pocs/jsp-counter-poc/) - Intercept every servlet and JSP call with a filter
* [struts-2-poc-simple](pocs/struts-2-poc-simple/) - Struts 2
* [cxf-fun](pocs/cxf-fun/) - Apache CXF
* [cxf-attachments-mtom](pocs/cxf-attachments-mtom/) - CXF attachments with MTOM
* [cxf-cglib-endpoint](pocs/cxf-cglib-endpoint/) - CXF endpoint from a CGLIB proxy
* [cxf-programatic-endpoint](pocs/cxf-programatic-endpoint/) - CXF endpoint created in code
* [rest-cxf-kid](pocs/rest-cxf-kid/) - REST with CXF
* [apache-cxf-jbossas5-camel](pocs/apache-cxf-jbossas5-camel/) - CXF and Camel on JBoss AS 5
* [terracota-test](pocs/terracota-test/) - Terracotta clustering
* [terracota-spring-test](pocs/terracota-spring-test/) - Terracotta with Spring

## 🌐 HTTP, Networking & RPC

Clients, servers and RPC frameworks that move bytes between services.
From raw sockets to gRPC, Thrift and GraphQL.

* [java-sockets](pocs/java-sockets/) - Plain Java sockets
* [java-netoworking](pocs/java-netoworking/) - Java networking basics
* [java-http-fun](pocs/java-http-fun/) - HTTP from Java
* [http-client2-poc-simple](pocs/http-client2-poc-simple/) - JDK HTTP Client
* [java-21-default-http-client-fun](pocs/java-21-default-http-client-fun/) - JDK HTTP Client on Java 21
* [http-playground-fun](pocs/http-playground-fun/) - HTTP playground
* [okhttp-fun](pocs/okhttp-fun/) - OkHttp
* [okhttp3-fun](pocs/okhttp3-fun/) - OkHttp 3
* [okhttp-client-http2-simple](pocs/okhttp-client-http2-simple/) - OkHttp over HTTP/2
* [retrofit-fun](pocs/retrofit-fun/) - Retrofit
* [unirest-fun](pocs/unirest-fun/) - Unirest
* [unirest-java-fun](pocs/unirest-java-fun/) - Unirest Java
* [smart-http-fun](pocs/smart-http-fun/) - smart-http server
* [simple-driver](pocs/simple-driver/) - Small HTTP driver behind a contract
* [netty4-fun](pocs/netty4-fun/) - Netty 4
* [netty-pure-fun](pocs/netty-pure-fun/) - Netty with no framework
* [netty-iouring-fun](pocs/netty-iouring-fun/) - Netty with io_uring
* [netty-iouring-fun2](pocs/netty-iouring-fun2/) - Netty with io_uring, second take
* [nio_uring-fun](pocs/nio_uring-fun/) - nio_uring
* [apache-mina-fun](pocs/apache-mina-fun/) - Apache MINA
* [mina-tcp-server-fun](pocs/mina-tcp-server-fun/) - MINA TCP server
* [mina-tcp--SSL-server-fun](pocs/mina-tcp--SSL-server-fun/) - MINA TCP server with SSL
* [jocket-fun](pocs/jocket-fun/) - Jocket low latency sockets
* [aeron-ipc-fun](pocs/aeron-ipc-fun/) - Aeron IPC
* [server-benchmarks-fun](pocs/server-benchmarks-fun/) - Tomcat and other servers benchmarked
* [google-grpc-fun](pocs/google-grpc-fun/) - gRPC
* [grpc-maven-fun](pocs/grpc-maven-fun/) - gRPC with Maven
* [grpc-spring-boot-starter-fun](pocs/grpc-spring-boot-starter-fun/) - gRPC Spring Boot starter
* [thrift-maven-fun](pocs/thrift-maven-fun/) - Apache Thrift
* [uber-tchannel-fun](pocs/uber-tchannel-fun/) - Uber TChannel
* [rSocket-fun](pocs/rSocket-fun/) - RSocket
* [rsocket_fun](pocs/rsocket_fun/) - RSocket, second take
* [graphql-java-fun](pocs/graphql-java-fun/) - graphql-java
* [simple-graphql-java](pocs/simple-graphql-java/) - GraphQL basics
* [dsg-fun](pocs/dsg-fun/) - Netflix DGS GraphQL
* [openapi-pet-client-generated](pocs/openapi-pet-client-generated/) - Client generated from the OpenAPI Petstore
* [java-25-replay-traffic-poc](pocs/java-25-replay-traffic-poc/) - Capture HTTP traffic at a proxy and replay it
* [ssh-manager](pocs/ssh-manager/) - SSH from Java

## 📨 Messaging & Streaming

Brokers and logs move events between services.
Stream processors compute on them as they arrive.

* [JMS-ActiveMQ](pocs/JMS-ActiveMQ/) - JMS on ActiveMQ
* [jms-binary-data](pocs/jms-binary-data/) - Binary payloads over JMS
* [activemq-web-ajax-rest](pocs/activemq-web-ajax-rest/) - ActiveMQ over AJAX and REST
* [hornetq-tests](pocs/hornetq-tests/) - HornetQ
* [hornetq-jboss-mdb](pocs/hornetq-jboss-mdb/) - HornetQ MDBs on JBoss
* [hornetq-camel-component](pocs/hornetq-camel-component/) - HornetQ Camel component
* [proton-simple](pocs/proton-simple/) - Qpid Proton AMQP
* [rabbitmq-simple-fun](pocs/rabbitmq-simple-fun/) - RabbitMQ
* [rabbimq-mvn-fun](pocs/rabbimq-mvn-fun/) - RabbitMQ with Maven
* [blazingmq-fun](pocs/blazingmq-fun/) - BlazingMQ
* [spring-apache-pulsar-fun](pocs/spring-apache-pulsar-fun/) - Apache Pulsar with Spring
* [pravega-simple](pocs/pravega-simple/) - Pravega streams
* [chronicle-queue-fun](pocs/chronicle-queue-fun/) - Chronicle Queue
* [Chronicle-Queue-fun-simple](pocs/Chronicle-Queue-fun-simple/) - Chronicle Queue basics
* [redis-streams-fun](pocs/redis-streams-fun/) - Redis Streams
* [spring-kafka-fun](pocs/spring-kafka-fun/) - Spring Kafka
* [kafka-streams-fun](pocs/kafka-streams-fun/) - Kafka Streams
* [kafka-streams-simple](pocs/kafka-streams-simple/) - Kafka Streams basics
* [kafka-streams-window-dedup](pocs/kafka-streams-window-dedup/) - Deduplication with Kafka Streams windows
* [ksqldb-java-fun](pocs/ksqldb-java-fun/) - ksqlDB Java client
* [java-21-kafka-flink-windoning-eo-purchases](pocs/java-21-kafka-flink-windoning-eo-purchases/) - Exactly-once windowed purchases with Kafka and Flink
* [java-21-kafka-spark-windoning-eo-purchases](pocs/java-21-kafka-spark-windoning-eo-purchases/) - Exactly-once windowed purchases with Kafka and Spark
* [java-25-kafka-ksqldb-windoning-eo-purchases](pocs/java-25-kafka-ksqldb-windoning-eo-purchases/) - Exactly-once windowed purchases with ksqlDB
* [java-25-kafka-streams-windoning-eo-purchases](pocs/java-25-kafka-streams-windoning-eo-purchases/) - Exactly-once windowed purchases with Kafka Streams
* [java-25-redis-windoning-eo-purchases](pocs/java-25-redis-windoning-eo-purchases/) - Exactly-once windowed purchases with Redis
* [java-25-rocksdb-windoning-eo-purchases](pocs/java-25-rocksdb-windoning-eo-purchases/) - Exactly-once windowed purchases with RocksDB
* [stock-matcher-engine](pocs/stock-matcher-engine/) - Pure memory stock matching engine
* [hazelcast-jet-fun](pocs/hazelcast-jet-fun/) - Hazelcast Jet
* [jest-fun](pocs/jest-fun/) - Word count on Hazelcast Jet
* [Esper-Fun](pocs/Esper-Fun/) - Esper complex event processing
* [debezium-cdc-fun](pocs/debezium-cdc-fun/) - Debezium CDC from Postgres 17 to Kafka
* [mysql-binlog-fun](pocs/mysql-binlog-fun/) - Reading the MySQL binlog
* [EventStoreClientFun](pocs/EventStoreClientFun/) - EventStoreDB client

## 🐪 Integration

Integration frameworks route messages between systems.
Camel is the main one here.

* [Apache-Camel](pocs/Apache-Camel/) - Apache Camel
* [camel-spring-boot2x-fun](pocs/camel-spring-boot2x-fun/) - Camel on Spring Boot 2
* [camel-activemq-pojo-routing](pocs/camel-activemq-pojo-routing/) - Camel POJO routing on ActiveMQ
* [camel-activemq-tests](pocs/camel-activemq-tests/) - Camel and ActiveMQ tests
* [camel-cxf-test](pocs/camel-cxf-test/) - Camel with CXF
* [camel-cxf-jms-test](pocs/camel-cxf-jms-test/) - Camel with CXF over JMS
* [camel-jms-request-reply](pocs/camel-jms-request-reply/) - Request and reply over JMS with Camel
* [camel-k-fun](pocs/camel-k-fun/) - Camel K on Kubernetes
* [etl-smooks-tests](pocs/etl-smooks-tests/) - Smooks ETL

## 🗄️ Databases & Persistence

Drivers, ORMs and migrations for relational and NoSQL databases.
Plus embedded stores that live inside the JVM.

* [hibernate-4-sequences-pocs](pocs/hibernate-4-sequences-pocs/) - Hibernate 4 sequences
* [hibernate-5-sequences-pocs](pocs/hibernate-5-sequences-pocs/) - Hibernate 5 sequences
* [hibernate-5-sequence-comparator](pocs/hibernate-5-sequence-comparator/) - Comparing Hibernate 5 sequence strategies
* [hibernate-5-data-test](pocs/hibernate-5-data-test/) - Hibernate 5 data tests
* [hibernate-5-jdbc-driver-observability](pocs/hibernate-5-jdbc-driver-observability/) - Observing Hibernate at the JDBC driver
* [hibernate-6-spring-2-6-6-poc](pocs/hibernate-6-spring-2-6-6-poc/) - Hibernate 6 on Spring Boot 2.6
* [hibernate-oracle-test-rollback-simple](pocs/hibernate-oracle-test-rollback-simple/) - Hibernate on Oracle with test rollback
* [java-25-hibernate-8-poc](pocs/java-25-hibernate-8-poc/) - Hibernate ORM 8 alpha on MySQL 9.7
* [spring-boot-2-jpa-mysql-simple](pocs/spring-boot-2-jpa-mysql-simple/) - JPA on MySQL
* [spring-boot-2-jpa-mysql-listeners](pocs/spring-boot-2-jpa-mysql-listeners/) - JPA entity listeners on MySQL
* [spring-boot-2x-data-jpa-h2](pocs/spring-boot-2x-data-jpa-h2/) - Spring Data JPA on H2
* [spring-boot-2x-data-jpa-h2-sequences](pocs/spring-boot-2x-data-jpa-h2-sequences/) - JPA sequences on H2
* [spring-boot-2x-data-jpa-h2-sequences-custon](pocs/spring-boot-2x-data-jpa-h2-sequences-custon/) - Custom JPA sequences on H2
* [query-dsl-spring-boot-2x-data-jpa-h2](pocs/query-dsl-spring-boot-2x-data-jpa-h2/) - Querydsl with Spring Data JPA
* [spring-boot-3-jpa-spring-REST](pocs/spring-boot-3-jpa-spring-REST/) - Spring Data REST
* [jdk17-spring-boot-2.6.4-spring-data-mysql](pocs/jdk17-spring-boot-2.6.4-spring-data-mysql/) - Spring Data on MySQL with JDK 17
* [java-21-spring-boot-3.x-spring-data-mysql](pocs/java-21-spring-boot-3.x-spring-data-mysql/) - Spring Data on MySQL with Java 21
* [java-21-spring-boot-3-mysql-partition](pocs/java-21-spring-boot-3-mysql-partition/) - MySQL 9 partitioning
* [java-21-spring-boot-3-postgres-partition](pocs/java-21-spring-boot-3-postgres-partition/) - Postgres 17 partitioning
* [java-21-spring-boot-3-postgres-partition-hash](pocs/java-21-spring-boot-3-postgres-partition-hash/) - Postgres hash partitioning
* [java-21-spring-boot-3-postgres-partition-hash-derived](pocs/java-21-spring-boot-3-postgres-partition-hash-derived/) - Postgres hash partitioning on a derived key
* [spring-data-jdbc-fun](pocs/spring-data-jdbc-fun/) - Spring Data JDBC
* [spring-data-jdbc-mysql-driver](pocs/spring-data-jdbc-mysql-driver/) - Spring Data JDBC on MySQL
* [spring-data-version](pocs/spring-data-version/) - Optimistic locking with @Version
* [spring-boot-3x-jOOQ-h2](pocs/spring-boot-3x-jOOQ-h2/) - jOOQ on H2
* [mybatis-mysql-spring-boot-fun](pocs/mybatis-mysql-spring-boot-fun/) - MyBatis on MySQL
* [java-25-postgres-pgrust-fun](pocs/java-25-postgres-pgrust-fun/) - Spring Data JDBC on pgrust
* [java-25-spring-supabase](pocs/java-25-spring-supabase/) - Spring with Supabase
* [mysql-ids-poc](pocs/mysql-ids-poc/) - ID strategies on MySQL
* [connection-pools-party](pocs/connection-pools-party/) - JDBC connection pools compared
* [flyway-fun](pocs/flyway-fun/) - Flyway migrations
* [liquibase-postgress](pocs/liquibase-postgress/) - Liquibase on Postgres
* [liquid-unit-poc](pocs/liquid-unit-poc/) - Liquibase plus JUnit
* [utPLSQL-test](pocs/utPLSQL-test/) - utPLSQL tests for PL/SQL
* [JSqlParser-fun](pocs/JSqlParser-fun/) - Parsing SQL with JSqlParser
* [java-25-apache-calcite](pocs/java-25-apache-calcite/) - Apache Calcite SQL
* [duckdb-fun](pocs/duckdb-fun/) - DuckDB
* [duckdb_jdbc_fun](pocs/duckdb_jdbc_fun/) - DuckDB over JDBC
* [cassandra-kundera-fun](pocs/cassandra-kundera-fun/) - Cassandra with Kundera
* [cass-mapper-fun](pocs/cass-mapper-fun/) - Cassandra object mapper
* [cass-dual-writer](pocs/cass-dual-writer/) - Dual writes during a Cassandra migration
* [cass-diff-ids-poc](pocs/cass-diff-ids-poc/) - Diffing ids between Cassandra clusters
* [astra-cassandra-poc](pocs/astra-cassandra-poc/) - DataStax Astra
* [astra-java-driver-fun](pocs/astra-java-driver-fun/) - Astra with the Java driver
* [sstable-adaptor-fun](pocs/sstable-adaptor-fun/) - Reading Cassandra SSTables
* [jedis-pool-fun](pocs/jedis-pool-fun/) - Jedis pool
* [jedis-cluster-docker](pocs/jedis-cluster-docker/) - Jedis on a Redis cluster
* [jedis-redis-hashlots](pocs/jedis-redis-hashlots/) - Redis cluster hash slots
* [java-jedis-module-fun](pocs/java-jedis-module-fun/) - Redis modules with Jedis
* [jdbc-redis-client-test](pocs/jdbc-redis-client-test/) - Redis over JDBC
* [lettuce-redis-simple](pocs/lettuce-redis-simple/) - Lettuce
* [lettuce-redis-fix](pocs/lettuce-redis-fix/) - Lettuce fix
* [lettuce-redis-modules](pocs/lettuce-redis-modules/) - Redis modules with Lettuce
* [lettuce-redis-pubsub](pocs/lettuce-redis-pubsub/) - Redis pub/sub with Lettuce
* [lettuce-codecs](pocs/lettuce-codecs/) - Lettuce codecs
* [redis-lettuce-6](pocs/redis-lettuce-6/) - Lettuce 6
* [redis-diff-poc](pocs/redis-diff-poc/) - Diffing Redis data
* [spring-data-redis-mappings-boot2](pocs/spring-data-redis-mappings-boot2/) - Spring Data Redis mappings
* [recovery-leader-election-process](pocs/recovery-leader-election-process/) - Leader election with Redis
* [elastic-search-java-driver-fun](pocs/elastic-search-java-driver-fun/) - Elasticsearch Java client
* [elastic-search-java-driver-fun-8](pocs/elastic-search-java-driver-fun-8/) - Elasticsearch 8 Java client
* [spring-data-elasticsearch-5](pocs/spring-data-elasticsearch-5/) - Spring Data Elasticsearch 5
* [java-25-spring-boot-4-elastich-search-indexes](pocs/java-25-spring-boot-4-elastich-search-indexes/) - Daily Elasticsearch indexes with a sliding window
* [es6-plugin](pocs/es6-plugin/) - Elasticsearch plugin
* [lucene3-playground](pocs/lucene3-playground/) - Lucene 3
* [lucune-fun](pocs/lucune-fun/) - Lucene
* [FAST-taining](pocs/FAST-taining/) - FAST ESP search client
* [neo4j-simple-fun](pocs/neo4j-simple-fun/) - Neo4j
* [arrangodb-java-fun](pocs/arrangodb-java-fun/) - ArangoDB
* [thinkerpop-poc](pocs/thinkerpop-poc/) - Apache TinkerPop
* [titan-poc](pocs/titan-poc/) - Titan graph database
* [graphstream-fun](pocs/graphstream-fun/) - GraphStream graphs
* [rethinkdb-java-fun](pocs/rethinkdb-java-fun/) - RethinkDB
* [xtdb-java-25](pocs/xtdb-java-25/) - XTDB bitemporal database
* [java-25-aws-dynamo-db-local](pocs/java-25-aws-dynamo-db-local/) - Bookstore on DynamoDB Local
* [java-23-eclipsestore](pocs/java-23-eclipsestore/) - EclipseStore object persistence
* [prevayler-fun](pocs/prevayler-fun/) - Prevayler prevalence
* [mapdb-fun](pocs/mapdb-fun/) - MapDB
* [xodus-fun](pocs/xodus-fun/) - JetBrains Xodus
* [hawtdb-fun](pocs/hawtdb-fun/) - HawtDB
* [paldb-poc](pocs/paldb-poc/) - LinkedIn PalDB
* [java-25-netflix-hollow](pocs/java-25-netflix-hollow/) - Netflix Hollow datasets
* [etcd3-client-poc](pocs/etcd3-client-poc/) - etcd v3 client
* [Apache-Curator-Playground](pocs/Apache-Curator-Playground/) - ZooKeeper with Curator
* [java-21-glusterfs](pocs/java-21-glusterfs/) - GlusterFS from Java 21
* [java-21-minio](pocs/java-21-minio/) - MinIO
* [java-21-s3-minio](pocs/java-21-s3-minio/) - S3 API against MinIO

## ⚡ Caching & In-Memory Data Grids

Caches keep hot data close to the code.
Data grids spread it across many JVMs.

* [cache-playground](pocs/cache-playground/) - Caching playground
* [caffeine-fun](pocs/caffeine-fun/) - Caffeine cache
* [guava-ttl](pocs/guava-ttl/) - Guava cache with TTL
* [expiringmap-fun](pocs/expiringmap-fun/) - ExpiringMap
* [simple-LRU-cache](pocs/simple-LRU-cache/) - LRU cache from scratch
* [coherence-fun](pocs/coherence-fun/) - Oracle Coherence
* [ignite-fun](pocs/ignite-fun/) - Apache Ignite
* [ignite-maven-simple](pocs/ignite-maven-simple/) - Apache Ignite with Maven
* [Atomix-Fun](pocs/Atomix-Fun/) - Atomix
* [jgroups-discoverability](pocs/jgroups-discoverability/) - JGroups discovery
* [chronicle-map-multi-process-jvm](pocs/chronicle-map-multi-process-jvm/) - Chronicle Map shared across JVMs
* [wurmloch-crdt-fun](pocs/wurmloch-crdt-fun/) - CRDTs with Wurmloch

## 🛡️ Resilience & Fault Tolerance

Remote calls fail, get slow and time out.
Circuit breakers, retries, rate limits and chaos keep the service alive.

* [HystrixFun](pocs/HystrixFun/) - Netflix Hystrix
* [resilience4j-fun](pocs/resilience4j-fun/) - Resilience4j
* [resilience4j-patterns](pocs/resilience4j-patterns/) - Resilience patterns with Resilience4j
* [failsafe-fun](pocs/failsafe-fun/) - Failsafe
* [bucket4j-rate-limiting](pocs/bucket4j-rate-limiting/) - Rate limiting with Bucket4j
* [ribbon-fun](pocs/ribbon-fun/) - Netflix Ribbon load balancing
* [circular-executor-poc](pocs/circular-executor-poc/) - Protecting calls to a bad downstream dependency
* [circular-executor-poc-v2](pocs/circular-executor-poc-v2/) - Protecting calls to a bad downstream dependency, v2
* [toxiproxy-java-fun](pocs/toxiproxy-java-fun/) - Network chaos with Toxiproxy
* [byte-monkey-fun](pocs/byte-monkey-fun/) - Bytecode fault injection with Byte-Monkey
* [ff4j-fun](pocs/ff4j-fun/) - Feature flags with FF4J

## 📊 Observability, Logging & Metrics

Logs, metrics and traces explain what a service is doing.
Here with Log4j2, Logback, Micrometer, Zipkin and X-Ray.

* [lo4j2-fun](pocs/lo4j2-fun/) - Log4j2
* [lo4j2-async-log-fun](pocs/lo4j2-async-log-fun/) - Log4j2 async logging
* [log4j2-omg-simple](pocs/log4j2-omg-simple/) - Log4j2 basics
* [tinylog-fatjar-shade-fun](pocs/tinylog-fatjar-shade-fun/) - tinylog in a shaded fat jar
* [logback-exception-spring-boot](pocs/logback-exception-spring-boot/) - Logback exceptions on Spring Boot
* [logback-structured-logging-spring-boot](pocs/logback-structured-logging-spring-boot/) - Structured logging with Logback
* [spring-boot-3x-logback-configs](pocs/spring-boot-3x-logback-configs/) - Logback configs on Boot 3
* [spring-boot-3x-logback-loki](pocs/spring-boot-3x-logback-loki/) - Logback into Loki
* [spring-boot-custom-logger](pocs/spring-boot-custom-logger/) - Custom logger on Spring Boot
* [spring-boot-custom-logger-log4j](pocs/spring-boot-custom-logger-log4j/) - Custom Log4j logger on Spring Boot
* [springboot2-agent-logs](pocs/springboot2-agent-logs/) - Logs through a Java agent
* [java-log-splunk-fun](pocs/java-log-splunk-fun/) - Logging to Splunk
* [dropwizard-metrics-fun](pocs/dropwizard-metrics-fun/) - Dropwizard Metrics
* [micrometer-prometheus-spring-boot-fun](pocs/micrometer-prometheus-spring-boot-fun/) - Micrometer and Prometheus
* [custom-metrics-error-ob-fun](pocs/custom-metrics-error-ob-fun/) - Custom error metrics
* [cloudwatch-custom-metrics-superfun](pocs/cloudwatch-custom-metrics-superfun/) - Custom CloudWatch metrics
* [quartz-observability](pocs/quartz-observability/) - Observing Quartz jobs
* [zipkin-java-fun](pocs/zipkin-java-fun/) - Zipkin tracing
* [wingtips-zipkin-java](pocs/wingtips-zipkin-java/) - Wingtips tracing into Zipkin
* [aws-xray-fun](pocs/aws-xray-fun/) - AWS X-Ray tracing
* [aws-xray-playground](pocs/aws-xray-playground/) - AWS X-Ray playground
* [audit-trail-poc](pocs/audit-trail-poc/) - Audit trail for a series of operations
* [bookkeeping-auditability-records](pocs/bookkeeping-auditability-records/) - Auditable bookkeeping records

## 🔀 Scheduling, Batch & Workflows

Jobs that run on a schedule, in batches or as long workflows.
They retry, resume and keep state between steps.

* [quartz-scheduler](pocs/quartz-scheduler/) - Quartz scheduler
* [quartz-advanced](pocs/quartz-advanced/) - Quartz advanced features
* [quartz-reschedule](pocs/quartz-reschedule/) - Rescheduling Quartz jobs
* [cron-testing](pocs/cron-testing/) - Testing cron expressions
* [cron-testing-spring](pocs/cron-testing-spring/) - Testing Spring cron expressions
* [spring-boot-job-testing-endpoint](pocs/spring-boot-job-testing-endpoint/) - Scheduled jobs you can also trigger for tests
* [SpringBatchFun](pocs/SpringBatchFun/) - Spring Batch
* [spring-batch-tests](pocs/spring-batch-tests/) - Spring Batch tests
* [spring-batch-test-proof-concept](pocs/spring-batch-test-proof-concept/) - Spring Batch testing proof of concept
* [cadence-uber-fun](pocs/cadence-uber-fun/) - Uber Cadence workflows
* [workflow-patterns-fun](pocs/workflow-patterns-fun/) - Workflow patterns
* [rulebook-fun](pocs/rulebook-fun/) - RuleBook rules engine
* [state-behaivor](pocs/state-behaivor/) - State driven behavior

## 🔐 Security & Cryptography

Encryption, hashing, signatures, keys and certificates.
Plus auth with JWT and scanners that find security bugs.

* [security-aes256-fun](pocs/security-aes256-fun/) - AES-256
* [security-file-enc-dec](pocs/security-file-enc-dec/) - Encrypt and decrypt files
* [security-generate-key-java](pocs/security-generate-key-java/) - Generating keys
* [security-n-keys-java](pocs/security-n-keys-java/) - Working with many keys
* [security-google-tink-fun](pocs/security-google-tink-fun/) - Google Tink
* [security-hash-sha256](pocs/security-hash-sha256/) - SHA-256
* [security-hmac256](pocs/security-hmac256/) - HMAC-SHA256
* [security-md5-fun](pocs/security-md5-fun/) - MD5
* [security-signature-fun](pocs/security-signature-fun/) - Digital signatures
* [security-java-keystore-jks-fun](pocs/security-java-keystore-jks-fun/) - Java KeyStore
* [security-kms-fun](pocs/security-kms-fun/) - AWS KMS
* [sec-asm-fun](pocs/sec-asm-fun/) - Secrets Manager
* [sec-bouncycastle-openpgp-fun](pocs/sec-bouncycastle-openpgp-fun/) - OpenPGP with Bouncy Castle
* [sec-find-sec-bugs-maven-simple](pocs/sec-find-sec-bugs-maven-simple/) - Find Security Bugs with Maven
* [bouncy-castle-generate-certificate-jks-fun](pocs/bouncy-castle-generate-certificate-jks-fun/) - Generate certificates into a JKS with Bouncy Castle
* [pgpainless-fun](pocs/pgpainless-fun/) - PGPainless
* [pkcs8-read-simple-poc](pocs/pkcs8-read-simple-poc/) - Reading PKCS#8 keys
* [pkcs8-simple-pocs](pocs/pkcs8-simple-pocs/) - PKCS#8 keys
* [key-fingerprints-fun](pocs/key-fingerprints-fun/) - Key fingerprints
* [commons-crypto-fun](pocs/commons-crypto-fun/) - Apache Commons Crypto
* [encryption-deep-dive-poc](pocs/encryption-deep-dive-poc/) - Encryption deep dive
* [dumb-encryption-poc](pocs/dumb-encryption-poc/) - A naive encryption to learn from
* [compression-encryption-encoding-fun](pocs/compression-encryption-encoding-fun/) - Compression vs encryption vs encoding
* [secure-random-fun](pocs/secure-random-fun/) - SecureRandom
* [entropy-fun](pocs/entropy-fun/) - Measuring entropy
* [passay-fun](pocs/passay-fun/) - Password rules with Passay
* [mvn-pass-enc-poc-simple](pocs/mvn-pass-enc-poc-simple/) - Encrypted passwords in Maven
* [jwt-java-fun](pocs/jwt-java-fun/) - JWT
* [java-25-apache-shiro](pocs/java-25-apache-shiro/) - Apache Shiro
* [pii-simple-detector-fun](pocs/pii-simple-detector-fun/) - Detecting PII
* [credit-card-validation](pocs/credit-card-validation/) - Credit card number validation

## 🧪 Testing

Unit, integration, contract, property-based and mutation testing.
Plus mocks, fakes, containers and browser automation.

* [junit-5-features-fun](pocs/junit-5-features-fun/) - JUnit 5 features
* [junit5-super-fun](pocs/junit5-super-fun/) - More JUnit 5
* [junit5-extended](pocs/junit5-extended/) - JUnit 5 extensions
* [junit5-launcher-fun](pocs/junit5-launcher-fun/) - JUnit 5 launcher API
* [junit5-test-gen](pocs/junit5-test-gen/) - Generated tests in JUnit 5
* [junit5-guice-test-fun](pocs/junit5-guice-test-fun/) - JUnit 5 with Guice
* [junit5kubernetes-fun](pocs/junit5kubernetes-fun/) - JUnit 5 against Kubernetes
* [junit-5-java-21-suites](pocs/junit-5-java-21-suites/) - JUnit 5 suites on Java 21
* [junit-runners-fun](pocs/junit-runners-fun/) - JUnit 4 runners
* [java-25-junit-tag-control](pocs/java-25-junit-tag-control/) - Running tests by JUnit tag
* [testing-junit5-parametrization](pocs/testing-junit5-parametrization/) - Parameterized tests
* [testing-junit5-tests-in-runtime-fun](pocs/testing-junit5-tests-in-runtime-fun/) - Tests created at runtime
* [testing-junit-5-timeout-fun](pocs/testing-junit-5-timeout-fun/) - Test timeouts
* [testing-junit5-maven3-console-working](pocs/testing-junit5-maven3-console-working/) - JUnit 5 console with Maven 3
* [testing-junit-5-mockito-statics](pocs/testing-junit-5-mockito-statics/) - Mocking statics with Mockito
* [testing-mockito-final-fun](pocs/testing-mockito-final-fun/) - Mocking final classes
* [testing-mockito-hamcrest-fun](pocs/testing-mockito-hamcrest-fun/) - Mockito with Hamcrest
* [testing-powermock-fun](pocs/testing-powermock-fun/) - PowerMock
* [testing-powermock-mockito-fun](pocs/testing-powermock-mockito-fun/) - PowerMock with Mockito
* [hamcrest-fun](pocs/hamcrest-fun/) - Hamcrest matchers
* [java-25-testing-custom-matchers-hamcrest](pocs/java-25-testing-custom-matchers-hamcrest/) - Custom Hamcrest 3 matchers for images and JSON
* [testing-assertj-fun](pocs/testing-assertj-fun/) - AssertJ
* [java-truth-assertion-land](pocs/java-truth-assertion-land/) - Google Truth
* [spock-fun](pocs/spock-fun/) - Spock
* [scala-test](pocs/scala-test/) - ScalaTest
* [awaitility](pocs/awaitility/) - Awaitility for async tests
* [annotations-testing-poc](pocs/annotations-testing-poc/) - Testing annotations
* [visible-for-testing-fun](pocs/visible-for-testing-fun/) - @VisibleForTesting
* [java-snapshot-testing-fun](pocs/java-snapshot-testing-fun/) - Snapshot testing
* [json_snapshot_fun](pocs/json_snapshot_fun/) - JSON snapshot testing
* [selfie-fun](pocs/selfie-fun/) - Selfie snapshot testing
* [test-property-based-testing-jqwik-fun](pocs/test-property-based-testing-jqwik-fun/) - Property-based testing with jqwik
* [jqwiki-basic-fun](pocs/jqwiki-basic-fun/) - jqwik basics
* [test-property-based-testing-junitquickcheck-fun](pocs/test-property-based-testing-junitquickcheck-fun/) - Property-based testing with junit-quickcheck
* [junit_quickcheck_fun](pocs/junit_quickcheck_fun/) - junit-quickcheck
* [quicktheories_fun](pocs/quicktheories_fun/) - QuickTheories
* [pitest-java-fun](pocs/pitest-java-fun/) - PIT mutation testing
* [pitest-mutation-testing-mvn-fun](pocs/pitest-mutation-testing-mvn-fun/) - PIT mutation testing with Maven
* [test_pitest_fun](pocs/test_pitest_fun/) - PIT, another take
* [jacoco-what-a-name](pocs/jacoco-what-a-name/) - JaCoCo coverage
* [jacoco-what-a-name-2](pocs/jacoco-what-a-name-2/) - JaCoCo coverage, second take
* [instancio-fun](pocs/instancio-fun/) - Instancio test data
* [testing-javafaker-fun](pocs/testing-javafaker-fun/) - Java Faker test data
* [testing-mockneat-fun](pocs/testing-mockneat-fun/) - MockNeat test data
* [rest-assured-fun](pocs/rest-assured-fun/) - REST Assured
* [testing-bdd-karate-fun](pocs/testing-bdd-karate-fun/) - Karate BDD
* [testing-consumer-driven-contracts-pact-fun](pocs/testing-consumer-driven-contracts-pact-fun/) - Consumer driven contracts with Pact
* [wiremock-fun](pocs/wiremock-fun/) - WireMock
* [testing-mock-server-java-fun](pocs/testing-mock-server-java-fun/) - MockServer
* [hoverfly-api-simulation](pocs/hoverfly-api-simulation/) - API simulation with Hoverfly
* [docker-testing](pocs/docker-testing/) - Testing with Docker
* [testContainers-spring4](pocs/testContainers-spring4/) - Testcontainers with Spring 4
* [testContainers-mysql-podman](pocs/testContainers-mysql-podman/) - Testcontainers MySQL on Podman
* [testContainers-localstack-aws](pocs/testContainers-localstack-aws/) - Testcontainers with LocalStack
* [java-25-test-containers-reuse](pocs/java-25-test-containers-reuse/) - Reusing Testcontainers between runs
* [testing-aws-lambda-java-tests](pocs/testing-aws-lambda-java-tests/) - Testing AWS Lambda functions
* [hibernate-testing-poc](pocs/hibernate-testing-poc/) - Testing Hibernate
* [spring-boot-2-rest-testing](pocs/spring-boot-2-rest-testing/) - REST testing on Boot 2
* [spring-boot-2-testing-mock-jpa](pocs/spring-boot-2-testing-mock-jpa/) - Mocking JPA on Boot 2
* [testing-spring-boot-2-mocking](pocs/testing-spring-boot-2-mocking/) - Mocking on Boot 2
* [testing-spring-boot-2-test-rest-template](pocs/testing-spring-boot-2-test-rest-template/) - TestRestTemplate
* [testing-spring-boot-2x-mockmvc](pocs/testing-spring-boot-2x-mockmvc/) - MockMvc
* [testing-spring-boot-test-values](pocs/testing-spring-boot-test-values/) - Test property values
* [testing-spring-reflection-utils](pocs/testing-spring-reflection-utils/) - Spring ReflectionTestUtils
* [spring-boot-3-test-drity-context](pocs/spring-boot-3-test-drity-context/) - @DirtiesContext
* [spring-boot-4-java-25-testing-interface](pocs/spring-boot-4-java-25-testing-interface/) - A testing interface isolated from the app code
* [html-unit-simple-test](pocs/html-unit-simple-test/) - HtmlUnit
* [selenide-fun](pocs/selenide-fun/) - Selenide
* [selenium-download-file](pocs/selenium-download-file/) - Downloading files with Selenium
* [playwright-fun](pocs/playwright-fun/) - Playwright
* [jmh-bench](pocs/jmh-bench/) - JMH benchmarks
* [jmh-maven-fun](pocs/jmh-maven-fun/) - JMH with Maven
* [graalvm-bench](pocs/graalvm-bench/) - GraalVM benchmarks

## 🧬 Serialization & Data Formats

How objects become bytes and text, and back.
JSON, binary formats, schemas and codecs.

* [avro-fun](pocs/avro-fun/) - Apache Avro
* [protobuf-poc](pocs/protobuf-poc/) - Protocol Buffers
* [flatbuffers-java-fun](pocs/flatbuffers-java-fun/) - FlatBuffers
* [kryo-fun](pocs/kryo-fun/) - Kryo
* [kryo-5.6-maven](pocs/kryo-5.6-maven/) - Kryo 5.6
* [apache-fury-serialization](pocs/apache-fury-serialization/) - Apache Fury
* [ion-java-fun](pocs/ion-java-fun/) - Amazon Ion
* [arrow-fun](pocs/arrow-fun/) - Apache Arrow
* [serde-benchmarks](pocs/serde-benchmarks/) - Serialization libraries benchmarked
* [tson-java-java25](pocs/tson-java-java25/) - tson-java on Java 25
* [jackson-backward-forward-compatibility](pocs/jackson-backward-forward-compatibility/) - Backward and forward compatibility with Jackson
* [jackson-specific-typez](pocs/jackson-specific-typez/) - Jackson polymorphic types
* [jodd-json-simple-fun](pocs/jodd-json-simple-fun/) - Jodd JSON
* [minimal-json-fun](pocs/minimal-json-fun/) - minimal-json
* [jparse-simple-fun](pocs/jparse-simple-fun/) - JParse
* [rjson-fun](pocs/rjson-fun/) - rjson
* [hjson-java-simple-poc](pocs/hjson-java-simple-poc/) - Hjson
* [jsonpath-fun](pocs/jsonpath-fun/) - JsonPath
* [jsonschema-fun](pocs/jsonschema-fun/) - JSON Schema validation
* [json-regex-fun](pocs/json-regex-fun/) - JSON with regex
* [jolt-fun](pocs/jolt-fun/) - JSON to JSON transforms with Jolt
* [java-json-parser-custom-fun](pocs/java-json-parser-custom-fun/) - Custom JSON parser
* [java-one-class-json-parser](pocs/java-one-class-json-parser/) - JSON parser in one class, no dependencies
* [simple-json-parser-fun](pocs/simple-json-parser-fun/) - Simple JSON parser
* [xstream-playground](pocs/xstream-playground/) - XStream
* [xstream-advanced-converter](pocs/xstream-advanced-converter/) - XStream custom converters
* [opencsv-java-fun](pocs/opencsv-java-fun/) - OpenCSV
* [apple-pkl](pocs/apple-pkl/) - Apple Pkl config language
* [remap-fun](pocs/remap-fun/) - reMap object mapping
* [byte-buffer-fun](pocs/byte-buffer-fun/) - ByteBuffer
* [byte-buffer-commons](pocs/byte-buffer-commons/) - ByteBuffer utilities
* [byte-buffers-enc](pocs/byte-buffers-enc/) - Encoding with ByteBuffers

## 🔣 Hashing, Encoding & Compression

Fast hashes, checksums, IDs and compression codecs.

* [murmur3-java](pocs/murmur3-java/) - MurmurHash3
* [xxHash-java](pocs/xxHash-java/) - xxHash
* [wyhash-hash-java](pocs/wyhash-hash-java/) - wyhash
* [GxHash-java](pocs/GxHash-java/) - GxHash
* [CRC32-java](pocs/CRC32-java/) - CRC32
* [checksun-java-fun](pocs/checksun-java-fun/) - Checksums
* [consistent-hashing](pocs/consistent-hashing/) - Consistent hashing
* [base62-java](pocs/base62-java/) - Base62
* [hex-binary-and-back](pocs/hex-binary-and-back/) - Hex to binary and back
* [uuid-fun](pocs/uuid-fun/) - UUIDs
* [uuid-simple](pocs/uuid-simple/) - UUID basics
* [gzip-fun](pocs/gzip-fun/) - Gzip
* [gzip-fun-2](pocs/gzip-fun-2/) - Gzip, second take
* [gzip-checker-fun](pocs/gzip-checker-fun/) - Detecting gzip content
* [lz4-fun](pocs/lz4-fun/) - LZ4
* [snappy-compression-fun](pocs/snappy-compression-fun/) - Snappy

## 🧮 Algorithms, Data Structures & Numbers

Probabilistic structures, sampling, bit tricks and precise math.

* [bloom-filter-fun](pocs/bloom-filter-fun/) - Bloom filter
* [bloom-filter-java](pocs/bloom-filter-java/) - Bloom filter from scratch
* [roaring-bitmap-fun](pocs/roaring-bitmap-fun/) - Roaring bitmaps
* [bitwise-fun](pocs/bitwise-fun/) - Bitwise operations
* [bitwise-mask-count-unique](pocs/bitwise-mask-count-unique/) - Counting unique values with bit masks
* [random-sampling](pocs/random-sampling/) - Random sampling
* [simple-sampling](pocs/simple-sampling/) - Sampling
* [simple-sampling-interval](pocs/simple-sampling-interval/) - Sampling by interval
* [genetic-algorithm-simple](pocs/genetic-algorithm-simple/) - Genetic algorithm
* [big-decimal-facts](pocs/big-decimal-facts/) - BigDecimal facts
* [big-decimal-maths](pocs/big-decimal-maths/) - Math with BigDecimal
* [big-int-fun](pocs/big-int-fun/) - BigInteger
* [modulo-1097](pocs/modulo-1097/) - Factorial modulo 10^9+7
* [commons-rng-fun](pocs/commons-rng-fun/) - Apache Commons RNG
* [strange-quantun-fun](pocs/strange-quantun-fun/) - Quantum computing with Strange
* [fizz-buzz-noif](pocs/fizz-buzz-noif/) - FizzBuzz with no if
* [max-without-if](pocs/max-without-if/) - Max with no if
* [us-holidats-simple](pocs/us-holidats-simple/) - US holidays calculator

## 🏗️ Design, OOP & Architecture

Design patterns, better OOP and ways to structure code.
Plus tools that enforce the architecture.

* [design-patterns](pocs/design-patterns/) - Classic GoF design patterns
* [DDD-specification](pocs/DDD-specification/) - DDD specification pattern
* [specification-simple](pocs/specification-simple/) - Specification pattern
* [static-factory-pattern](pocs/static-factory-pattern/) - Static factory methods
* [proper-singletons](pocs/proper-singletons/) - Singletons done right
* [Fluent-Interface](pocs/Fluent-Interface/) - Fluent interfaces
* [polimorfismo](pocs/polimorfismo/) - Polymorphism
* [WrapperPrinterLayer](pocs/WrapperPrinterLayer/) - Wrapping a printer behind layers
* [sample-printer-fun](pocs/sample-printer-fun/) - Printer abstraction
* [proper-oop-media-poc](pocs/proper-oop-media-poc/) - Better OOP design
* [oop-anti-patterns](pocs/oop-anti-patterns/) - OOP anti-patterns
* [if-alternatives-fun](pocs/if-alternatives-fun/) - Alternatives to if
* [if-killer-proper-oop](pocs/if-killer-proper-oop/) - Killing ifs with OOP
* [java-ifless](pocs/java-ifless/) - Code with no ifs
* [validators-anti-if-simple](pocs/validators-anti-if-simple/) - Validators with no ifs
* [std-java-validations-fun](pocs/std-java-validations-fun/) - Validation with plain Java
* [visibility-control-design-poc](pocs/visibility-control-design-poc/) - Controlling visibility in a design
* [archunit-fun](pocs/archunit-fun/) - ArchUnit
* [java-25-archunit-testing](pocs/java-25-archunit-testing/) - Architecture tests with ArchUnit on Spring Boot

## 🪞 Bytecode, Reflection & Class Loading

The JVM lets code look at itself and change itself at runtime.
Proxies, agents, bytecode generation and class loaders.

* [bytebuddy-fun](pocs/bytebuddy-fun/) - Byte Buddy
* [cglib-playground](pocs/cglib-playground/) - CGLIB
* [javapoet-fun](pocs/javapoet-fun/) - JavaPoet code generation
* [javaparser-fun](pocs/javaparser-fun/) - JavaParser
* [java-string-compilation-jdk-fun](pocs/java-string-compilation-jdk-fun/) - Compiling Java source from a String
* [janio-fun](pocs/janio-fun/) - Janino runtime compiler
* [java-proxy](pocs/java-proxy/) - Dynamic proxies
* [default-proxy-fun](pocs/default-proxy-fun/) - Proxies for default methods
* [byteman-fun](pocs/byteman-fun/) - Byteman bytecode injection
* [agent-fun](pocs/agent-fun/) - Java agent
* [springboot2-agent-fun](pocs/springboot2-agent-fun/) - Java agent on Spring Boot 2
* [unsafe-simple](pocs/unsafe-simple/) - sun.misc.Unsafe
* [reflectasm-fun](pocs/reflectasm-fun/) - ReflectASM
* [reflections-playground](pocs/reflections-playground/) - Reflections library
* [org-reflections-fun](pocs/org-reflections-fun/) - org.reflections scanning
* [private-field-access-fun](pocs/private-field-access-fun/) - Accessing private fields
* [scannotation-fun](pocs/scannotation-fun/) - Scannotation
* [annotations-on-annotations-fun](pocs/annotations-on-annotations-fun/) - Annotations on annotations
* [LombokFun](pocs/LombokFun/) - Lombok
* [spi-poc-fun](pocs/spi-poc-fun/) - Service Provider Interface
* [classloaders-fun](pocs/classloaders-fun/) - Class loaders
* [class-loaders-iso-simple](pocs/class-loaders-iso-simple/) - Isolation with class loaders
* [custom-class-loader-fun](pocs/custom-class-loader-fun/) - Custom class loader
* [dependencies-show-directory](pocs/dependencies-show-directory/) - Showing where each dependency is loaded from

## 🧰 Build Tools

Maven, Gradle, Bazel, Buck and friends.
Plugins, BOMs, shading and native images.

* [hello-maven-plugin](pocs/hello-maven-plugin/) - Maven plugin
* [simple-maven-plugin](pocs/simple-maven-plugin/) - Maven plugin on Java 23
* [maven-bom-fun](pocs/maven-bom-fun/) - Maven BOM
* [maven-unused-dependencies-fun](pocs/maven-unused-dependencies-fun/) - Finding unused Maven dependencies
* [java-maven-properties](pocs/java-maven-properties/) - Maven properties in Java
* [build-number-fun](pocs/build-number-fun/) - Build numbers
* [polyglot-maven-fun](pocs/polyglot-maven-fun/) - Polyglot Maven
* [shade-fun](pocs/shade-fun/) - Maven Shade
* [revapi-maven-java-poc](pocs/revapi-maven-java-poc/) - API compatibility checks with Revapi
* [open-rewrite-simple-poc](pocs/open-rewrite-simple-poc/) - OpenRewrite
* [gradle-7-fun](pocs/gradle-7-fun/) - Gradle 7
* [gradle-fetch-from-github](pocs/gradle-fetch-from-github/) - Gradle dependencies from GitHub
* [gradle-github](pocs/gradle-github/) - Gradle and GitHub
* [gradle-system-args](pocs/gradle-system-args/) - Passing system args with Gradle
* [bazel-java-simple](pocs/bazel-java-simple/) - Bazel
* [bazel-monorepo-java](pocs/bazel-monorepo-java/) - Bazel monorepo
* [java21-bazel](pocs/java21-bazel/) - Bazel with Java 21
* [hello-buck-java](pocs/hello-buck-java/) - Buck
* [buck-monorepo-java](pocs/buck-monorepo-java/) - Buck monorepo
* [buildr](pocs/buildr/) - Apache Buildr
* [jbang-fun](pocs/jbang-fun/) - JBang
* [self-executable-bash-java](pocs/self-executable-bash-java/) - Self-executable jar from bash
* [graalvm-simple-jar](pocs/graalvm-simple-jar/) - GraalVM native image from a jar
* [jenkins-java](pocs/jenkins-java/) - Jenkins

## ☁️ Cloud, AWS & Serverless

AWS services from Java, local AWS emulators and serverless functions.

* [aws-s3-fun](pocs/aws-s3-fun/) - AWS S3
* [aws-sqs-fun](pocs/aws-sqs-fun/) - AWS SQS
* [aws-dynamodb-fun](pocs/aws-dynamodb-fun/) - AWS DynamoDB
* [aws-java-ips](pocs/aws-java-ips/) - AWS IP ranges
* [envos-utils-running-on-aws-fun](pocs/envos-utils-running-on-aws-fun/) - Detecting if the app runs on AWS
* [sqs-localstack-java21](pocs/sqs-localstack-java21/) - SQS on LocalStack with Java 21
* [java-25-floci-aws-sqs-sns-kinesis-msk-s3-fun](pocs/java-25-floci-aws-sqs-sns-kinesis-msk-s3-fun/) - SQS, SNS, Kinesis, MSK and S3 on Floci
* [sam-app-java11](pocs/sam-app-java11/) - AWS SAM app
* [serverless-java](pocs/serverless-java/) - Serverless Java
* [java-fn-openfaas](pocs/java-fn-openfaas/) - OpenFaaS function
* [terraform-cdk-fun](pocs/terraform-cdk-fun/) - Terraform CDK
* [Cfg4j-fun](pocs/Cfg4j-fun/) - cfg4j configuration
* [commons-configuration-fun](pocs/commons-configuration-fun/) - Apache Commons Configuration
* [jodd-props-simple-fun](pocs/jodd-props-simple-fun/) - Jodd Props

## 🎨 Templates, UI & Documents

Server-side templates, desktop UI and document generation.

* [thymeleaf-htmx-springboot](pocs/thymeleaf-htmx-springboot/) - Thymeleaf and htmx on Spring Boot
* [pebble-fun](pocs/pebble-fun/) - Pebble templates
* [jstachio-fun](pocs/jstachio-fun/) - JStachio Mustache templates
* [template-with-groovy-fun](pocs/template-with-groovy-fun/) - Groovy templates
* [jasper](pocs/jasper/) - JasperReports
* [ppt-poi-fun](pocs/ppt-poi-fun/) - PowerPoint with Apache POI
* [java-25-Tess4J-fun](pocs/java-25-Tess4J-fun/) - OCR on PNG and PDF with Tess4J and PDFBox
* [tika-charset-detector-fun](pocs/tika-charset-detector-fun/) - Charset detection with Tika
* [java-25-javafx-calc](pocs/java-25-javafx-calc/) - JavaFX calculator
* [picocli-fun](pocs/picocli-fun/) - CLI apps with picocli
* [Android-testTest](pocs/Android-testTest/) - Android test app

## 🧩 Libraries & Utilities

Useful libraries that do one thing well.

* [jsoup-simple](pocs/jsoup-simple/) - HTML parsing with jsoup
* [crawler-poc](pocs/crawler-poc/) - Web crawler
* [open-nlp-simple](pocs/open-nlp-simple/) - Apache OpenNLP
* [java-21-antlr-dsl](pocs/java-21-antlr-dsl/) - DSL with ANTLR
* [java-verbal-expressions-rgex-fun](pocs/java-verbal-expressions-rgex-fun/) - VerbalExpressions regex
* [time4j-fun](pocs/time4j-fun/) - Time4J
* [prettytime-fun](pocs/prettytime-fun/) - PrettyTime
* [github-api-fun](pocs/github-api-fun/) - GitHub API
* [github-co-pilot-java-fun](pocs/github-co-pilot-java-fun/) - Code written with GitHub Copilot
* [wisp-fun](pocs/wisp-fun/) - Wisp scheduler

## 🌍 Polyglot & Native Interop

Java calling other languages, and other JVM languages calling Java.

* [java-calling-rust-fun](pocs/java-calling-rust-fun/) - Java calling Rust as a dynamic library
* [java-calling-zig-fun](pocs/java-calling-zig-fun/) - Java calling Zig as a dynamic library
* [JPype-java8](pocs/JPype-java8/) - Python calling Java with JPype
* [groovy-4-maven-console-code-fun](pocs/groovy-4-maven-console-code-fun/) - Groovy 4 console with Maven
* [groovy-script-run-fun](pocs/groovy-script-run-fun/) - Running Groovy scripts from Java

## 🤖 Apps & AI

Full apps built end to end, and AI with Spring.

* [java-25-spring-ai-2-structured-outputs](pocs/java-25-spring-ai-2-structured-outputs/) - Self-correcting structured output with Spring AI 2
* [java-25-slack-clone](pocs/java-25-slack-clone/) - Self-hosted Slack-style team chat
* [gpt-5.6-sol-space](pocs/gpt-5.6-sol-space/) - Interactive solar system visualizer
