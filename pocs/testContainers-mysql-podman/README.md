### Build 
```bash
./mvnw clean install 
```
### Docker / Podman setup
```
❯ sudo systemctl stop docker
❯ docker ps
Cannot connect to the Docker daemon at unix:///var/run/docker.sock. Is the docker daemon running?
❯ podman ps
CONTAINER ID  IMAGE       COMMAND     CREATED     STATUS      PORTS       NAMES
❯ 
```
### Enable podman shock
```
# Enable the Podman socket
systemctl --user enable podman.socket --now
```

### Test Results
```
export DOCKER_HOST=unix:///run/user/`id -u`/podman/podman.sock
export TESTCONTAINERS_RYUK_DISABLED=true
./mvnw test
```
```
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.github.diegopacheco.javapocs.test.MySQLUsingJDBCTest
2024-05-30 23:23:30 INFO  PullPolicy:59 - Image pull policy will be performed by: DefaultPullPolicy()
2024-05-30 23:23:30 INFO  ImageNameSubstitutor:60 - Image name substitution will be performed by: DefaultImageNameSubstitutor (composite of 'ConfigurationFileImageNameSubstitutor' and 'PrefixingImageNameSubstitutor')
2024-05-30 23:23:30 INFO  DockerClientProviderStrategy:383 - Loaded org.testcontainers.dockerclient.UnixSocketClientProviderStrategy from ~/.testcontainers.properties, will try it first
2024-05-30 23:23:33 INFO  DockerClientProviderStrategy:293 - Found Docker environment with Environment variables, system properties and defaults. Resolved dockerHost=unix:///run/user/1000/podman/podman.sock
2024-05-30 23:23:33 INFO  DockerClientFactory:206 - Docker host IP address is localhost
2024-05-30 23:23:36 INFO  DockerClientFactory:213 - Connected to docker: 
  Server Version: 3.4.2
  API Version: 1.40
  Operating System: ubuntu
  Total Memory: 64150 MB
2024-05-30 23:23:36 WARN  ResourceReaper:89 - 
********************************************************************************
Ryuk has been disabled. This can cause unexpected behavior in your environment.
********************************************************************************
2024-05-30 23:23:36 INFO  DockerClientFactory:243 - Checking the system...
2024-05-30 23:23:36 INFO  DockerClientFactory:264 - ✔︎ Docker server version should be at least 1.6.0
2024-05-30 23:23:36 INFO  7:80 - Pulling docker image: mysql:5.7. Please be patient; this may take some time but only needs to be done once.
2024-05-30 23:23:36 INFO  7:47 - Starting to pull image
2024-05-30 23:23:38 INFO  7:93 - Pulling image layers:  0 pending,  1 downloaded,  0 extracted, (0 bytes/0 bytes)
2024-05-30 23:23:38 INFO  7:93 - Pulling image layers:  2 pending,  2 downloaded,  0 extracted, (0 bytes/? MB)
2024-05-30 23:23:38 INFO  7:93 - Pulling image layers:  2 pending,  3 downloaded,  0 extracted, (0 bytes/? MB)
2024-05-30 23:23:38 INFO  7:93 - Pulling image layers:  2 pending,  4 downloaded,  0 extracted, (0 bytes/? MB)
2024-05-30 23:23:39 INFO  7:93 - Pulling image layers:  1 pending,  5 downloaded,  0 extracted, (0 bytes/? MB)
2024-05-30 23:23:39 INFO  7:93 - Pulling image layers:  2 pending,  6 downloaded,  0 extracted, (0 bytes/? MB)
2024-05-30 23:23:39 INFO  7:93 - Pulling image layers:  3 pending,  7 downloaded,  0 extracted, (0 bytes/? MB)
2024-05-30 23:23:39 INFO  7:93 - Pulling image layers:  3 pending,  8 downloaded,  0 extracted, (24 MB/? MB)
2024-05-30 23:23:41 INFO  7:93 - Pulling image layers:  2 pending,  9 downloaded,  0 extracted, (90 MB/? MB)
2024-05-30 23:23:42 INFO  7:93 - Pulling image layers:  1 pending, 10 downloaded,  0 extracted, (109 MB/? MB)
2024-05-30 23:23:46 INFO  7:93 - Pulling image layers:  0 pending, 11 downloaded,  0 extracted, (109 MB/126 MB)
2024-05-30 23:23:46 INFO  7:93 - Pulling image layers:  0 pending, 12 downloaded,  0 extracted, (109 MB/126 MB)
2024-05-30 23:23:46 INFO  7:93 - Pulling image layers:  0 pending, 12 downloaded,  0 extracted, (109 MB/126 MB)
2024-05-30 23:23:46 INFO  7:116 - Pull complete. 12 layers, pulled in 10s (downloaded 109 MB at 10 MB/s)
2024-05-30 23:23:46 INFO  7:120 - Image mysql:5.7 pull took PT10.322773152S
2024-05-30 23:23:46 INFO  7:387 - Creating container for image: mysql:5.7
2024-05-30 23:23:48 INFO  7:451 - Container mysql:5.7 is starting: bbefe3abbe0b7276c8603a8b18c586a941cb4c718bf6f5ea11203c1f9580cb97
2024-05-30 23:23:53 INFO  7:145 - Waiting for database connection to become available at jdbc:mysql://localhost:36013/test using query 'SELECT 1'
2024-05-30 23:23:58 INFO  7:541 - Container mysql:5.7 started in PT11.393473532S
2024-05-30 23:23:58 INFO  7:187 - Container is started (JDBC URL: jdbc:mysql://localhost:36013/test)
JDBC URL: jdbc:mysql://localhost:36013/test
2024-05-30 23:23:58 INFO  HikariDataSource:79 - HikariPool-1 - Starting...
2024-05-30 23:23:58 INFO  HikariPool:554 - HikariPool-1 - Added connection com.mysql.cj.jdbc.ConnectionImpl@7ab4ae59
2024-05-30 23:23:58 INFO  HikariDataSource:81 - HikariPool-1 - Start completed.
Created table users
Inserted records into the table USERS...
ID: 100, Age: 18, First: John, Last: Doe
ID: 101, Age: 25, First: Mary, Last: Jane Watson
ID: 102, Age: 30, First: Petter, Last: Parker
ID: 103, Age: 28, First: Ace, Last: Ventura
2024-05-30 23:23:58 INFO  HikariDataSource:349 - HikariPool-1 - Shutdown initiated...
2024-05-30 23:23:58 INFO  HikariDataSource:351 - HikariPool-1 - Shutdown completed.
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 29.15 s -- in com.github.diegopacheco.javapocs.test.MySQLUsingJDBCTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  30.826 s
[INFO] Finished at: 2024-05-30T23:23:59-07:00
[INFO] ------------------------------------------------------------------------
```
