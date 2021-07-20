### Good Samples on Logging 
```css
https://dzone.com/articles/how-configure-slf4j-different 
```

### Contract
Libs should not have logginng implementations - thats the same for agents. 
Libs should only have the contract
```xml
        <!-- https://mvnrepository.com/artifact/org.slf4j/slf4j-api -->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>1.7.31</version>
        </dependency>
```
The main issue is different loggers will have different config files: log4j.properties, logback.xml, etc... 
You either know what log will be loader or have all possible config files. 

### Spring Boot

By Default Spring is pig-baking on logback and log4j is not the default. Is possible to change that. 
```css
https://www.callicoder.com/spring-boot-log4j-2-example/
```
