### Rationale

Spring Data REST is very cool, the only thing I dont like is the fact that the contracts are being generated based on the model, I would like to not expose my 
database internal and create a level of abstraction.

### Version

```
Java: 23
Spring 3.4.x
MySQL: 8.X
HicariCP: 5.x
```

### Create DB

```bash
./create_db.sh
```

### Build 

```bash
./mvnw clean install
```

### Run

```bash
./run.sh
```

```
❯ ./run.sh
[INFO] Scanning for projects...
[INFO] 
[INFO] --< com.github.diegopacheco.sadbox.java:spring-boot-3-jpa-spring-rest >--
[INFO] Building jpa-simple 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] >>> spring-boot-maven-plugin:3.4.4:run (default-cli) > test-compile @ spring-boot-3-jpa-spring-rest >>>
[INFO] 
[INFO] --- maven-resources-plugin:3.3.1:resources (default-resources) @ spring-boot-3-jpa-spring-rest ---
[INFO] Copying 1 resource from src/main/resources to target/classes
[INFO] Copying 1 resource from src/main/resources to target/classes
[INFO] 
[INFO] --- maven-compiler-plugin:3.13.0:compile (default-compile) @ spring-boot-3-jpa-spring-rest ---
[INFO] Nothing to compile - all classes are up to date.
[INFO] 
[INFO] --- maven-resources-plugin:3.3.1:testResources (default-testResources) @ spring-boot-3-jpa-spring-rest ---
[INFO] skip non existing resourceDirectory /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-3-jpa-spring-REST/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.13.0:testCompile (default-testCompile) @ spring-boot-3-jpa-spring-rest ---
[INFO] Nothing to compile - all classes are up to date.
[INFO] 
[INFO] <<< spring-boot-maven-plugin:3.4.4:run (default-cli) < test-compile @ spring-boot-3-jpa-spring-rest <<<
[INFO] 
[INFO] 
[INFO] --- spring-boot-maven-plugin:3.4.4:run (default-cli) @ spring-boot-3-jpa-spring-rest ---
[INFO] Attaching agents: []

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.4.4)

2025-03-31T21:21:19.274-07:00  INFO 583197 --- [           main] c.g.d.sadbox.java.jpasimple.Application  : Starting Application using Java 23.0.2 with PID 583197 (/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-3-jpa-spring-REST/target/classes started by diego in /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-3-jpa-spring-REST)
2025-03-31T21:21:19.277-07:00  INFO 583197 --- [           main] c.g.d.sadbox.java.jpasimple.Application  : No active profile set, falling back to 1 default profile: "default"
2025-03-31T21:21:19.811-07:00  INFO 583197 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2025-03-31T21:21:19.943-07:00  INFO 583197 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 121 ms. Found 1 JPA repository interface.
2025-03-31T21:21:20.449-07:00  INFO 583197 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2025-03-31T21:21:20.464-07:00  INFO 583197 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2025-03-31T21:21:20.464-07:00  INFO 583197 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.39]
2025-03-31T21:21:20.505-07:00  INFO 583197 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2025-03-31T21:21:20.506-07:00  INFO 583197 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1177 ms
2025-03-31T21:21:20.600-07:00  INFO 583197 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2025-03-31T21:21:20.735-07:00  INFO 583197 --- [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection com.mysql.cj.jdbc.ConnectionImpl@60dc1a4e
2025-03-31T21:21:20.736-07:00  INFO 583197 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2025-03-31T21:21:20.808-07:00  INFO 583197 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2025-03-31T21:21:20.846-07:00  INFO 583197 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 6.6.11.Final
2025-03-31T21:21:20.873-07:00  INFO 583197 --- [           main] o.h.c.internal.RegionFactoryInitiator    : HHH000026: Second-level cache disabled
2025-03-31T21:21:21.121-07:00  INFO 583197 --- [           main] o.s.o.j.p.SpringPersistenceUnitInfo      : No LoadTimeWeaver setup: ignoring JPA class transformer
2025-03-31T21:21:21.181-07:00  WARN 583197 --- [           main] org.hibernate.orm.deprecation            : HHH90000025: MySQLDialect does not need to be specified explicitly using 'hibernate.dialect' (remove the property setting and it will be selected by default)
2025-03-31T21:21:21.192-07:00  INFO 583197 --- [           main] org.hibernate.orm.connections.pooling    : HHH10001005: Database info:
	Database JDBC URL [Connecting through datasource 'HikariDataSource (HikariPool-1)']
	Database driver: undefined/unknown
	Database version: 8.3
	Autocommit mode: undefined/unknown
	Isolation level: undefined/unknown
	Minimum pool size: undefined/unknown
	Maximum pool size: undefined/unknown
2025-03-31T21:21:21.773-07:00  INFO 583197 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000489: No JTA platform available (set 'hibernate.transaction.jta.platform' to enable JTA platform integration)
2025-03-31T21:21:21.775-07:00  INFO 583197 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2025-03-31T21:21:22.005-07:00  WARN 583197 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2025-03-31T21:21:22.485-07:00  INFO 583197 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
2025-03-31T21:21:22.492-07:00  INFO 583197 --- [           main] c.g.d.sadbox.java.jpasimple.Application  : Started Application in 3.568 seconds (process running for 3.876)
Contact{id=21, name='Contact 1', email='contact1@email.com', phone='(111) 111-1111'}
Contact{id=22, name='Contact 2', email='contact2@email.com', phone='(111) 111-1111'}
Contact{id=23, name='Contact 3', email='contact3@email.com', phone='(111) 111-1111'}
Contact{id=24, name='Contact 4', email='contact4@email.com', phone='(111) 111-1111'}
Contact{id=25, name='Contact 5', email='contact5@email.com', phone='(111) 111-1111'}
Contact{id=26, name='Contact 6', email='contact6@email.com', phone='(111) 111-1111'}
Contact{id=27, name='Contact 7', email='contact7@email.com', phone='(111) 111-1111'}
Contact{id=28, name='Contact 8', email='contact8@email.com', phone='(111) 111-1111'}
Contact{id=29, name='Contact 9', email='contact9@email.com', phone='(111) 111-1111'}
Contact{id=30, name='Contact 10', email='contact10@email.com', phone='(111) 111-1111'}
```

