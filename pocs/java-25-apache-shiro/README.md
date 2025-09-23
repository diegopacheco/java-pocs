### Build

```bash
./mvnw clean install
```

### Results

```bash
/Users/diegopacheco/.sdkman/candidates/java/25-zulu/zulu-25.jdk/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=50667 -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /Users/diegopacheco/Documents/git/diegopacheco/java-pocs/pocs/java-25-apache-shiro/target/classes:/Users/diegopacheco/.m2/repository/org/springframework/boot/spring-boot-starter-web/3.5.5/spring-boot-starter-web-3.5.5.jar:/Users/diegopacheco/.m2/repository/org/springframework/boot/spring-boot-starter/3.5.5/spring-boot-starter-3.5.5.jar:/Users/diegopacheco/.m2/repository/org/springframework/boot/spring-boot/3.5.5/spring-boot-3.5.5.jar:/Users/diegopacheco/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/3.5.5/spring-boot-autoconfigure-3.5.5.jar:/Users/diegopacheco/.m2/repository/org/springframework/boot/spring-boot-starter-logging/3.5.5/spring-boot-starter-logging-3.5.5.jar:/Users/diegopacheco/.m2/repository/ch/qos/logback/logback-classic/1.5.18/logback-classic-1.5.18.jar:/Users/diegopacheco/.m2/repository/ch/qos/logback/logback-core/1.5.18/logback-core-1.5.18.jar:/Users/diegopacheco/.m2/repository/org/apache/logging/log4j/log4j-to-slf4j/2.24.3/log4j-to-slf4j-2.24.3.jar:/Users/diegopacheco/.m2/repository/org/apache/logging/log4j/log4j-api/2.24.3/log4j-api-2.24.3.jar:/Users/diegopacheco/.m2/repository/org/slf4j/jul-to-slf4j/2.0.17/jul-to-slf4j-2.0.17.jar:/Users/diegopacheco/.m2/repository/jakarta/annotation/jakarta.annotation-api/2.1.1/jakarta.annotation-api-2.1.1.jar:/Users/diegopacheco/.m2/repository/org/yaml/snakeyaml/2.4/snakeyaml-2.4.jar:/Users/diegopacheco/.m2/repository/org/springframework/boot/spring-boot-starter-json/3.5.5/spring-boot-starter-json-3.5.5.jar:/Users/diegopacheco/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.19.2/jackson-databind-2.19.2.jar:/Users/diegopacheco/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.19.2/jackson-annotations-2.19.2.jar:/Users/diegopacheco/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.19.2/jackson-core-2.19.2.jar:/Users/diegopacheco/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jdk8/2.19.2/jackson-datatype-jdk8-2.19.2.jar:/Users/diegopacheco/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.19.2/jackson-datatype-jsr310-2.19.2.jar:/Users/diegopacheco/.m2/repository/com/fasterxml/jackson/module/jackson-module-parameter-names/2.19.2/jackson-module-parameter-names-2.19.2.jar:/Users/diegopacheco/.m2/repository/org/springframework/boot/spring-boot-starter-tomcat/3.5.5/spring-boot-starter-tomcat-3.5.5.jar:/Users/diegopacheco/.m2/repository/org/apache/tomcat/embed/tomcat-embed-core/10.1.44/tomcat-embed-core-10.1.44.jar:/Users/diegopacheco/.m2/repository/org/apache/tomcat/embed/tomcat-embed-el/10.1.44/tomcat-embed-el-10.1.44.jar:/Users/diegopacheco/.m2/repository/org/apache/tomcat/embed/tomcat-embed-websocket/10.1.44/tomcat-embed-websocket-10.1.44.jar:/Users/diegopacheco/.m2/repository/org/springframework/spring-web/6.2.10/spring-web-6.2.10.jar:/Users/diegopacheco/.m2/repository/org/springframework/spring-beans/6.2.10/spring-beans-6.2.10.jar:/Users/diegopacheco/.m2/repository/org/springframework/spring-webmvc/6.2.10/spring-webmvc-6.2.10.jar:/Users/diegopacheco/.m2/repository/org/springframework/spring-aop/6.2.10/spring-aop-6.2.10.jar:/Users/diegopacheco/.m2/repository/org/springframework/spring-context/6.2.10/spring-context-6.2.10.jar:/Users/diegopacheco/.m2/repository/org/springframework/spring-expression/6.2.10/spring-expression-6.2.10.jar:/Users/diegopacheco/.m2/repository/org/springframework/boot/spring-boot-starter-actuator/3.5.5/spring-boot-starter-actuator-3.5.5.jar:/Users/diegopacheco/.m2/repository/org/springframework/boot/spring-boot-actuator-autoconfigure/3.5.5/spring-boot-actuator-autoconfigure-3.5.5.jar:/Users/diegopacheco/.m2/repository/org/springframework/boot/spring-boot-actuator/3.5.5/spring-boot-actuator-3.5.5.jar:/Users/diegopacheco/.m2/repository/io/micrometer/micrometer-observation/1.15.3/micrometer-observation-1.15.3.jar:/Users/diegopacheco/.m2/repository/io/micrometer/micrometer-commons/1.15.3/micrometer-commons-1.15.3.jar:/Users/diegopacheco/.m2/repository/io/micrometer/micrometer-jakarta9/1.15.3/micrometer-jakarta9-1.15.3.jar:/Users/diegopacheco/.m2/repository/io/micrometer/micrometer-core/1.15.3/micrometer-core-1.15.3.jar:/Users/diegopacheco/.m2/repository/org/hdrhistogram/HdrHistogram/2.2.2/HdrHistogram-2.2.2.jar:/Users/diegopacheco/.m2/repository/org/latencyutils/LatencyUtils/2.0.3/LatencyUtils-2.0.3.jar:/Users/diegopacheco/.m2/repository/org/slf4j/slf4j-api/2.0.17/slf4j-api-2.0.17.jar:/Users/diegopacheco/.m2/repository/org/springframework/spring-core/6.2.10/spring-core-6.2.10.jar:/Users/diegopacheco/.m2/repository/org/springframework/spring-jcl/6.2.10/spring-jcl-6.2.10.jar:/Users/diegopacheco/.m2/repository/org/apache/shiro/shiro-spring/1.13.0/shiro-spring-1.13.0.jar:/Users/diegopacheco/.m2/repository/org/apache/shiro/shiro-core/1.13.0/shiro-core-1.13.0.jar:/Users/diegopacheco/.m2/repository/org/apache/shiro/shiro-lang/1.13.0/shiro-lang-1.13.0.jar:/Users/diegopacheco/.m2/repository/org/apache/shiro/shiro-cache/1.13.0/shiro-cache-1.13.0.jar:/Users/diegopacheco/.m2/repository/org/apache/shiro/shiro-crypto-hash/1.13.0/shiro-crypto-hash-1.13.0.jar:/Users/diegopacheco/.m2/repository/org/apache/shiro/shiro-crypto-core/1.13.0/shiro-crypto-core-1.13.0.jar:/Users/diegopacheco/.m2/repository/org/apache/shiro/shiro-crypto-cipher/1.13.0/shiro-crypto-cipher-1.13.0.jar:/Users/diegopacheco/.m2/repository/org/apache/shiro/shiro-config-core/1.13.0/shiro-config-core-1.13.0.jar:/Users/diegopacheco/.m2/repository/org/apache/shiro/shiro-config-ogdl/1.13.0/shiro-config-ogdl-1.13.0.jar:/Users/diegopacheco/.m2/repository/commons-beanutils/commons-beanutils/1.9.4/commons-beanutils-1.9.4.jar:/Users/diegopacheco/.m2/repository/commons-collections/commons-collections/3.2.2/commons-collections-3.2.2.jar:/Users/diegopacheco/.m2/repository/org/apache/shiro/shiro-event/1.13.0/shiro-event-1.13.0.jar:/Users/diegopacheco/.m2/repository/org/apache/shiro/shiro-web/1.13.0/shiro-web-1.13.0.jar:/Users/diegopacheco/.m2/repository/org/owasp/encoder/encoder/1.2.3/encoder-1.2.3.jar:/Users/diegopacheco/.m2/repository/javax/servlet/javax.servlet-api/4.0.1/javax.servlet-api-4.0.1.jar com.github.diegopacheco.sandboxspring.Application

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.5.5)

2025-09-22T21:02:07.983-07:00  INFO 77696 --- [           main] c.g.d.sandboxspring.Application          : Starting Application using Java 25 with PID 77696 (/Users/diegopacheco/Documents/git/diegopacheco/java-pocs/pocs/java-25-apache-shiro/target/classes started by diegopacheco in /Users/diegopacheco/Documents/git/diegopacheco/java-pocs/pocs/java-25-apache-shiro)
2025-09-22T21:02:07.984-07:00  INFO 77696 --- [           main] c.g.d.sandboxspring.Application          : No active profile set, falling back to 1 default profile: "default"
2025-09-22T21:02:08.283-07:00  WARN 77696 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'shiroConfig' of type [com.github.diegopacheco.sandboxspring.config.ShiroConfig$$SpringCGLIB$$0] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying). Is this bean getting eagerly injected/applied to a currently created BeanPostProcessor []? Check the corresponding BeanPostProcessor declaration and its dependencies/advisors. If this bean does not have to be post-processed, declare it with ROLE_INFRASTRUCTURE.
2025-09-22T21:02:08.289-07:00  WARN 77696 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'shiroRealm' of type [org.apache.shiro.realm.text.IniRealm] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying). Is this bean getting eagerly injected/applied to a currently created BeanPostProcessor []? Check the corresponding BeanPostProcessor declaration and its dependencies/advisors. If this bean does not have to be post-processed, declare it with ROLE_INFRASTRUCTURE.
2025-09-22T21:02:08.299-07:00  WARN 77696 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'securityManager' of type [org.apache.shiro.web.mgt.DefaultWebSecurityManager] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying). Is this bean getting eagerly injected/applied to a currently created BeanPostProcessor []? Check the corresponding BeanPostProcessor declaration and its dependencies/advisors. If this bean does not have to be post-processed, declare it with ROLE_INFRASTRUCTURE.
2025-09-22T21:02:08.367-07:00  INFO 77696 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2025-09-22T21:02:08.372-07:00  INFO 77696 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2025-09-22T21:02:08.372-07:00  INFO 77696 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.44]
2025-09-22T21:02:08.387-07:00  INFO 77696 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2025-09-22T21:02:08.387-07:00  INFO 77696 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 387 ms
2025-09-22T21:02:08.578-07:00  INFO 77696 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint beneath base path '/actuator'
2025-09-22T21:02:08.608-07:00  INFO 77696 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
2025-09-22T21:02:08.617-07:00  INFO 77696 --- [           main] c.g.d.sandboxspring.Application          : Started Application in 0.763 seconds (process running for 0.874)
Spring Boot 3.5.x working! 
```

```bash
❯ ./test.sh
=== Apache Shiro Authentication Tests ===

1. Testing login with root user (admin role):
Login successful for user: root

2. Testing current user (should show logged in user):
No user logged in

3. Testing admin role check:
User has role 'admin': false

4. Testing admin-only endpoint:
Admin-only information - you have admin role!

5. Testing logout:
No user logged in

6. Testing current user after logout:
No user logged in

7. Testing login with guest user:
Login successful for user: guest

8. Testing guest role check:
User has role 'guest': false

9. Testing admin role check for guest (should be false):
User has role 'admin': false

10. Testing lonestarr user with schwartz role:
User already logged in: root

11. Testing schwartz role check:
User has role 'schwartz': false

12. Testing lightsaber permission:
User has permission 'lightsaber:wield': false

13. Testing invalid login:
Unknown account: invalid

14. Testing basic endpoint (should work without authentication):
Greetings from Spring Boot!
```