### Build 
```bash
./mvnw clean install 
```
### Result
```
❯ ./bin/pravega-standalone
Listening for transport dt_socket at address: 8050
2024-07-25 00:43:07,582 338  [main] INFO  i.p.local.LocalPravegaEmulator - Starting Pravega Emulator with ports: ZK port 4000, Controller port 9090, SegmentStore port 6000, Admin Gateway port 9999
2024-07-25 00:43:07,664 420  [main] INFO  i.p.local.LocalPravegaEmulator - 
InProcPravegaCluster(
	isInMemStorage=true
	clusterName=singlenode-663b04d9-b0fd-4062-a341-67fd631a640c
	enableAuth=false
	enableTls=false
	tlsProtocolVersion=[TLSv1.2
	TLSv1.3]
	enableTlsReload=false
	enableMetrics=false
	enableInfluxDB=false
	enablePrometheus=false
	metricsReportInterval=60
	isInProcController=true
	controllerCount=1
	controllerPorts=[9090]
	controllerURI=null
	restServerPort=9091
	isInProcSegmentStore=true
	segmentStoreCount=1
	segmentStorePorts=[6000]
	isInProcZK=true
	zkPort=4000
	zkHost=null
	zkService=null
	isInProcHDFS=false
	hdfsUrl=null
	containerCount=1
	nodeServiceStarter=null
	localHdfs=null
	controllerServers=null
	zkUrl=localhost:4000
	enableRestServer=true
	userName=
	passwd=
	certFile=
	keyFile=
	jksTrustFile=
	passwdFile=
	secureZK=false
	keyPasswordFile=
	jksKeyFile=
	enableAdminGateway=true
	adminGatewayPort=9999
	replyWithStackTraceOnError=true
)
2024-07-25 00:43:07,730 486  [main] INFO  i.p.s.s.i.b.ZooKeeperServiceRunner - Starting Zookeeper server at localhost:4000 ...
2024-07-25 00:43:08,119 875  [main] WARN  i.p.local.InProcPravegaCluster - Not able to delete path /pravega . Exception KeeperErrorCode = NoNode for /pravega
2024-07-25 00:43:08,122 878  [main] WARN  i.p.local.InProcPravegaCluster - Not able to delete path /hostIndex . Exception KeeperErrorCode = NoNode for /hostIndex
2024-07-25 00:43:08,125 881  [main] WARN  i.p.local.InProcPravegaCluster - Not able to delete path /store . Exception KeeperErrorCode = NoNode for /store
2024-07-25 00:43:08,129 885  [main] WARN  i.p.local.InProcPravegaCluster - Not able to delete path /taskIndex . Exception KeeperErrorCode = NoNode for /taskIndex
2024-07-25 00:43:08,312 1068 [ControllerServiceMain] INFO  i.p.c.server.ControllerServiceMain - Starting Controller Services.
2024-07-25 00:43:08,462 1218 [main] INFO  i.p.s.server.host.ServiceStarter - Initializing HealthService ...
2024-07-25 00:43:08,462 1218 [main] INFO  i.p.s.server.host.ServiceStarter - Initializing ZooKeeper Client ...
2024-07-25 00:43:08,464 1220 [main] INFO  i.p.s.server.host.ServiceStarter - Creating new Zookeeper client with arguments: localhost:4000, 10000, false.
2024-07-25 00:43:08,465 1221 [main] INFO  i.p.s.server.host.ServiceStarter - Initializing Service Builder ...
2024-07-25 00:43:08,513 1269 [main] INFO  i.p.s.server.host.ServiceStarter - Creating StreamSegmentService ...
2024-07-25 00:43:08,514 1270 [main] INFO  i.p.s.server.host.ServiceStarter - Creating TableStoreService ...
2024-07-25 00:43:08,516 1272 [main] INFO  i.p.s.server.host.ServiceStarter - Creating Segment Stats recorder ...
2024-07-25 00:43:09,051 1807 [main] INFO  i.p.s.server.host.ServiceStarter - ServiceConfig(containerCount: 1, coreThreadPoolSize: 20, storageThreadPoolSize: 200, listeningPort: 6000, listeningIPAddress: 0.0.0.0, publishedPort: 6000, publishedIPAddress: 0.0.0.0, parallelContainerStarts: 2, zkURL: localhost:4000, zkRetrySleepMs: 5000, zkSessionTimeoutMs: 10000, zkRetryCount: 5, secureZK: false, zkTrustStore is unspecified, zkTrustStorePasswordPath is unspecified, clusterName: singlenode-663b04d9-b0fd-4062-a341-67fd631a640c, dataLogTypeImplementation: INMEMORY, storageImplementation: INMEMORY, readOnlySegmentStore: false, enableTls: false, tlsProtocolVersion: [TLSv1.2, TLSv1.3], certFile is unspecified, keyFile is unspecified, enableTlsReload: false, cachePolicy is MaxSize = 134217728, UsableSize = 100663296, CriticalSize = 120795955, MaxGen = 60, Generation = PT1S, replyWithStackTraceOnError: true, instanceId: enableAdminGateway: true, adminGatewayPort: 9999healthCheckInterval: 10restListeningPort: 6061restListeningIPAddress: localhostrestServerEnabled: true)
2024-07-25 00:43:09,052 1808 [main] INFO  i.p.s.server.host.ServiceStarter - AutoScalerConfig(controllerUri: tcp://localhost:9090, internalRequestStream: _requeststream, cooldownDuration: PT10M, muteDuration: PT10M, cacheExpiry: PT20M, cacheCleanup: PT5M, tlsEnabled: false, tlsCertFile is unspecified, authEnabled: false, tokenSigningKey is specified, validateHostName: false, threadPoolSize: 10)
2024-07-25 00:43:09,248 2004 [main] INFO  i.p.s.server.host.ServiceStarter - PravegaConnectionListener started successfully.
2024-07-25 00:43:09,260 2016 [main] INFO  i.p.s.server.host.ServiceStarter - AdminConnectionListener started successfully.
2024-07-25 00:43:09,261 2017 [main] INFO  i.p.s.server.host.ServiceStarter - StreamSegmentService started.
2024-07-25 00:43:09,262 2018 [main] INFO  i.p.s.server.host.ServiceStarter - Initializing RESTServer ...
Jul 25, 2024 12:43:10 AM org.glassfish.jersey.internal.inject.Providers checkProviderRuntime
WARNING: A provider io.pravega.shared.health.bindings.resources.HealthImpl registered in SERVER runtime does not implement any provider interfaces applicable in the SERVER runtime. Due to constraint configuration problems the provider io.pravega.shared.health.bindings.resources.HealthImpl will be ignored. 
Jul 25, 2024 12:43:10 AM org.glassfish.jersey.internal.inject.Providers checkProviderRuntime
WARNING: A provider io.pravega.shared.health.bindings.resources.HealthImpl registered in SERVER runtime does not implement any provider interfaces applicable in the SERVER runtime. Due to constraint configuration problems the provider io.pravega.shared.health.bindings.resources.HealthImpl will be ignored. 
Jul 25, 2024 12:43:10 AM org.glassfish.jersey.internal.inject.Providers checkProviderRuntime
WARNING: A provider io.pravega.controller.server.rest.resources.PingImpl registered in SERVER runtime does not implement any provider interfaces applicable in the SERVER runtime. Due to constraint configuration problems the provider io.pravega.controller.server.rest.resources.PingImpl will be ignored. 
Jul 25, 2024 12:43:10 AM org.glassfish.jersey.internal.inject.Providers checkProviderRuntime
WARNING: A provider io.pravega.controller.server.rest.resources.StreamMetadataResourceImpl registered in SERVER runtime does not implement any provider interfaces applicable in the SERVER runtime. Due to constraint configuration problems the provider io.pravega.controller.server.rest.resources.StreamMetadataResourceImpl will be ignored. 
Jul 25, 2024 12:43:10 AM org.glassfish.grizzly.http.server.NetworkListener start
INFO: Started listener bound to [localhost:6061]
Jul 25, 2024 12:43:10 AM org.glassfish.grizzly.http.server.NetworkListener start
INFO: Started listener bound to [0.0.0.0:9091]
Jul 25, 2024 12:43:10 AM org.glassfish.grizzly.http.server.HttpServer start
INFO: [HttpServer] Started.
2024-07-25 00:43:10,816 3572 [main] INFO  i.p.local.LocalPravegaEmulator - 
2024-07-25 00:43:10,817 3573 [main] INFO  i.p.local.LocalPravegaEmulator - Pravega Sandbox is running locally now. You could access it at 127.0.0.1:9090.
2024-07-25 00:43:10,817 3573 [main] INFO  i.p.local.LocalPravegaEmulator - For more detailed logs, see: /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/bin/pravega-0.12.0/standalone/standalone.log
2024-07-25 00:43:10,817 3573 [main] INFO  i.p.local.LocalPravegaEmulator - 
Jul 25, 2024 12:43:10 AM org.glassfish.grizzly.http.server.HttpServer start
INFO: [HttpServer-1] Started.
2024-07-25 00:43:12,414 5170 [ControllerServiceMain] INFO  i.p.c.server.ControllerServiceMain - Controller Services started successfully.

```