### Spring REST

```
http://localhost:8080/
```

```
{
  "_links" : {
    "contacts" : {
      "href" : "http://localhost:8080/contacts{?page,size,sort*}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://localhost:8080/profile"
    }
  }
}
```

Pagination for FREE
```
❯ curl -i http://localhost:8080/contacts\?page\=1
HTTP/1.1 200 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Tue, 01 Apr 2025 04:32:36 GMT

{
  "_embedded" : {
    "contacts" : [ ]
  },
  "_links" : {
    "first" : {
      "href" : "http://localhost:8080/contacts?page=0&size=20"
    },
    "prev" : {
      "href" : "http://localhost:8080/contacts?page=0&size=20"
    },
    "self" : {
      "href" : "http://localhost:8080/contacts?page=1&size=20"
    },
    "last" : {
      "href" : "http://localhost:8080/contacts?page=0&size=20"
    },
    "profile" : {
      "href" : "http://localhost:8080/profile/contacts"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 10,
    "totalPages" : 1,
    "number" : 1
  }
}
```

Sorting for FREE
```
❯ curl -i http://localhost:8080/contacts\?sort\=name\&size\=2
HTTP/1.1 200 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Tue, 01 Apr 2025 04:33:54 GMT

{
  "_embedded" : {
    "contacts" : [ {
      "name" : "Contact 1",
      "email" : "contact1@email.com",
      "phone" : "(111) 111-1111",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/contacts/71"
        },
        "contact" : {
          "href" : "http://localhost:8080/contacts/71"
        }
      }
    }, {
      "name" : "Contact 10",
      "email" : "contact10@email.com",
      "phone" : "(111) 111-1111",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/contacts/80"
        },
        "contact" : {
          "href" : "http://localhost:8080/contacts/80"
        }
      }
    } ]
  },
  "_links" : {
    "first" : {
      "href" : "http://localhost:8080/contacts?page=0&size=2&sort=name,asc"
    },
    "self" : {
      "href" : "http://localhost:8080/contacts?page=0&size=2&sort=name,asc"
    },
    "next" : {
      "href" : "http://localhost:8080/contacts?page=1&size=2&sort=name,asc"
    },
    "last" : {
      "href" : "http://localhost:8080/contacts?page=4&size=2&sort=name,asc"
    },
    "profile" : {
      "href" : "http://localhost:8080/profile/contacts"
    }
  },
  "page" : {
    "size" : 2,
    "totalElements" : 10,
    "totalPages" : 5,
    "number" : 0
  }
}%                          
```

Insert for FREE

```
❯ curl -i -X POST -H "Content-Type:application/json" -d '{
  "name": "Test Contact new 42",
  "email": "contact@test.com",
  "phone": "(555) 555-5555"
}' http://localhost:8080/contacts
HTTP/1.1 201 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Location: http://localhost:8080/contacts/81
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Tue, 01 Apr 2025 04:36:42 GMT

{
  "name" : "Test Contact new 42",
  "email" : "contact@test.com",
  "phone" : "(555) 555-5555",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/contacts/81"
    },
    "contact" : {
      "href" : "http://localhost:8080/contacts/81"
    }
  }
}
```
