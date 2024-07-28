### Build 
```bash
./mvnw clean install 
```
### Install Proton
```
curl https://install.timeplus.com/oss | sh
```

### Run Server
```
./proton server
```

### Run Client
```
./proton client
```
```
-- Create a stream with random data
CREATE RANDOM STREAM devices(
  device string default 'device'||to_string(rand()%4),
  temperature float default rand()%1000/10)

-- Run the streaming SQL
SELECT device, count(*), min(temperature), max(temperature)
FROM devices GROUP BY device
```

### Run App
```
./run.sh
```
```
❯ ./run.sh
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------< com.github.diegopacheco.javapocs:proton-simple >-----------
[INFO] Building proton-simple 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- exec:3.1.0:java (default-cli) @ proton-simple ---
select * from devices limit 10
device0
32.4
device1
66.1
device0
82.4
device0
21.6
device2
64.2
device3
17.1
device1
79.7
device1
93.3
device3
92.7
device1
73.3
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.558 s
[INFO] Finished at: 2024-07-28T00:52:19-07:00
[INFO] ------------------------------------------------------------------------

```