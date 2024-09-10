### Build
```bash
./mvnw clean install
```

### Stress Async

```
ab -n 60000 -c 1000 http://localhost:8080/async-task
```
* Default configs on tomcat - no customization.
* Default JVM configs - optimizations.
```
Server Software:        
Server Hostname:        localhost
Server Port:            8080

Document Path:          /async-task
Document Length:        99 bytes

Concurrency Level:      1000
Time taken for tests:   9.200 seconds
Complete requests:      60000
Failed requests:        0
Non-2xx responses:      60000
Total transferred:      17580000 bytes
HTML transferred:       5940000 bytes
Requests per second:    6521.49 [#/sec] (mean)
Time per request:       153.339 [ms] (mean)
Time per request:       0.153 [ms] (mean, across all concurrent requests)
Transfer rate:          1866.01 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0   64 150.6     46    1128
Processing:     9   86  46.5     76     928
Waiting:        9   70  47.5     61     925
Total:         18  150 167.9    122    2035

Percentage of the requests served within a certain time (ms)
  50%    122
  66%    131
  75%    140
  80%    145
  90%    167
  95%    201
  98%   1095
  99%   1199
 100%   2035 (longest request)
```

### Stress Block

```
ab -n 60000 -c 1000 http://localhost:8080/block-date
```
* Default configs on tomcat - no customization.
* Default JVM configs - optimizations.
```
Benchmarking localhost (be patient)
Completed 6000 requests
Completed 12000 requests
Completed 18000 requests
Completed 24000 requests
Completed 30000 requests
Completed 36000 requests
Completed 42000 requests
Completed 48000 requests
Completed 54000 requests
Completed 60000 requests
Finished 60000 requests


Server Software:        
Server Hostname:        localhost
Server Port:            8080

Document Path:          /block-date
Document Length:        28 bytes

Concurrency Level:      1000
Time taken for tests:   301.332 seconds
Complete requests:      60000
Failed requests:        0
Total transferred:      9660000 bytes
HTML transferred:       1680000 bytes
Requests per second:    199.12 [#/sec] (mean)
Time per request:       5022.207 [ms] (mean)
Time per request:       5.022 [ms] (mean, across all concurrent requests)
Transfer rate:          31.31 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    9  83.0      1    1066
Processing:  1004 4961 331.1   5001    5095
Waiting:     1003 4960 331.0   5000    5095
Total:       1040 4970 318.3   5002    6104

Percentage of the requests served within a certain time (ms)
  50%   5002
  66%   5002
  75%   5003
  80%   5003
  90%   5004
  95%   5005
  98%   5008
  99%   5011
 100%   6104 (longest request)
```