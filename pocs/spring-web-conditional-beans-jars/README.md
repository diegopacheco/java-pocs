## POC

This poc is about @ConditionalOnClass and ConditionalOnMissingClass 
which allow us to cherry pick intire configuration classes based
on dependencies being present or absent. This cool but non-obvious.

### Build
```bash
./mvnw clean install
```
### Tomcat
pom.xml
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
```
http://localhost:8080/
```
```
Server running is: TOMCAT
```
### Netty
pom.xml
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-webflux</artifactId>
</dependency>
```
```
http://localhost:8080/
```
```
Server running is: NETTY
```