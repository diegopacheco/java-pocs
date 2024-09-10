### Build
```bash
./mvnw clean install
```

### Stress Async

```
ab -n 60000 -c 1000 http://localhost:8080/async-task
```
* Default configs on netty - no customization.
* Default JVM configs - optimizations.
```
Server Software:        
Server Hostname:        localhost
Server Port:            8080

Document Path:          /async-task
Document Length:        124 bytes

Concurrency Level:      1000
Time taken for tests:   10.309 seconds
Complete requests:      60000
Failed requests:        59991
   (Connect: 0, Receive: 0, Length: 59991, Exceptions: 0)
Non-2xx responses:      60000
Total transferred:      12408894 bytes
HTML transferred:       7668894 bytes
Requests per second:    5819.94 [#/sec] (mean)
Time per request:       171.823 [ms] (mean)
Time per request:       0.172 [ms] (mean, across all concurrent requests)
Transfer rate:          1175.44 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0   28  20.8     28      77
Processing:    20  140  81.3    120     679
Waiting:       13  131  86.0    111     679
Total:         65  168  69.4    147     680

Percentage of the requests served within a certain time (ms)
  50%    147
  66%    161
  75%    174
  80%    186
  90%    239
  95%    332
  98%    412
  99%    461
```

### Stress Block

```
ab -n 60000 -c 1000 http://localhost:8080/block-date
```
* Default configs on netty - no customization.
* Default JVM configs - optimizations. 
```
Server Software:        
Server Hostname:        localhost
Server Port:            8080

Document Path:          /block-date
Document Length:        28 bytes

Concurrency Level:      1000
Time taken for tests:   5005.122 seconds
Complete requests:      60000
Failed requests:        0
Total transferred:      6420000 bytes
HTML transferred:       1680000 bytes
Requests per second:    11.99 [#/sec] (mean)
Time per request:       83418.696 [ms] (mean)
Time per request:       83.419 [ms] (mean, across all concurrent requests)
Transfer rate:          1.25 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    1   4.7      0      52
Processing:  1004 82706 6134.9  83236   84149
Waiting:     1004 82705 6134.9  83236   84149
Total:       1056 82707 6130.3  83236   84156

Percentage of the requests served within a certain time (ms)
  50%  83236
  66%  83535
  75%  83666
  80%  83798
  90%  83886
  95%  84024
  98%  84059
  99%  84063
 100%  84156 (longest request)
```

### Stress Mono

```
ab -n 60000 -c 1000 http://localhost:8080/mono-date
```
* Default configs on netty - no customization.
* Default JVM configs - optimizations.
```
Server Software:        
Server Hostname:        localhost
Server Port:            8080

Document Path:          /mono-date
Document Length:        28 bytes

Concurrency Level:      1000
Time taken for tests:   505.175 seconds
Complete requests:      60000
Failed requests:        0
Total transferred:      6420000 bytes
HTML transferred:       1680000 bytes
Requests per second:    118.77 [#/sec] (mean)
Time per request:       8419.589 [ms] (mean)
Time per request:       8.420 [ms] (mean, across all concurrent requests)
Transfer rate:          12.41 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    3   4.0      3      35
Processing:  1001 8271 821.3   8001   17004
Waiting:     1001 8270 821.2   7999   17002
Total:       1036 8275 818.9   8004   17007

Percentage of the requests served within a certain time (ms)
  50%   8004
  66%   8007
  75%   8998
  80%   8999
  90%   9002
  95%   9004
  98%   9009
  99%  10005
 100%  17007 (longest request)
```