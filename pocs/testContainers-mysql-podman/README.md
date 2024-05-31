### Build 
```bash
./mvnw clean install 
```
### Test Results
```
2024-05-30 23:10:20 INFO  PullPolicy:59 - Image pull policy will be performed by: DefaultPullPolicy()
2024-05-30 23:10:20 INFO  ImageNameSubstitutor:60 - Image name substitution will be performed by: DefaultImageNameSubstitutor (composite of 'ConfigurationFileImageNameSubstitutor' and 'PrefixingImageNameSubstitutor')
2024-05-30 23:10:20 INFO  DockerClientProviderStrategy:383 - Loaded org.testcontainers.dockerclient.UnixSocketClientProviderStrategy from ~/.testcontainers.properties, will try it first
2024-05-30 23:10:20 INFO  DockerClientProviderStrategy:293 - Found Docker environment with local Unix socket (unix:///var/run/docker.sock)
2024-05-30 23:10:20 INFO  DockerClientFactory:206 - Docker host IP address is localhost
2024-05-30 23:10:20 INFO  DockerClientFactory:213 - Connected to docker: 
  Server Version: 19.03.11
  API Version: 1.40
  Operating System: Ubuntu 22.04.4 LTS
  Total Memory: 64150 MB
2024-05-30 23:10:21 INFO  0:387 - Creating container for image: testcontainers/ryuk:0.7.0
2024-05-30 23:10:21 INFO  0:451 - Container testcontainers/ryuk:0.7.0 is starting: 0c7436595323f6c6f534c191fa7cf0f4e64c0e31fa7d362effe816ec49d4f456
2024-05-30 23:10:21 INFO  0:541 - Container testcontainers/ryuk:0.7.0 started in PT0.721085098S
2024-05-30 23:10:21 INFO  RyukResourceReaper:43 - Ryuk started - will monitor and terminate Testcontainers containers on JVM exit
2024-05-30 23:10:21 INFO  DockerClientFactory:243 - Checking the system...
2024-05-30 23:10:21 INFO  DockerClientFactory:264 - ✔︎ Docker server version should be at least 1.6.0
2024-05-30 23:10:21 INFO  7:387 - Creating container for image: mysql:5.7
2024-05-30 23:10:21 INFO  7:451 - Container mysql:5.7 is starting: 45f64d747fe493badd49d373eb9b3083072fac10411342e854688fc3d8901eac
2024-05-30 23:10:22 INFO  7:145 - Waiting for database connection to become available at jdbc:mysql://localhost:32779/test using query 'SELECT 1'
2024-05-30 23:10:32 INFO  7:541 - Container mysql:5.7 started in PT10.304087905S
2024-05-30 23:10:32 INFO  7:187 - Container is started (JDBC URL: jdbc:mysql://localhost:32779/test)
JDBC URL: jdbc:mysql://localhost:32779/test
2024-05-30 23:10:32 INFO  HikariDataSource:79 - HikariPool-1 - Starting...
2024-05-30 23:10:32 INFO  HikariPool:554 - HikariPool-1 - Added connection com.mysql.cj.jdbc.ConnectionImpl@48a0c8aa
2024-05-30 23:10:32 INFO  HikariDataSource:81 - HikariPool-1 - Start completed.
Created table users
Inserted records into the table USERS...
ID: 100, Age: 18, First: John, Last: Doe
ID: 101, Age: 25, First: Mary, Last: Jane Watson
ID: 102, Age: 30, First: Petter, Last: Parker
ID: 103, Age: 28, First: Ace, Last: Ventura

Process finished with exit code 0
```
