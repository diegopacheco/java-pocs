# Rationale

This project show how to do a testing interface in spring boot. Such testing interface is 100% isolate form the application code. Most of scenations that is possible, sometimes we need change the code and to better engineering to do this right.

There are 2 scripts, one to run the application in non-prod environment, and one to run the application in prod environment. The only difference between the two is the active profile.

The testing interface `/product-create` only work for environment with with are NOT `prod`.

### Build

```bash
./mvnw clean install
```

### Results

Run the application in non-prod environment calling REAL API `/products`:
```bash
❯ ./list-products.sh
[
    {
        "id": 1,
        "name": "Laptop",
        "description": "High performance laptop",
        "price": 1299.99
    },
    {
        "id": 2,
        "name": "Smartphone",
        "description": "Latest smartphone model",
        "price": 899.99
    },
    {
        "id": 3,
        "name": "Headphones",
        "description": "Wireless noise-canceling headphones",
        "price": 299.99
    },
    {
        "id": 4,
        "name": "Keyboard",
        "description": "Mechanical gaming keyboard",
        "price": 149.99
    },
    {
        "id": 5,
        "name": "Monitor",
        "description": "4K Ultra HD monitor",
        "price": 499.99
    }
]
```

Call the testing interface `/product-create` again running in non-prod environment:
```bash
./create-product.sh
Enter product name: banana
Enter product description: green banana from tj
Enter product price: 2.34
{
    "id": 6,
    "name": "banana",
    "description": "green banana from tj",                                                                                      "price": 2.34
}
```

Listing products again in non-prod:
```bash
❯ ./list-products.sh
[
    {
        "id": 1,
        "name": "Laptop",
        "description": "High performance laptop",
        "price": 1299.99
    },
    {
        "id": 2,
        "name": "Smartphone",
        "description": "Latest smartphone model",
        "price": 899.99
    },
    {
        "id": 3,
        "name": "Headphones",
        "description": "Wireless noise-canceling headphones",
        "price": 299.99                                                                                                                },                                                                                                                                 {
        "id": 4,
        "name": "Keyboard",                                                                                                                "description": "Mechanical gaming keyboard",
        "price": 149.99
    },
    {
        "id": 5,
        "name": "Monitor",                                                                                                                 "description": "4K Ultra HD monitor",                                                                                              "price": 499.99
    },                                                                                                                                 {
        "id": 6,
        "name": "banana",
        "description": "green banana from tj",
        "price": 2.34
    }
]
```

Run the application with `prod` profile:

```bash
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS                                                                                                               [INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.526 s
[INFO] Finished at: 2026-02-05T23:09:49-08:00
[INFO] ------------------------------------------------------------------------
App running on: http://localhost:8081
Endpoints: http://localhost:8081/products

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v4.0.0)

2026-02-05T23:09:49.759-08:00  INFO 51286 --- [           main] c.g.d.sandboxspring.Application          : Starting Application v1.0-SNAPSHOT using Java 25 with PID 51286 (/Users/diegopacheco/git/diegopacheco/java-pocs/pocs/spring-boot-4-java-25-testing-interface/target/spring-boot-4-java-25-testing-interface-1.0-SNAPSHOT.war started by diegopacheco in /Users/diegopacheco/git/diegopacheco/java-pocs/pocs/spring-boot-4-java-25-testing-interface)
2026-02-05T23:09:49.762-08:00  INFO 51286 --- [           main] c.g.d.sandboxspring.Application          : The following 1 profile is active: "prod"
2026-02-05T23:09:50.298-08:00  INFO 51286 --- [           main] o.s.boot.tomcat.TomcatWebServer          : Tomcat initialized with port 8081 (http)
2026-02-05T23:09:50.309-08:00  INFO 51286 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2026-02-05T23:09:50.310-08:00  INFO 51286 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/11.0.14]
2026-02-05T23:09:50.335-08:00  INFO 51286 --- [           main] b.w.c.s.WebApplicationContextInitializer : Root WebApplicationContext: initialization completed in 542 ms
2026-02-05T23:09:50.596-08:00  INFO 51286 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint beneath base path '/actuator'
2026-02-05T23:09:50.636-08:00  INFO 51286 --- [           main] o.s.boot.tomcat.TomcatWebServer          : Tomcat started on port 8081 (http) with context path '/'                                                                                                   2026-02-05T23:09:50.641-08:00  INFO 51286 --- [           main] c.g.d.sandboxspring.Application          : Started Application in 1.086 seconds (process running for 1.322)                                                                                           Spring Boot 4.0.x working!
2026-02-05T23:10:33.589-08:00  INFO 51286 --- [nio-8081-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2026-02-05T23:10:33.589-08:00  INFO 51286 --- [nio-8081-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2026-02-05T23:10:33.590-08:00  INFO 51286 --- [nio-8081-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
```

Run the application in non-prod environment calling REAL API `/products`:
```bash
❯ ./list-products.sh
[
    {
        "id": 1,
        "name": "Laptop",
        "description": "High performance laptop",
        "price": 1299.99
    },
    {
        "id": 2,
        "name": "Smartphone",
        "description": "Latest smartphone model",
        "price": 899.99
    },
    {
        "id": 3,
        "name": "Headphones",
        "description": "Wireless noise-canceling headphones",
        "price": 299.99
    },
    {
        "id": 4,
        "name": "Keyboard",
        "description": "Mechanical gaming keyboard",
        "price": 149.99
    },
    {
        "id": 5,
        "name": "Monitor",
        "description": "4K Ultra HD monitor",
        "price": 499.99
    }
]
```

Trying to create a product using the testing interface `/product-create` again running in prod environment:
```bash
❯ ./create-product.sh
Enter product name: milk
Enter product description: white and plain milk from cotsco
Enter product price: 2.33
Error: Endpoint blocked. App is running in prod mode. Use ./run-non-prod.sh
```