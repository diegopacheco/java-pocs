# Java 21 + S3 Docker Compose App

This project demonstrates a Java 21 application that integrates with S3-compatible storage using the S3 API.

## Architecture

- **Java App Container**: Java 21 application using Maven and AWS S3 SDK
- **Storage Container**: S3-compatible storage service

## Run and Results

```bash
./start.sh
```

```bash
❯ ./start.sh
🧹 Cleaning up existing containers and volumes...
🗑️  Removing any orphaned volumes...
Total reclaimed space: 0B
🚀 Starting LIGHTNING-FAST S3 storage...
⏱️  Expected startup time: 5-10 seconds
[+] Building 35.7s (17/17) FINISHED                                                                                                                   docker:default
 => [java-app internal] load build definition from Dockerfile                                                                                                   0.0s
 => => transferring dockerfile: 346B                                                                                                                            0.0s
 => [java-app internal] load metadata for docker.io/library/eclipse-temurin:21-jre                                                                              0.7s
 => [java-app internal] load metadata for docker.io/library/maven:3.9.5-eclipse-temurin-21                                                                      0.7s
 => [java-app auth] library/eclipse-temurin:pull token for registry-1.docker.io                                                                                 0.0s
 => [java-app auth] library/maven:pull token for registry-1.docker.io                                                                                           0.0s
 => [java-app internal] load .dockerignore                                                                                                                      0.0s
 => => transferring context: 90B                                                                                                                                0.0s
 => [java-app build 1/6] FROM docker.io/library/maven:3.9.5-eclipse-temurin-21@sha256:2bbd188fef2384cf93181bb992b75542a2837afdd5c4c2274cebcae71cd05156         12.6s
 => => resolve docker.io/library/maven:3.9.5-eclipse-temurin-21@sha256:2bbd188fef2384cf93181bb992b75542a2837afdd5c4c2274cebcae71cd05156                         0.0s
 => => sha256:6cd63fc495d1a4839e5239c716fa5a6ec48209bff26db1e7d7af7b0701ac4ee7 17.46MB / 17.46MB                                                                1.9s
 => => sha256:2bbd188fef2384cf93181bb992b75542a2837afdd5c4c2274cebcae71cd05156 549B / 549B                                                                      0.0s
 => => sha256:bf9836bd77ede151c67c712b6a3c0ca3a404f96f573f6564abe7d67a48fd3c2f 7.26kB / 7.26kB                                                                  0.0s
 => => sha256:cbe3537751ce03ea42788c2fbe2d5d336180dc2e20472c8cdba8b3224191d101 30.45MB / 30.45MB                                                                2.6s
 => => sha256:6f94c7837cfae8449851f2228a8241c83e58f5dc4df91f4cdf4ec0f6a6cb5691 2.41kB / 2.41kB                                                                  0.0s
 => => sha256:fa6924fdd5c53e9e6a4f0905a3ae0632c92bdbffbbba857546a23871cef74265 158.64MB / 158.64MB                                                              9.1s
 => => sha256:be39ca79f5d28c28f3f2498ca0f67a9337066ea52acc98e8f3837b369bd32735 174B / 174B                                                                      2.2s
 => => sha256:c878de00ef575697a60f792a5b79be9f2e74d8970e6d7e519088ea205bef7a57 733B / 733B                                                                      2.5s
 => => sha256:c02261dca63cb902f7c1e5ab51b84c15ded32db0e8831de53ba1149d928affa7 18.99MB / 18.99MB                                                                3.7s
 => => extracting sha256:cbe3537751ce03ea42788c2fbe2d5d336180dc2e20472c8cdba8b3224191d101                                                                       1.0s
 => => sha256:438ecaf2080186244289c1b1352a9a4beafaff73420355d9d3e8ee7ebac3e5f0 9.43MB / 9.43MB                                                                  3.9s
 => => sha256:2f1ed4192907bdf7439a29fab0f99c93c50a93f21b1163da8141f603bbb397d7 853B / 853B                                                                      3.9s
 => => extracting sha256:6cd63fc495d1a4839e5239c716fa5a6ec48209bff26db1e7d7af7b0701ac4ee7                                                                       0.8s
 => => sha256:d4523df57fade8edf2b2dc05bef5b1e7a172f9feae189860d7ca53116d1ccb7e 355B / 355B                                                                      4.1s
 => => sha256:0a91d9253f3fe468ac072eecc9ebb6eeba96ed56dc8a7e1102ba67a6e9c3b6cb 155B / 155B                                                                      4.3s
 => => extracting sha256:fa6924fdd5c53e9e6a4f0905a3ae0632c92bdbffbbba857546a23871cef74265                                                                       2.0s
 => => extracting sha256:be39ca79f5d28c28f3f2498ca0f67a9337066ea52acc98e8f3837b369bd32735                                                                       0.0s
 => => extracting sha256:c878de00ef575697a60f792a5b79be9f2e74d8970e6d7e519088ea205bef7a57                                                                       0.0s
 => => extracting sha256:c02261dca63cb902f7c1e5ab51b84c15ded32db0e8831de53ba1149d928affa7                                                                       0.9s
 => => extracting sha256:438ecaf2080186244289c1b1352a9a4beafaff73420355d9d3e8ee7ebac3e5f0                                                                       0.1s
 => => extracting sha256:2f1ed4192907bdf7439a29fab0f99c93c50a93f21b1163da8141f603bbb397d7                                                                       0.0s
 => => extracting sha256:d4523df57fade8edf2b2dc05bef5b1e7a172f9feae189860d7ca53116d1ccb7e                                                                       0.0s
 => => extracting sha256:0a91d9253f3fe468ac072eecc9ebb6eeba96ed56dc8a7e1102ba67a6e9c3b6cb                                                                       0.0s
 => [java-app stage-1 1/3] FROM docker.io/library/eclipse-temurin:21-jre@sha256:ea350fe1d8bc9b18dea4ad46bb9a0f4d6fbd0dbb3548092e3ff8f1a3fef09efe                0.0s
 => [java-app internal] load build context                                                                                                                      0.0s
 => => transferring context: 8.07kB                                                                                                                             0.0s
 => CACHED [java-app stage-1 2/3] WORKDIR /app                                                                                                                  0.0s
 => [java-app build 2/6] WORKDIR /app                                                                                                                           0.5s
 => [java-app build 3/6] COPY pom.xml .                                                                                                                         0.0s
 => [java-app build 4/6] RUN mvn dependency:go-offline -B                                                                                                      15.7s
 => [java-app build 5/6] COPY src ./src                                                                                                                         0.0s 
 => [java-app build 6/6] RUN mvn clean package -DskipTests                                                                                                      5.7s 
 => [java-app stage-1 3/3] COPY --from=build /app/target/java-s3-app-1.0.0.jar app.jar                                                                          0.1s 
 => [java-app] exporting to image                                                                                                                               0.1s 
 => => exporting layers                                                                                                                                         0.1s 
 => => writing image sha256:b09e42cf35661fec6eb2b06d73dd72c535f4789651f726227f9796100e313fdc                                                                    0.0s 
 => => naming to docker.io/library/java-21-ceph-java-app                                                                                                        0.0s 
WARN[0035] Found orphan containers ([ceph]) for this project. If you removed or renamed this service in your compose file, you can run this command with the --remove-orphans flag to clean it up. 
[+] Running 3/2
 ✔ Network java-21-ceph_minio-network  Created                                                                                                                  0.0s 
 ✔ Container minio                     Created                                                                                                                  0.1s 
 ✔ Container java-s3-app               Created                                                                                                                  0.0s 
Attaching to java-s3-app, minio
minio        | INFO: Formatting 1st pool, 1 set(s), 1 drives per set.
minio        | INFO: WARNING: Host local has more than 0 drives of set. A host failure will result in data becoming unavailable.
minio        | MinIO Object Storage Server
minio        | Copyright: 2015-2025 MinIO, Inc.
minio        | License: GNU AGPLv3 - https://www.gnu.org/licenses/agpl-3.0.html
minio        | Version: RELEASE.2025-07-23T15-54-02Z (go1.24.5 linux/amd64)
minio        | 
minio        | API: http://172.19.0.2:9000  http://127.0.0.1:9000 
minio        | WebUI: http://172.19.0.2:9001 http://127.0.0.1:9001  
minio        | 
minio        | Docs: https://docs.min.io
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Starting S3 Java Application with Java 21
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Creating S3 client for endpoint: http://minio:9000
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Bucket 'test-bucket' created successfully
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Found 1 buckets:
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App -   - test-bucket
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Object 'test-file.txt' uploaded successfully
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Found 1 objects in bucket 'test-bucket':
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App -   - test-file.txt (size: 28 bytes)
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Downloaded object 'test-file.txt' content: Hello from Java 21 and Ceph!
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - All operations completed successfully!
java-s3-app exited with code 0
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Starting S3 Java Application with Java 21
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Creating S3 client for endpoint: http://minio:9000
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Bucket 'test-bucket' already exists
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Found 1 buckets:
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App -   - test-bucket
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Object 'test-file.txt' uploaded successfully
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Found 1 objects in bucket 'test-bucket':
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App -   - test-file.txt (size: 28 bytes)
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Downloaded object 'test-file.txt' content: Hello from Java 21 and Ceph!
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - All operations completed successfully!
java-s3-app exited with code 0
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Starting S3 Java Application with Java 21
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Creating S3 client for endpoint: http://minio:9000
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Bucket 'test-bucket' already exists
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Found 1 buckets:
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App -   - test-bucket
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Object 'test-file.txt' uploaded successfully
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Found 1 objects in bucket 'test-bucket':
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App -   - test-file.txt (size: 28 bytes)
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Downloaded object 'test-file.txt' content: Hello from Java 21 and Ceph!
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - All operations completed successfully!
java-s3-app exited with code 0
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Starting S3 Java Application with Java 21
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Creating S3 client for endpoint: http://minio:9000
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Bucket 'test-bucket' already exists
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Found 1 buckets:
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App -   - test-bucket
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Object 'test-file.txt' uploaded successfully
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Found 1 objects in bucket 'test-bucket':
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App -   - test-file.txt (size: 28 bytes)
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Downloaded object 'test-file.txt' content: Hello from Java 21 and Ceph!
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - All operations completed successfully!
java-s3-app exited with code 0
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Starting S3 Java Application with Java 21
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Creating S3 client for endpoint: http://minio:9000
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Bucket 'test-bucket' already exists
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Found 1 buckets:
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App -   - test-bucket
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Object 'test-file.txt' uploaded successfully
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Found 1 objects in bucket 'test-bucket':
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App -   - test-file.txt (size: 28 bytes)
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Downloaded object 'test-file.txt' content: Hello from Java 21 and Ceph!
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - All operations completed successfully!
java-s3-app exited with code 0
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Starting S3 Java Application with Java 21
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Creating S3 client for endpoint: http://minio:9000
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Bucket 'test-bucket' already exists
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Found 1 buckets:
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App -   - test-bucket
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Object 'test-file.txt' uploaded successfully
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Found 1 objects in bucket 'test-bucket':
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App -   - test-file.txt (size: 28 bytes)
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - Downloaded object 'test-file.txt' content: Hello from Java 21 and Ceph!
java-s3-app  | [main] INFO com.github.diegopacheco.javapocs.s3.S3App - All operations completed successfully!
java-s3-app exited with code 0
```

## Quick Start

1. Start the services:
```bash
./start.sh
```

2. The application will:
   - Connect to S3 API
   - Create a test bucket
   - Upload/download test objects
   - List buckets and objects

## Services

- **S3 API**: http://localhost:8000
- **Web Console**: http://localhost:5000 (test/test12345)

## Configuration

Environment variables for the Java app:
- `S3_ENDPOINT`: S3 endpoint (default: http://localhost:8000)
- `S3_ACCESS_KEY`: Access key (default: test)  
- `S3_SECRET_KEY`: Secret key (default: test12345)

## Development

Build locally:
```bash
mvn clean package
```

Run tests:
```bash
mvn test
```