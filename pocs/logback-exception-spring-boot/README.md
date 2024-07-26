### Build
```bash
./mvnw clean install
```

### Result

```
curl -i http://localhost:8080/error
```

log
```
/home/diego/.sdkman/candidates/java/22.0.1-amzn/bin/java -javaagent:/home/diego/.local/share/JetBrains/Toolbox/apps/intellij-idea-community-edition/lib/idea_rt.jar=38093:/home/diego/.local/share/JetBrains/Toolbox/apps/intellij-idea-community-edition/bin -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /home/diego/git/diegopacheco/java-pocs/pocs/logback-exception-spring-boot/target/classes:/home/diego/.m2/repository/ch/qos/logback/logback-classic/1.5.6/logback-classic-1.5.6.jar:/home/diego/.m2/repository/ch/qos/logback/logback-core/1.5.6/logback-core-1.5.6.jar:/home/diego/.m2/repository/org/slf4j/slf4j-api/2.0.13/slf4j-api-2.0.13.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-webflux/3.3.2/spring-boot-starter-webflux-3.3.2.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter/3.3.2/spring-boot-starter-3.3.2.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot/3.3.2/spring-boot-3.3.2.jar:/home/diego/.m2/repository/org/springframework/spring-context/6.1.11/spring-context-6.1.11.jar:/home/diego/.m2/repository/org/springframework/spring-aop/6.1.11/spring-aop-6.1.11.jar:/home/diego/.m2/repository/org/springframework/spring-expression/6.1.11/spring-expression-6.1.11.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/3.3.2/spring-boot-autoconfigure-3.3.2.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-logging/3.3.2/spring-boot-starter-logging-3.3.2.jar:/home/diego/.m2/repository/org/slf4j/jul-to-slf4j/2.0.13/jul-to-slf4j-2.0.13.jar:/home/diego/.m2/repository/jakarta/annotation/jakarta.annotation-api/2.1.1/jakarta.annotation-api-2.1.1.jar:/home/diego/.m2/repository/org/yaml/snakeyaml/2.2/snakeyaml-2.2.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-json/3.3.2/spring-boot-starter-json-3.3.2.jar:/home/diego/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.17.2/jackson-databind-2.17.2.jar:/home/diego/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.17.2/jackson-annotations-2.17.2.jar:/home/diego/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.17.2/jackson-core-2.17.2.jar:/home/diego/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jdk8/2.17.2/jackson-datatype-jdk8-2.17.2.jar:/home/diego/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.17.2/jackson-datatype-jsr310-2.17.2.jar:/home/diego/.m2/repository/com/fasterxml/jackson/module/jackson-module-parameter-names/2.17.2/jackson-module-parameter-names-2.17.2.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-reactor-netty/3.3.2/spring-boot-starter-reactor-netty-3.3.2.jar:/home/diego/.m2/repository/io/projectreactor/netty/reactor-netty-http/1.1.21/reactor-netty-http-1.1.21.jar:/home/diego/.m2/repository/io/netty/netty-codec-http/4.1.111.Final/netty-codec-http-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-common/4.1.111.Final/netty-common-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-buffer/4.1.111.Final/netty-buffer-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-transport/4.1.111.Final/netty-transport-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-codec/4.1.111.Final/netty-codec-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-handler/4.1.111.Final/netty-handler-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-codec-http2/4.1.111.Final/netty-codec-http2-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-resolver-dns/4.1.111.Final/netty-resolver-dns-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-resolver/4.1.111.Final/netty-resolver-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-codec-dns/4.1.111.Final/netty-codec-dns-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-resolver-dns-native-macos/4.1.111.Final/netty-resolver-dns-native-macos-4.1.111.Final-osx-x86_64.jar:/home/diego/.m2/repository/io/netty/netty-resolver-dns-classes-macos/4.1.111.Final/netty-resolver-dns-classes-macos-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-transport-native-epoll/4.1.111.Final/netty-transport-native-epoll-4.1.111.Final-linux-x86_64.jar:/home/diego/.m2/repository/io/netty/netty-transport-native-unix-common/4.1.111.Final/netty-transport-native-unix-common-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-transport-classes-epoll/4.1.111.Final/netty-transport-classes-epoll-4.1.111.Final.jar:/home/diego/.m2/repository/io/projectreactor/netty/reactor-netty-core/1.1.21/reactor-netty-core-1.1.21.jar:/home/diego/.m2/repository/io/netty/netty-handler-proxy/4.1.111.Final/netty-handler-proxy-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-codec-socks/4.1.111.Final/netty-codec-socks-4.1.111.Final.jar:/home/diego/.m2/repository/org/springframework/spring-web/6.1.11/spring-web-6.1.11.jar:/home/diego/.m2/repository/org/springframework/spring-beans/6.1.11/spring-beans-6.1.11.jar:/home/diego/.m2/repository/org/springframework/spring-webflux/6.1.11/spring-webflux-6.1.11.jar:/home/diego/.m2/repository/io/projectreactor/reactor-core/3.6.8/reactor-core-3.6.8.jar:/home/diego/.m2/repository/org/reactivestreams/reactive-streams/1.0.4/reactive-streams-1.0.4.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-actuator/3.3.2/spring-boot-starter-actuator-3.3.2.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-actuator-autoconfigure/3.3.2/spring-boot-actuator-autoconfigure-3.3.2.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-actuator/3.3.2/spring-boot-actuator-3.3.2.jar:/home/diego/.m2/repository/io/micrometer/micrometer-observation/1.13.2/micrometer-observation-1.13.2.jar:/home/diego/.m2/repository/io/micrometer/micrometer-commons/1.13.2/micrometer-commons-1.13.2.jar:/home/diego/.m2/repository/io/micrometer/micrometer-jakarta9/1.13.2/micrometer-jakarta9-1.13.2.jar:/home/diego/.m2/repository/io/micrometer/micrometer-core/1.13.2/micrometer-core-1.13.2.jar:/home/diego/.m2/repository/org/hdrhistogram/HdrHistogram/2.2.2/HdrHistogram-2.2.2.jar:/home/diego/.m2/repository/org/latencyutils/LatencyUtils/2.0.3/LatencyUtils-2.0.3.jar:/home/diego/.m2/repository/org/springframework/spring-core/6.1.11/spring-core-6.1.11.jar:/home/diego/.m2/repository/org/springframework/spring-jcl/6.1.11/spring-jcl-6.1.11.jar com.github.diegopacheco.sandboxspring.Application

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.3.2)

2024-07-25 21:11:04 [main] INFO  c.g.d.sandboxspring.Application.logStarting - Starting Application using Java 22.0.1 with PID 1549345 (/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/logback-exception-spring-boot/target/classes started by diego in /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/logback-exception-spring-boot)
 2024-07-25 21:11:04 [main] INFO  c.g.d.sandboxspring.Application.logStartupProfileInfo - No active profile set, falling back to 1 default profile: "default"
 2024-07-25 21:11:06 [main] INFO  o.s.b.a.e.web.EndpointLinksResolver.<init> - Exposing 1 endpoint beneath base path '/actuator'
 2024-07-25 21:11:06 [main] INFO  o.s.b.w.e.netty.NettyWebServer.start - Netty started on port 8080 (http)
 2024-07-25 21:11:06 [main] INFO  c.g.d.sandboxspring.Application.logStarted - Started Application in 2.484 seconds (process running for 2.895)
 Spring Boot 3.3.x working! 
2024-07-25 21:11:13 [reactor-http-epoll-2] ERROR c.g.d.s.controller.HelloController.error - Accessed error endpoint
 java.lang.RuntimeException: Error fake
	at com.github.diegopacheco.sandboxspring.controller.HelloController.error(HelloController.java:20)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at org.springframework.web.reactive.result.method.InvocableHandlerMethod.lambda$invoke$0(InvocableHandlerMethod.java:198)
	at reactor.core.publisher.FluxFlatMap.trySubscribeScalarMap(FluxFlatMap.java:153)
	at reactor.core.publisher.MonoFlatMap.subscribeOrReturn(MonoFlatMap.java:53)
	at reactor.core.publisher.InternalMonoOperator.subscribe(InternalMonoOperator.java:63)
	at reactor.core.publisher.MonoDefer.subscribe(MonoDefer.java:53)
	at reactor.core.publisher.MonoIgnoreThen$ThenIgnoreMain.subscribeNext(MonoIgnoreThen.java:241)
	at reactor.core.publisher.MonoIgnoreThen$ThenIgnoreMain.onComplete(MonoIgnoreThen.java:204)
	at reactor.core.publisher.MonoFlatMap$FlatMapMain.onComplete(MonoFlatMap.java:189)
	at reactor.core.publisher.Operators.complete(Operators.java:137)
	at reactor.core.publisher.MonoZip.subscribe(MonoZip.java:121)
	at reactor.core.publisher.Mono.subscribe(Mono.java:4568)
	at reactor.core.publisher.MonoIgnoreThen$ThenIgnoreMain.subscribeNext(MonoIgnoreThen.java:265)
	at reactor.core.publisher.MonoIgnoreThen.subscribe(MonoIgnoreThen.java:51)
	at reactor.core.publisher.InternalMonoOperator.subscribe(InternalMonoOperator.java:76)
	at reactor.core.publisher.MonoFlatMap$FlatMapMain.onNext(MonoFlatMap.java:165)
	at reactor.core.publisher.FluxOnErrorResume$ResumeSubscriber.onNext(FluxOnErrorResume.java:79)
	at reactor.core.publisher.FluxSwitchIfEmpty$SwitchIfEmptySubscriber.onNext(FluxSwitchIfEmpty.java:74)
	at reactor.core.publisher.MonoNext$NextSubscriber.onNext(MonoNext.java:82)
	at reactor.core.publisher.FluxConcatMapNoPrefetch$FluxConcatMapNoPrefetchSubscriber.innerNext(FluxConcatMapNoPrefetch.java:259)
	at reactor.core.publisher.FluxConcatMap$ConcatMapInner.onNext(FluxConcatMap.java:865)
	at reactor.core.publisher.FluxMapFuseable$MapFuseableSubscriber.onNext(FluxMapFuseable.java:129)
	at reactor.core.publisher.MonoPeekTerminal$MonoTerminalPeekSubscriber.onNext(MonoPeekTerminal.java:180)
	at reactor.core.publisher.Operators$ScalarSubscription.request(Operators.java:2571)
	at reactor.core.publisher.MonoPeekTerminal$MonoTerminalPeekSubscriber.request(MonoPeekTerminal.java:139)
	at reactor.core.publisher.FluxMapFuseable$MapFuseableSubscriber.request(FluxMapFuseable.java:171)
	at reactor.core.publisher.Operators$MultiSubscriptionSubscriber.request(Operators.java:2331)
	at reactor.core.publisher.FluxConcatMapNoPrefetch$FluxConcatMapNoPrefetchSubscriber.request(FluxConcatMapNoPrefetch.java:339)
	at reactor.core.publisher.MonoNext$NextSubscriber.request(MonoNext.java:108)
	at reactor.core.publisher.Operators$MultiSubscriptionSubscriber.set(Operators.java:2367)
	at reactor.core.publisher.Operators$MultiSubscriptionSubscriber.onSubscribe(Operators.java:2241)
	at reactor.core.publisher.MonoNext$NextSubscriber.onSubscribe(MonoNext.java:70)
	at reactor.core.publisher.FluxConcatMapNoPrefetch$FluxConcatMapNoPrefetchSubscriber.onSubscribe(FluxConcatMapNoPrefetch.java:164)
	at reactor.core.publisher.FluxIterable.subscribe(FluxIterable.java:201)
	at reactor.core.publisher.FluxIterable.subscribe(FluxIterable.java:83)
	at reactor.core.publisher.InternalMonoOperator.subscribe(InternalMonoOperator.java:76)
	at reactor.core.publisher.MonoDefer.subscribe(MonoDefer.java:53)
	at reactor.core.publisher.Mono.subscribe(Mono.java:4568)
	at reactor.core.publisher.MonoIgnoreThen$ThenIgnoreMain.subscribeNext(MonoIgnoreThen.java:265)
	at reactor.core.publisher.MonoIgnoreThen.subscribe(MonoIgnoreThen.java:51)
	at reactor.core.publisher.InternalMonoOperator.subscribe(InternalMonoOperator.java:76)
	at reactor.core.publisher.MonoDeferContextual.subscribe(MonoDeferContextual.java:55)
	at reactor.netty.http.server.HttpServer$HttpServerHandle.onStateChange(HttpServer.java:1176)
	at reactor.netty.ReactorNetty$CompositeConnectionObserver.onStateChange(ReactorNetty.java:715)
	at reactor.netty.transport.ServerTransport$ChildObserver.onStateChange(ServerTransport.java:481)
	at reactor.netty.http.server.HttpServerOperations.onInboundNext(HttpServerOperations.java:781)
	at reactor.netty.channel.ChannelOperationsHandler.channelRead(ChannelOperationsHandler.java:115)
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:444)
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:420)
	at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:412)
	at reactor.netty.http.server.HttpTrafficHandler.channelRead(HttpTrafficHandler.java:259)
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:442)
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:420)
	at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:412)
	at io.netty.channel.CombinedChannelDuplexHandler$DelegatingChannelHandlerContext.fireChannelRead(CombinedChannelDuplexHandler.java:436)
	at io.netty.handler.codec.ByteToMessageDecoder.fireChannelRead(ByteToMessageDecoder.java:346)
	at io.netty.handler.codec.ByteToMessageDecoder.channelRead(ByteToMessageDecoder.java:318)
	at io.netty.channel.CombinedChannelDuplexHandler.channelRead(CombinedChannelDuplexHandler.java:251)
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:442)
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:420)
	at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:412)
	at io.netty.channel.DefaultChannelPipeline$HeadContext.channelRead(DefaultChannelPipeline.java:1407)
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:440)
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:420)
	at io.netty.channel.DefaultChannelPipeline.fireChannelRead(DefaultChannelPipeline.java:918)
	at io.netty.channel.epoll.AbstractEpollStreamChannel$EpollStreamUnsafe.epollInReady(AbstractEpollStreamChannel.java:799)
	at io.netty.channel.epoll.AbstractEpollChannel$AbstractEpollUnsafe$1.run(AbstractEpollChannel.java:425)
	at io.netty.util.concurrent.AbstractEventExecutor.runTask(AbstractEventExecutor.java:173)
	at io.netty.util.concurrent.AbstractEventExecutor.safeExecute(AbstractEventExecutor.java:166)
	at io.netty.util.concurrent.SingleThreadEventExecutor.runAllTasks(SingleThreadEventExecutor.java:469)
	at io.netty.channel.epoll.EpollEventLoop.run(EpollEventLoop.java:405)
	at io.netty.util.concurrent.SingleThreadEventExecutor$4.run(SingleThreadEventExecutor.java:994)
	at io.netty.util.internal.ThreadExecutorMap$2.run(ThreadExecutorMap.java:74)
	at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)
	at java.base/java.lang.Thread.run(Thread.java:1570)
Caused by: java.lang.RuntimeException: Error Root Fake
	... 77 common frames omitted
```