```
2024-07-25 00:47:19 DEBUG InternalLoggerFactory:76 - Using Log4J2 as the default logging framework
2024-07-25 00:47:19 DEBUG PlatformDependent0:460 - -Dio.netty.noUnsafe: false
2024-07-25 00:47:19 DEBUG PlatformDependent0:954 - Java version: 21
2024-07-25 00:47:19 DEBUG PlatformDependent0:135 - sun.misc.Unsafe.theUnsafe: available
2024-07-25 00:47:19 DEBUG PlatformDependent0:159 - sun.misc.Unsafe.copyMemory: available
2024-07-25 00:47:19 DEBUG PlatformDependent0:202 - java.nio.Buffer.address: available
2024-07-25 00:47:19 DEBUG PlatformDependent0:285 - direct buffer constructor: unavailable: java.nio.DirectByteBuffer.<init>(long,int)
2024-07-25 00:47:19 DEBUG PlatformDependent0:350 - java.nio.Bits.unaligned: available, true
2024-07-25 00:47:19 DEBUG PlatformDependent0:417 - jdk.internal.misc.Unsafe.allocateUninitializedArray(int): unavailable: class io.grpc.netty.shaded.io.netty.util.internal.PlatformDependent0$6 cannot access class jdk.internal.misc.Unsafe (in module java.base) because module java.base does not export jdk.internal.misc to unnamed module @65d6b83b
2024-07-25 00:47:19 DEBUG PlatformDependent0:446 - java.nio.DirectByteBuffer.<init>(long, int): unavailable
2024-07-25 00:47:19 DEBUG PlatformDependent:1116 - sun.misc.Unsafe: available
2024-07-25 00:47:19 DEBUG PlatformDependent:1218 - maxDirectMemory: 16819159040 bytes (maybe)
2024-07-25 00:47:19 DEBUG PlatformDependent:1237 - -Dio.netty.tmpdir: /tmp (java.io.tmpdir)
2024-07-25 00:47:19 DEBUG PlatformDependent:1316 - -Dio.netty.bitMode: 64 (sun.arch.data.model)
2024-07-25 00:47:19 DEBUG PlatformDependent:178 - -Dio.netty.maxDirectMemory: -1 bytes
2024-07-25 00:47:19 DEBUG PlatformDependent:185 - -Dio.netty.uninitializedArrayAllocationThreshold: -1
2024-07-25 00:47:19 DEBUG CleanerJava9:71 - java.nio.ByteBuffer.cleaner(): available
2024-07-25 00:47:19 DEBUG PlatformDependent:205 - -Dio.netty.noPreferDirect: false
2024-07-25 00:47:19 DEBUG NativeLibraryLoader:75 - -Dio.netty.native.workdir: /tmp (io.netty.tmpdir)
2024-07-25 00:47:19 DEBUG NativeLibraryLoader:80 - -Dio.netty.native.deleteLibAfterLoading: true
2024-07-25 00:47:19 DEBUG NativeLibraryLoader:84 - -Dio.netty.native.tryPatchShadedId: true
2024-07-25 00:47:19 DEBUG NativeLibraryLoader:312 - Successfully loaded the library /tmp/libio_grpc_netty_shaded_netty_transport_native_epoll_x86_6417560805565243451441.so
2024-07-25 00:47:19 DEBUG NetUtil:135 - -Djava.net.preferIPv4Stack: false
2024-07-25 00:47:19 DEBUG NetUtil:136 - -Djava.net.preferIPv6Addresses: false
2024-07-25 00:47:19 DEBUG NetUtilInitializations:129 - Loopback interface: lo (lo, 0:0:0:0:0:0:0:1%lo)
2024-07-25 00:47:19 DEBUG NetUtil:169 - /proc/sys/net/core/somaxconn: 40000
2024-07-25 00:47:19 DEBUG MultithreadEventLoopGroup:44 - -Dio.netty.eventLoopThreads: 24
2024-07-25 00:47:19 DEBUG InternalThreadLocalMap:83 - -Dio.netty.threadLocalMap.stringBuilder.initialSize: 1024
2024-07-25 00:47:19 DEBUG InternalThreadLocalMap:86 - -Dio.netty.threadLocalMap.stringBuilder.maxSize: 4096
2024-07-25 00:47:19 DEBUG PlatformDependent:967 - org.jctools-core.MpscChunkedArrayQueue: available
2024-07-25 00:47:19 DEBUG ResourceLeakDetector:129 - -Dio.grpc.netty.shaded.io.netty.leakDetection.level: simple
2024-07-25 00:47:19 DEBUG ResourceLeakDetector:130 - -Dio.grpc.netty.shaded.io.netty.leakDetection.targetRecords: 4
2024-07-25 00:47:19 DEBUG AbstractByteBuf:63 - -Dio.grpc.netty.shaded.io.netty.buffer.checkAccessible: true
2024-07-25 00:47:19 DEBUG AbstractByteBuf:64 - -Dio.grpc.netty.shaded.io.netty.buffer.checkBounds: true
2024-07-25 00:47:19 DEBUG ResourceLeakDetectorFactory:196 - Loaded default ResourceLeakDetector: io.grpc.netty.shaded.io.netty.util.ResourceLeakDetector@10768c30
2024-07-25 00:47:19 DEBUG PooledByteBufAllocator:155 - -Dio.netty.allocator.numHeapArenas: 24
2024-07-25 00:47:19 DEBUG PooledByteBufAllocator:156 - -Dio.netty.allocator.numDirectArenas: 24
2024-07-25 00:47:19 DEBUG PooledByteBufAllocator:158 - -Dio.netty.allocator.pageSize: 8192
2024-07-25 00:47:19 DEBUG PooledByteBufAllocator:163 - -Dio.netty.allocator.maxOrder: 11
2024-07-25 00:47:19 DEBUG PooledByteBufAllocator:167 - -Dio.netty.allocator.chunkSize: 16777216
2024-07-25 00:47:19 DEBUG PooledByteBufAllocator:168 - -Dio.netty.allocator.smallCacheSize: 256
2024-07-25 00:47:19 DEBUG PooledByteBufAllocator:169 - -Dio.netty.allocator.normalCacheSize: 64
2024-07-25 00:47:19 DEBUG PooledByteBufAllocator:170 - -Dio.netty.allocator.maxCachedBufferCapacity: 32768
2024-07-25 00:47:19 DEBUG PooledByteBufAllocator:171 - -Dio.netty.allocator.cacheTrimInterval: 8192
2024-07-25 00:47:19 DEBUG PooledByteBufAllocator:172 - -Dio.netty.allocator.cacheTrimIntervalMillis: 0
2024-07-25 00:47:19 DEBUG PooledByteBufAllocator:173 - -Dio.netty.allocator.useCacheForAllThreads: true
2024-07-25 00:47:19 DEBUG PooledByteBufAllocator:174 - -Dio.netty.allocator.maxCachedByteBuffersPerChunk: 1023
2024-07-25 00:47:19 DEBUG DefaultChannelId:79 - -Dio.netty.processId: 1325049 (auto-detected)
2024-07-25 00:47:19 DEBUG DefaultChannelId:101 - -Dio.netty.machineId: 7c:b2:7d:ff:fe:06:bd:dc (auto-detected)
2024-07-25 00:47:19 DEBUG ByteBufUtil:87 - -Dio.netty.allocator.type: pooled
2024-07-25 00:47:19 DEBUG ByteBufUtil:96 - -Dio.netty.threadLocalDirectBufferSize: 0
2024-07-25 00:47:19 DEBUG ByteBufUtil:99 - -Dio.netty.maxThreadLocalCharBufferSize: 16384
2024-07-25 00:47:19 DEBUG Recycler:78 - -Dio.netty.recycler.maxCapacityPerThread: 4096
2024-07-25 00:47:19 DEBUG Recycler:79 - -Dio.netty.recycler.ratio: 8
2024-07-25 00:47:19 DEBUG Recycler:80 - -Dio.netty.recycler.chunkSize: 32
2024-07-25 00:47:19 DEBUG NettyClientHandler:114 - [id: 0xb2a36c7b, L:/127.0.0.1:56536 - R:localhost/127.0.0.1:9090] OUTBOUND SETTINGS: ack=false settings={=0, =0, =1048576, =8192}
2024-07-25 00:47:19 DEBUG NettyClientHandler:114 - [id: 0xb2a36c7b, L:/127.0.0.1:56536 - R:localhost/127.0.0.1:9090] OUTBOUND WINDOW_UPDATE: streamId=0 windowSizeIncrement=983041
2024-07-25 00:47:19 DEBUG NettyClientHandler:114 - [id: 0xb2a36c7b, L:/127.0.0.1:56536 - R:localhost/127.0.0.1:9090] INBOUND SETTINGS: ack=false settings={=2147483647, =1048576, =8192}
2024-07-25 00:47:19 DEBUG NettyClientHandler:109 - [id: 0xb2a36c7b, L:/127.0.0.1:56536 - R:localhost/127.0.0.1:9090] OUTBOUND SETTINGS: ack=true
2024-07-25 00:47:19 DEBUG NettyClientHandler:114 - [id: 0xb2a36c7b, L:/127.0.0.1:56536 - R:localhost/127.0.0.1:9090] INBOUND WINDOW_UPDATE: streamId=0 windowSizeIncrement=983041
2024-07-25 00:47:19 DEBUG NettyClientHandler:114 - [id: 0xb2a36c7b, L:/127.0.0.1:56536 - R:localhost/127.0.0.1:9090] OUTBOUND HEADERS: streamId=3 headers=GrpcHttp2OutboundHeaders[:authority: localhost:9090, :path: /io.pravega.controller.stream.api.grpc.v1.ControllerService/createScope, :method: POST, :scheme: http, content-type: application/grpc, te: trailers, user-agent: grpc-java-netty/1.47.0, requestdescriptor: createScope-examples, requestid: -1181373847607191135, grpc-accept-encoding: gzip, grpc-timeout: 299714m] streamDependency=0 weight=16 exclusive=false padding=0 endStream=false
2024-07-25 00:47:19 DEBUG NettyClientHandler:114 - [id: 0xb2a36c7b, L:/127.0.0.1:56536 - R:localhost/127.0.0.1:9090] OUTBOUND DATA: streamId=3 padding=0 endStream=true length=15 bytes=000000000a0a086578616d706c6573
2024-07-25 00:47:19 DEBUG NettyClientHandler:109 - [id: 0xb2a36c7b, L:/127.0.0.1:56536 - R:localhost/127.0.0.1:9090] INBOUND SETTINGS: ack=true
2024-07-25 00:47:19 DEBUG NettyClientHandler:114 - [id: 0xb2a36c7b, L:/127.0.0.1:56536 - R:localhost/127.0.0.1:9090] INBOUND PING: ack=false bytes=1234
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0xb2a36c7b, L:/127.0.0.1:56536 - R:localhost/127.0.0.1:9090] OUTBOUND PING: ack=true bytes=1234
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0xb2a36c7b, L:/127.0.0.1:56536 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=3 headers=GrpcHttp2ResponseHeaders[:status: 200, content-type: application/grpc, grpc-encoding: identity, grpc-accept-encoding: gzip] padding=0 endStream=false
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0xb2a36c7b, L:/127.0.0.1:56536 - R:localhost/127.0.0.1:9090] INBOUND DATA: streamId=3 padding=0 endStream=false length=5 bytes=0000000000
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0xb2a36c7b, L:/127.0.0.1:56536 - R:localhost/127.0.0.1:9090] OUTBOUND PING: ack=false bytes=1234
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0xb2a36c7b, L:/127.0.0.1:56536 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=3 headers=GrpcHttp2ResponseHeaders[grpc-status: 0] padding=0 endStream=true
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0xb2a36c7b, L:/127.0.0.1:56536 - R:localhost/127.0.0.1:9090] INBOUND PING: ack=true bytes=1234
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0xb2a36c7b, L:/127.0.0.1:56536 - R:localhost/127.0.0.1:9090] OUTBOUND HEADERS: streamId=5 headers=GrpcHttp2OutboundHeaders[:authority: localhost:9090, :path: /io.pravega.controller.stream.api.grpc.v1.ControllerService/createStream, :method: POST, :scheme: http, content-type: application/grpc, te: trailers, user-agent: grpc-java-netty/1.47.0, requestdescriptor: createStream-examples-helloStream, requestid: 8299691219983050873, grpc-accept-encoding: gzip, grpc-timeout: 299999m] streamDependency=0 weight=16 exclusive=false padding=0 endStream=false
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0xb2a36c7b, L:/127.0.0.1:56536 - R:localhost/127.0.0.1:9090] OUTBOUND DATA: streamId=5 padding=0 endStream=true length=36 bytes=000000001f0a170a086578616d706c6573120b68656c6c6f53747265616d120220012200
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0xb2a36c7b, L:/127.0.0.1:56536 - R:localhost/127.0.0.1:9090] INBOUND PING: ack=false bytes=1234
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0xb2a36c7b, L:/127.0.0.1:56536 - R:localhost/127.0.0.1:9090] OUTBOUND PING: ack=true bytes=1234
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0xb2a36c7b, L:/127.0.0.1:56536 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=5 headers=GrpcHttp2ResponseHeaders[:status: 200, content-type: application/grpc, grpc-encoding: identity, grpc-accept-encoding: gzip] padding=0 endStream=false
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0xb2a36c7b, L:/127.0.0.1:56536 - R:localhost/127.0.0.1:9090] INBOUND DATA: streamId=5 padding=0 endStream=false length=5 bytes=0000000000
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0xb2a36c7b, L:/127.0.0.1:56536 - R:localhost/127.0.0.1:9090] OUTBOUND PING: ack=false bytes=1234
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0xb2a36c7b, L:/127.0.0.1:56536 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=5 headers=GrpcHttp2ResponseHeaders[grpc-status: 0] padding=0 endStream=true
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0xb2a36c7b, L:/127.0.0.1:56536 - R:localhost/127.0.0.1:9090] INBOUND PING: ack=true bytes=1234
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0xb2a36c7b, L:/127.0.0.1:56536 - R:localhost/127.0.0.1:9090] OUTBOUND GO_AWAY: lastStreamId=0 errorCode=0 length=0 bytes=
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0x6dfa5cf1, L:/127.0.0.1:56548 - R:localhost/127.0.0.1:9090] OUTBOUND SETTINGS: ack=false settings={=0, =0, =1048576, =8192}
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0x6dfa5cf1, L:/127.0.0.1:56548 - R:localhost/127.0.0.1:9090] OUTBOUND WINDOW_UPDATE: streamId=0 windowSizeIncrement=983041
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0x6dfa5cf1, L:/127.0.0.1:56548 - R:localhost/127.0.0.1:9090] INBOUND SETTINGS: ack=false settings={=2147483647, =1048576, =8192}
2024-07-25 00:47:20 DEBUG NettyClientHandler:109 - [id: 0x6dfa5cf1, L:/127.0.0.1:56548 - R:localhost/127.0.0.1:9090] OUTBOUND SETTINGS: ack=true
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0x6dfa5cf1, L:/127.0.0.1:56548 - R:localhost/127.0.0.1:9090] INBOUND WINDOW_UPDATE: streamId=0 windowSizeIncrement=983041
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0x6dfa5cf1, L:/127.0.0.1:56548 - R:localhost/127.0.0.1:9090] OUTBOUND HEADERS: streamId=3 headers=GrpcHttp2OutboundHeaders[:authority: localhost:9090, :path: /io.pravega.controller.stream.api.grpc.v1.ControllerService/getCurrentSegments, :method: POST, :scheme: http, content-type: application/grpc, te: trailers, user-agent: grpc-java-netty/1.47.0, requestdescriptor: getCurrentSegments-examples-helloStream, requestid: 6933354549863154251, grpc-accept-encoding: gzip, grpc-timeout: 299988m] streamDependency=0 weight=16 exclusive=false padding=0 endStream=false
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0x6dfa5cf1, L:/127.0.0.1:56548 - R:localhost/127.0.0.1:9090] OUTBOUND DATA: streamId=3 padding=0 endStream=true length=30 bytes=00000000190a086578616d706c6573120b68656c6c6f53747265616d1801
2024-07-25 00:47:20 DEBUG NettyClientHandler:109 - [id: 0x6dfa5cf1, L:/127.0.0.1:56548 - R:localhost/127.0.0.1:9090] INBOUND SETTINGS: ack=true
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0x6dfa5cf1, L:/127.0.0.1:56548 - R:localhost/127.0.0.1:9090] INBOUND PING: ack=false bytes=1234
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0x6dfa5cf1, L:/127.0.0.1:56548 - R:localhost/127.0.0.1:9090] OUTBOUND PING: ack=true bytes=1234
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0x6dfa5cf1, L:/127.0.0.1:56548 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=3 headers=GrpcHttp2ResponseHeaders[:status: 200, content-type: application/grpc, grpc-encoding: identity, grpc-accept-encoding: gzip] padding=0 endStream=false
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0x6dfa5cf1, L:/127.0.0.1:56548 - R:localhost/127.0.0.1:9090] INBOUND DATA: streamId=3 padding=0 endStream=false length=43 bytes=00000000260a240a190a170a086578616d706c6573120b68656c6c6f53747265616d19000000000000f03f
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0x6dfa5cf1, L:/127.0.0.1:56548 - R:localhost/127.0.0.1:9090] OUTBOUND PING: ack=false bytes=1234
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0x6dfa5cf1, L:/127.0.0.1:56548 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=3 headers=GrpcHttp2ResponseHeaders[grpc-status: 0] padding=0 endStream=true
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0x6dfa5cf1, L:/127.0.0.1:56548 - R:localhost/127.0.0.1:9090] INBOUND PING: ack=true bytes=1234
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0x6dfa5cf1, L:/127.0.0.1:56548 - R:localhost/127.0.0.1:9090] OUTBOUND HEADERS: streamId=5 headers=GrpcHttp2OutboundHeaders[:authority: localhost:9090, :path: /io.pravega.controller.stream.api.grpc.v1.ControllerService/getURI, :method: POST, :scheme: http, content-type: application/grpc, te: trailers, user-agent: grpc-java-netty/1.47.0, requestdescriptor: getURI-examples/helloStream/0.#epoch.0, requestid: -6585642168380817075, grpc-accept-encoding: gzip, grpc-timeout: 299998m] streamDependency=0 weight=16 exclusive=false padding=0 endStream=false
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0x6dfa5cf1, L:/127.0.0.1:56548 - R:localhost/127.0.0.1:9090] OUTBOUND HEADERS: streamId=7 headers=GrpcHttp2OutboundHeaders[:authority: localhost:9090, :path: /io.pravega.controller.stream.api.grpc.v1.ControllerService/getDelegationToken, :method: POST, :scheme: http, content-type: application/grpc, te: trailers, user-agent: grpc-java-netty/1.47.0, requestdescriptor: getOrRefreshDelegationTokenFor-examples-helloStream, requestid: -3169967235721222382, grpc-accept-encoding: gzip, grpc-timeout: 299998m] streamDependency=0 weight=16 exclusive=false padding=0 endStream=false
2024-07-25 00:47:20 DEBUG PoolThreadCache:224 - Freed 1 thread-local buffer(s) from thread: Finalizer
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0x6dfa5cf1, L:/127.0.0.1:56548 - R:localhost/127.0.0.1:9090] OUTBOUND DATA: streamId=5 padding=0 endStream=true length=30 bytes=00000000190a170a086578616d706c6573120b68656c6c6f53747265616d
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0x6dfa5cf1, L:/127.0.0.1:56548 - R:localhost/127.0.0.1:9090] OUTBOUND DATA: streamId=7 padding=0 endStream=true length=30 bytes=00000000190a086578616d706c6573120b68656c6c6f53747265616d1804
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0x6dfa5cf1, L:/127.0.0.1:56548 - R:localhost/127.0.0.1:9090] INBOUND PING: ack=false bytes=1234
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0x6dfa5cf1, L:/127.0.0.1:56548 - R:localhost/127.0.0.1:9090] OUTBOUND PING: ack=true bytes=1234
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0x6dfa5cf1, L:/127.0.0.1:56548 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=5 headers=GrpcHttp2ResponseHeaders[:status: 200, content-type: application/grpc, grpc-encoding: identity, grpc-accept-encoding: gzip] padding=0 endStream=false
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0x6dfa5cf1, L:/127.0.0.1:56548 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=7 headers=GrpcHttp2ResponseHeaders[:status: 200, content-type: application/grpc, grpc-encoding: identity, grpc-accept-encoding: gzip] padding=0 endStream=false
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0x6dfa5cf1, L:/127.0.0.1:56548 - R:localhost/127.0.0.1:9090] INBOUND DATA: streamId=5 padding=0 endStream=false length=17 bytes=000000000c0a07302e302e302e3010f02e
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0x6dfa5cf1, L:/127.0.0.1:56548 - R:localhost/127.0.0.1:9090] OUTBOUND PING: ack=false bytes=1234
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0x6dfa5cf1, L:/127.0.0.1:56548 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=5 headers=GrpcHttp2ResponseHeaders[grpc-status: 0] padding=0 endStream=true
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0x6dfa5cf1, L:/127.0.0.1:56548 - R:localhost/127.0.0.1:9090] INBOUND DATA: streamId=7 padding=0 endStream=false length=5 bytes=0000000000
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0x6dfa5cf1, L:/127.0.0.1:56548 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=7 headers=GrpcHttp2ResponseHeaders[grpc-status: 0] padding=0 endStream=true
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0x6dfa5cf1, L:/127.0.0.1:56548 - R:localhost/127.0.0.1:9090] INBOUND PING: ack=true bytes=1234
2024-07-25 00:47:20 DEBUG InternalLoggerFactory:76 - Using Log4J2 as the default logging framework
2024-07-25 00:47:20 DEBUG ResourceLeakDetector:129 - -Dio.netty.leakDetection.level: simple
2024-07-25 00:47:20 DEBUG ResourceLeakDetector:130 - -Dio.netty.leakDetection.targetRecords: 4
2024-07-25 00:47:20 DEBUG PlatformDependent0:496 - -Dio.netty.noUnsafe: false
2024-07-25 00:47:20 DEBUG PlatformDependent0:1000 - Java version: 21
2024-07-25 00:47:20 DEBUG PlatformDependent0:137 - sun.misc.Unsafe.theUnsafe: available
2024-07-25 00:47:20 DEBUG PlatformDependent0:161 - sun.misc.Unsafe.copyMemory: available
2024-07-25 00:47:20 DEBUG PlatformDependent0:193 - sun.misc.Unsafe.storeFence: available
2024-07-25 00:47:20 DEBUG PlatformDependent0:236 - java.nio.Buffer.address: available
2024-07-25 00:47:20 DEBUG PlatformDependent0:320 - direct buffer constructor: unavailable: java.nio.DirectByteBuffer.<init>(long,int)
2024-07-25 00:47:20 DEBUG PlatformDependent0:385 - java.nio.Bits.unaligned: available, true
2024-07-25 00:47:20 DEBUG PlatformDependent0:452 - jdk.internal.misc.Unsafe.allocateUninitializedArray(int): unavailable: class io.netty.util.internal.PlatformDependent0$7 cannot access class jdk.internal.misc.Unsafe (in module java.base) because module java.base does not export jdk.internal.misc to unnamed module @65d6b83b
2024-07-25 00:47:20 DEBUG PlatformDependent0:482 - java.nio.DirectByteBuffer.<init>(long, int): unavailable
2024-07-25 00:47:20 DEBUG PlatformDependent:1159 - sun.misc.Unsafe: available
2024-07-25 00:47:20 DEBUG PlatformDependent:1270 - maxDirectMemory: 16819159040 bytes (maybe)
2024-07-25 00:47:20 DEBUG PlatformDependent:1289 - -Dio.netty.tmpdir: /tmp (java.io.tmpdir)
2024-07-25 00:47:20 DEBUG PlatformDependent:1368 - -Dio.netty.bitMode: 64 (sun.arch.data.model)
2024-07-25 00:47:20 DEBUG PlatformDependent:178 - -Dio.netty.maxDirectMemory: -1 bytes
2024-07-25 00:47:20 DEBUG PlatformDependent:185 - -Dio.netty.uninitializedArrayAllocationThreshold: -1
2024-07-25 00:47:20 DEBUG CleanerJava9:71 - java.nio.ByteBuffer.cleaner(): available
2024-07-25 00:47:20 DEBUG PlatformDependent:205 - -Dio.netty.noPreferDirect: false
2024-07-25 00:47:20 DEBUG AbstractByteBuf:63 - -Dio.netty.buffer.checkAccessible: true
2024-07-25 00:47:20 DEBUG AbstractByteBuf:64 - -Dio.netty.buffer.checkBounds: true
2024-07-25 00:47:20 DEBUG ResourceLeakDetectorFactory:196 - Loaded default ResourceLeakDetector: io.netty.util.ResourceLeakDetector@3a94964
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0x6dfa5cf1, L:/127.0.0.1:56548 - R:localhost/127.0.0.1:9090] OUTBOUND GO_AWAY: lastStreamId=0 errorCode=0 length=0 bytes=
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] OUTBOUND SETTINGS: ack=false settings={=0, =0, =1048576, =8192}
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] OUTBOUND WINDOW_UPDATE: streamId=0 windowSizeIncrement=983041
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND SETTINGS: ack=false settings={=2147483647, =1048576, =8192}
2024-07-25 00:47:20 DEBUG NettyClientHandler:109 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] OUTBOUND SETTINGS: ack=true
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND WINDOW_UPDATE: streamId=0 windowSizeIncrement=983041
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] OUTBOUND HEADERS: streamId=3 headers=GrpcHttp2OutboundHeaders[:authority: localhost:9090, :path: /io.pravega.controller.stream.api.grpc.v1.ControllerService/createReaderGroup, :method: POST, :scheme: http, content-type: application/grpc, te: trailers, user-agent: grpc-java-netty/1.47.0, requestdescriptor: createReaderGroup-examples-readerGroup, requestid: 2382834875858696589, grpc-accept-encoding: gzip, grpc-timeout: 299991m] streamDependency=0 weight=16 exclusive=false padding=0 endStream=false
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] OUTBOUND DATA: streamId=3 padding=0 endStream=true length=136 bytes=00000000830a086578616d706c6573120b72656164657247726f757018b81720ffffffffffffffffff012803422465393461623431382d333836392d34663763...
2024-07-25 00:47:20 DEBUG NettyClientHandler:109 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND SETTINGS: ack=true
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND PING: ack=false bytes=1234
2024-07-25 00:47:20 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] OUTBOUND PING: ack=true bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=3 headers=GrpcHttp2ResponseHeaders[:status: 200, content-type: application/grpc, grpc-encoding: identity, grpc-accept-encoding: gzip] padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND DATA: streamId=3 padding=0 endStream=false length=139 bytes=00000000861283010a086578616d706c6573120b72656164657247726f757018b81720ffffffffffffffffff012803422465393461623431382d333836392d34...
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] OUTBOUND PING: ack=false bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=3 headers=GrpcHttp2ResponseHeaders[grpc-status: 0] padding=0 endStream=true
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND PING: ack=true bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] OUTBOUND HEADERS: streamId=5 headers=GrpcHttp2OutboundHeaders[:authority: localhost:9090, :path: /io.pravega.controller.stream.api.grpc.v1.ControllerService/getCurrentSegments, :method: POST, :scheme: http, content-type: application/grpc, te: trailers, user-agent: grpc-java-netty/1.47.0, requestdescriptor: getCurrentSegments-examples-_RGreaderGroup, requestid: 4857345218507620078, grpc-accept-encoding: gzip, grpc-timeout: 299999m] streamDependency=0 weight=16 exclusive=false padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] OUTBOUND DATA: streamId=5 padding=0 endStream=true length=33 bytes=000000001c0a086578616d706c6573120e5f524772656164657247726f75701801
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND PING: ack=false bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] OUTBOUND PING: ack=true bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=5 headers=GrpcHttp2ResponseHeaders[:status: 200, content-type: application/grpc, grpc-encoding: identity, grpc-accept-encoding: gzip] padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND DATA: streamId=5 padding=0 endStream=false length=46 bytes=00000000290a270a1c0a1a0a086578616d706c6573120e5f524772656164657247726f757019000000000000f03f
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] OUTBOUND PING: ack=false bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=5 headers=GrpcHttp2ResponseHeaders[grpc-status: 0] padding=0 endStream=true
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND PING: ack=true bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] OUTBOUND HEADERS: streamId=7 headers=GrpcHttp2OutboundHeaders[:authority: localhost:9090, :path: /io.pravega.controller.stream.api.grpc.v1.ControllerService/getDelegationToken, :method: POST, :scheme: http, content-type: application/grpc, te: trailers, user-agent: grpc-java-netty/1.47.0, requestdescriptor: getOrRefreshDelegationTokenFor-examples-_RGreaderGroup, requestid: -215368675775184266, grpc-accept-encoding: gzip, grpc-timeout: 299999m] streamDependency=0 weight=16 exclusive=false padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] OUTBOUND HEADERS: streamId=9 headers=GrpcHttp2OutboundHeaders[:authority: localhost:9090, :path: /io.pravega.controller.stream.api.grpc.v1.ControllerService/getURI, :method: POST, :scheme: http, content-type: application/grpc, te: trailers, user-agent: grpc-java-netty/1.47.0, requestdescriptor: getURI-examples/_RGreaderGroup/0.#epoch.0, requestid: -8377177999280041284, grpc-accept-encoding: gzip, grpc-timeout: 299999m] streamDependency=0 weight=16 exclusive=false padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] OUTBOUND DATA: streamId=7 padding=0 endStream=true length=33 bytes=000000001c0a086578616d706c6573120e5f524772656164657247726f75701803
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] OUTBOUND DATA: streamId=9 padding=0 endStream=true length=33 bytes=000000001c0a1a0a086578616d706c6573120e5f524772656164657247726f7570
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND PING: ack=false bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] OUTBOUND PING: ack=true bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=7 headers=GrpcHttp2ResponseHeaders[:status: 200, content-type: application/grpc, grpc-encoding: identity, grpc-accept-encoding: gzip] padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=9 headers=GrpcHttp2ResponseHeaders[:status: 200, content-type: application/grpc, grpc-encoding: identity, grpc-accept-encoding: gzip] padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND DATA: streamId=7 padding=0 endStream=false length=5 bytes=0000000000
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] OUTBOUND PING: ack=false bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=7 headers=GrpcHttp2ResponseHeaders[grpc-status: 0] padding=0 endStream=true
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND DATA: streamId=9 padding=0 endStream=false length=17 bytes=000000000c0a07302e302e302e3010f02e
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=9 headers=GrpcHttp2ResponseHeaders[grpc-status: 0] padding=0 endStream=true
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND PING: ack=true bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] OUTBOUND HEADERS: streamId=11 headers=GrpcHttp2OutboundHeaders[:authority: localhost:9090, :path: /io.pravega.controller.stream.api.grpc.v1.ControllerService/getDelegationToken, :method: POST, :scheme: http, content-type: application/grpc, te: trailers, user-agent: grpc-java-netty/1.47.0, requestdescriptor: getOrRefreshDelegationTokenFor-examples-_RGreaderGroup, requestid: -6917910467676239776, grpc-accept-encoding: gzip, grpc-timeout: 299999m] streamDependency=0 weight=16 exclusive=false padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] OUTBOUND DATA: streamId=11 padding=0 endStream=true length=33 bytes=000000001c0a086578616d706c6573120e5f524772656164657247726f75701805
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND PING: ack=false bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] OUTBOUND PING: ack=true bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=11 headers=GrpcHttp2ResponseHeaders[:status: 200, content-type: application/grpc, grpc-encoding: identity, grpc-accept-encoding: gzip] padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND DATA: streamId=11 padding=0 endStream=false length=5 bytes=0000000000
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] OUTBOUND PING: ack=false bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=11 headers=GrpcHttp2ResponseHeaders[grpc-status: 0] padding=0 endStream=true
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] OUTBOUND HEADERS: streamId=13 headers=GrpcHttp2OutboundHeaders[:authority: localhost:9090, :path: /io.pravega.controller.stream.api.grpc.v1.ControllerService/getSegments, :method: POST, :scheme: http, content-type: application/grpc, te: trailers, user-agent: grpc-java-netty/1.47.0, grpc-accept-encoding: gzip, grpc-timeout: 299999m] streamDependency=0 weight=16 exclusive=false padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] OUTBOUND HEADERS: streamId=15 headers=GrpcHttp2OutboundHeaders[:authority: localhost:9090, :path: /io.pravega.controller.stream.api.grpc.v1.ControllerService/getSegments, :method: POST, :scheme: http, content-type: application/grpc, te: trailers, user-agent: grpc-java-netty/1.47.0, requestdescriptor: getSegmentsAtTime-examples-helloStream, requestid: -2266498335422257281, grpc-accept-encoding: gzip, grpc-timeout: 299999m] streamDependency=0 weight=16 exclusive=false padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] OUTBOUND DATA: streamId=13 padding=0 endStream=true length=32 bytes=000000001b0a190a086578616d706c6573120b68656c6c6f53747265616d1801
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] OUTBOUND DATA: streamId=15 padding=0 endStream=true length=32 bytes=000000001b0a190a086578616d706c6573120b68656c6c6f53747265616d1801
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND PING: ack=true bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND PING: ack=false bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] OUTBOUND PING: ack=true bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=13 headers=GrpcHttp2ResponseHeaders[:status: 200, content-type: application/grpc, grpc-encoding: identity, grpc-accept-encoding: gzip] padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=15 headers=GrpcHttp2ResponseHeaders[:status: 200, content-type: application/grpc, grpc-encoding: identity, grpc-accept-encoding: gzip] padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND DATA: streamId=13 padding=0 endStream=false length=34 bytes=000000001d0a1b0a190a170a086578616d706c6573120b68656c6c6f53747265616d
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] OUTBOUND PING: ack=false bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=13 headers=GrpcHttp2ResponseHeaders[grpc-status: 0] padding=0 endStream=true
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND DATA: streamId=15 padding=0 endStream=false length=34 bytes=000000001d0a1b0a190a170a086578616d706c6573120b68656c6c6f53747265616d
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=15 headers=GrpcHttp2ResponseHeaders[grpc-status: 0] padding=0 endStream=true
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] INBOUND PING: ack=true bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa9373a8b, L:/127.0.0.1:56562 - R:localhost/127.0.0.1:9090] OUTBOUND GO_AWAY: lastStreamId=0 errorCode=0 length=0 bytes=
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND SETTINGS: ack=false settings={=0, =0, =1048576, =8192}
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND WINDOW_UPDATE: streamId=0 windowSizeIncrement=983041
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND SETTINGS: ack=false settings={=2147483647, =1048576, =8192}
2024-07-25 00:47:21 DEBUG NettyClientHandler:109 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND SETTINGS: ack=true
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND WINDOW_UPDATE: streamId=0 windowSizeIncrement=983041
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND HEADERS: streamId=3 headers=GrpcHttp2OutboundHeaders[:authority: localhost:9090, :path: /io.pravega.controller.stream.api.grpc.v1.ControllerService/getCurrentSegments, :method: POST, :scheme: http, content-type: application/grpc, te: trailers, user-agent: grpc-java-netty/1.47.0, requestdescriptor: getCurrentSegments-examples-_RGreaderGroup, requestid: 7227318662644209726, grpc-accept-encoding: gzip, grpc-timeout: 299992m] streamDependency=0 weight=16 exclusive=false padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND DATA: streamId=3 padding=0 endStream=true length=33 bytes=000000001c0a086578616d706c6573120e5f524772656164657247726f75701801
2024-07-25 00:47:21 DEBUG NettyClientHandler:109 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND SETTINGS: ack=true
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND PING: ack=false bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND PING: ack=true bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=3 headers=GrpcHttp2ResponseHeaders[:status: 200, content-type: application/grpc, grpc-encoding: identity, grpc-accept-encoding: gzip] padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND DATA: streamId=3 padding=0 endStream=false length=46 bytes=00000000290a270a1c0a1a0a086578616d706c6573120e5f524772656164657247726f757019000000000000f03f
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND PING: ack=false bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=3 headers=GrpcHttp2ResponseHeaders[grpc-status: 0] padding=0 endStream=true
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND PING: ack=true bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND HEADERS: streamId=5 headers=GrpcHttp2OutboundHeaders[:authority: localhost:9090, :path: /io.pravega.controller.stream.api.grpc.v1.ControllerService/getDelegationToken, :method: POST, :scheme: http, content-type: application/grpc, te: trailers, user-agent: grpc-java-netty/1.47.0, requestdescriptor: getOrRefreshDelegationTokenFor-examples-_RGreaderGroup, requestid: -7373408813714028820, grpc-accept-encoding: gzip, grpc-timeout: 299999m] streamDependency=0 weight=16 exclusive=false padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND HEADERS: streamId=7 headers=GrpcHttp2OutboundHeaders[:authority: localhost:9090, :path: /io.pravega.controller.stream.api.grpc.v1.ControllerService/getURI, :method: POST, :scheme: http, content-type: application/grpc, te: trailers, user-agent: grpc-java-netty/1.47.0, requestdescriptor: getURI-examples/_RGreaderGroup/0.#epoch.0, requestid: 6260947108508829158, grpc-accept-encoding: gzip, grpc-timeout: 299999m] streamDependency=0 weight=16 exclusive=false padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND HEADERS: streamId=9 headers=GrpcHttp2OutboundHeaders[:authority: localhost:9090, :path: /io.pravega.controller.stream.api.grpc.v1.ControllerService/getDelegationToken, :method: POST, :scheme: http, content-type: application/grpc, te: trailers, user-agent: grpc-java-netty/1.47.0, requestdescriptor: getOrRefreshDelegationTokenFor-examples-_RGreaderGroup, requestid: 6311828942642207269, grpc-accept-encoding: gzip, grpc-timeout: 299999m] streamDependency=0 weight=16 exclusive=false padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND DATA: streamId=7 padding=0 endStream=true length=33 bytes=000000001c0a1a0a086578616d706c6573120e5f524772656164657247726f7570
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND DATA: streamId=9 padding=0 endStream=true length=33 bytes=000000001c0a086578616d706c6573120e5f524772656164657247726f75701805
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND DATA: streamId=5 padding=0 endStream=true length=33 bytes=000000001c0a086578616d706c6573120e5f524772656164657247726f75701803
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND PING: ack=false bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND PING: ack=true bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=5 headers=GrpcHttp2ResponseHeaders[:status: 200, content-type: application/grpc, grpc-encoding: identity, grpc-accept-encoding: gzip] padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=7 headers=GrpcHttp2ResponseHeaders[:status: 200, content-type: application/grpc, grpc-encoding: identity, grpc-accept-encoding: gzip] padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND DATA: streamId=5 padding=0 endStream=false length=5 bytes=0000000000
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND PING: ack=false bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=5 headers=GrpcHttp2ResponseHeaders[grpc-status: 0] padding=0 endStream=true
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND DATA: streamId=7 padding=0 endStream=false length=17 bytes=000000000c0a07302e302e302e3010f02e
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=7 headers=GrpcHttp2ResponseHeaders[grpc-status: 0] padding=0 endStream=true
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=9 headers=GrpcHttp2ResponseHeaders[:status: 200, content-type: application/grpc, grpc-encoding: identity, grpc-accept-encoding: gzip] padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND DATA: streamId=9 padding=0 endStream=false length=5 bytes=0000000000
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=9 headers=GrpcHttp2ResponseHeaders[grpc-status: 0] padding=0 endStream=true
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND PING: ack=true bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND HEADERS: streamId=11 headers=GrpcHttp2OutboundHeaders[:authority: localhost:9090, :path: /io.pravega.controller.stream.api.grpc.v1.ControllerService/getCurrentSegments, :method: POST, :scheme: http, content-type: application/grpc, te: trailers, user-agent: grpc-java-netty/1.47.0, requestdescriptor: getCurrentSegments-examples-_MARKhelloStream, requestid: -2150388497784575972, grpc-accept-encoding: gzip, grpc-timeout: 299999m] streamDependency=0 weight=16 exclusive=false padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND DATA: streamId=11 padding=0 endStream=true length=35 bytes=000000001e0a086578616d706c657312105f4d41524b68656c6c6f53747265616d1801
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND PING: ack=false bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND PING: ack=true bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=11 headers=GrpcHttp2ResponseHeaders[:status: 200, content-type: application/grpc, grpc-encoding: identity, grpc-accept-encoding: gzip] padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND DATA: streamId=11 padding=0 endStream=false length=48 bytes=000000002b0a290a1e0a1c0a086578616d706c657312105f4d41524b68656c6c6f53747265616d19000000000000f03f
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND PING: ack=false bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=11 headers=GrpcHttp2ResponseHeaders[grpc-status: 0] padding=0 endStream=true
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND PING: ack=true bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND HEADERS: streamId=13 headers=GrpcHttp2OutboundHeaders[:authority: localhost:9090, :path: /io.pravega.controller.stream.api.grpc.v1.ControllerService/getDelegationToken, :method: POST, :scheme: http, content-type: application/grpc, te: trailers, user-agent: grpc-java-netty/1.47.0, requestdescriptor: getOrRefreshDelegationTokenFor-examples-_MARKhelloStream, requestid: -5415075765830968788, grpc-accept-encoding: gzip, grpc-timeout: 299999m] streamDependency=0 weight=16 exclusive=false padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND HEADERS: streamId=15 headers=GrpcHttp2OutboundHeaders[:authority: localhost:9090, :path: /io.pravega.controller.stream.api.grpc.v1.ControllerService/getURI, :method: POST, :scheme: http, content-type: application/grpc, te: trailers, user-agent: grpc-java-netty/1.47.0, requestdescriptor: getURI-examples/_MARKhelloStream/0.#epoch.0, requestid: 4416052126850894613, grpc-accept-encoding: gzip, grpc-timeout: 299999m] streamDependency=0 weight=16 exclusive=false padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND HEADERS: streamId=17 headers=GrpcHttp2OutboundHeaders[:authority: localhost:9090, :path: /io.pravega.controller.stream.api.grpc.v1.ControllerService/getDelegationToken, :method: POST, :scheme: http, content-type: application/grpc, te: trailers, user-agent: grpc-java-netty/1.47.0, requestdescriptor: getOrRefreshDelegationTokenFor-examples-_MARKhelloStream, requestid: 7719518565829287631, grpc-accept-encoding: gzip, grpc-timeout: 299999m] streamDependency=0 weight=16 exclusive=false padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND DATA: streamId=15 padding=0 endStream=true length=35 bytes=000000001e0a1c0a086578616d706c657312105f4d41524b68656c6c6f53747265616d
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND DATA: streamId=17 padding=0 endStream=true length=35 bytes=000000001e0a086578616d706c657312105f4d41524b68656c6c6f53747265616d1805
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND DATA: streamId=13 padding=0 endStream=true length=35 bytes=000000001e0a086578616d706c657312105f4d41524b68656c6c6f53747265616d1803
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND PING: ack=false bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND PING: ack=true bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=13 headers=GrpcHttp2ResponseHeaders[:status: 200, content-type: application/grpc, grpc-encoding: identity, grpc-accept-encoding: gzip] padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=15 headers=GrpcHttp2ResponseHeaders[:status: 200, content-type: application/grpc, grpc-encoding: identity, grpc-accept-encoding: gzip] padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=17 headers=GrpcHttp2ResponseHeaders[:status: 200, content-type: application/grpc, grpc-encoding: identity, grpc-accept-encoding: gzip] padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND DATA: streamId=13 padding=0 endStream=false length=5 bytes=0000000000
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND PING: ack=false bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=13 headers=GrpcHttp2ResponseHeaders[grpc-status: 0] padding=0 endStream=true
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND DATA: streamId=17 padding=0 endStream=false length=5 bytes=0000000000
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=17 headers=GrpcHttp2ResponseHeaders[grpc-status: 0] padding=0 endStream=true
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND DATA: streamId=15 padding=0 endStream=false length=17 bytes=000000000c0a07302e302e302e3010f02e
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=15 headers=GrpcHttp2ResponseHeaders[grpc-status: 0] padding=0 endStream=true
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND PING: ack=true bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND HEADERS: streamId=19 headers=GrpcHttp2OutboundHeaders[:authority: localhost:9090, :path: /io.pravega.controller.stream.api.grpc.v1.ControllerService/getDelegationToken, :method: POST, :scheme: http, content-type: application/grpc, te: trailers, user-agent: grpc-java-netty/1.47.0, requestdescriptor: getOrRefreshDelegationTokenFor-examples-helloStream, requestid: -6100317659286864264, grpc-accept-encoding: gzip, grpc-timeout: 299999m] streamDependency=0 weight=16 exclusive=false padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND HEADERS: streamId=21 headers=GrpcHttp2OutboundHeaders[:authority: localhost:9090, :path: /io.pravega.controller.stream.api.grpc.v1.ControllerService/getURI, :method: POST, :scheme: http, content-type: application/grpc, te: trailers, user-agent: grpc-java-netty/1.47.0, requestdescriptor: getURI-examples/helloStream/0.#epoch.0, requestid: 1757022392136278072, grpc-accept-encoding: gzip, grpc-timeout: 299999m] streamDependency=0 weight=16 exclusive=false padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND DATA: streamId=19 padding=0 endStream=true length=30 bytes=00000000190a086578616d706c6573120b68656c6c6f53747265616d1803
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND DATA: streamId=21 padding=0 endStream=true length=30 bytes=00000000190a170a086578616d706c6573120b68656c6c6f53747265616d
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND PING: ack=false bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND PING: ack=true bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=19 headers=GrpcHttp2ResponseHeaders[:status: 200, content-type: application/grpc, grpc-encoding: identity, grpc-accept-encoding: gzip] padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=21 headers=GrpcHttp2ResponseHeaders[:status: 200, content-type: application/grpc, grpc-encoding: identity, grpc-accept-encoding: gzip] padding=0 endStream=false
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND DATA: streamId=19 padding=0 endStream=false length=5 bytes=0000000000
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND PING: ack=false bytes=1234
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=19 headers=GrpcHttp2ResponseHeaders[grpc-status: 0] padding=0 endStream=true
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND DATA: streamId=21 padding=0 endStream=false length=17 bytes=000000000c0a07302e302e302e3010f02e
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND HEADERS: streamId=21 headers=GrpcHttp2ResponseHeaders[grpc-status: 0] padding=0 endStream=true
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] INBOUND PING: ack=true bytes=1234
hello world!
2024-07-25 00:47:21 DEBUG NettyClientHandler:114 - [id: 0xa0e12c96, L:/127.0.0.1:56578 - R:localhost/127.0.0.1:9090] OUTBOUND GO_AWAY: lastStreamId=0 errorCode=0 length=0 bytes=

Process finished with exit code 0
```