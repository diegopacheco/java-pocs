# Okta Spring Security & Okta-Hosted Login Page Example

This example shows you how to use the [Okta Spring Boot Library][] to login a user.  The login is achieved through the [Authorization Code Flow][] where the user is redirected to the Okta-Hosted login page.  After the user authenticates, they are redirected back to the application and a local cookie session is created.

## Prerequisites

Before running this sample, you will need the following:

* [Java 11+](https://sdkman.io/jdks)
* [The Okta CLI Tool](https://github.com/okta/okta-cli/#installation)
* An Okta Developer Account, create one using `okta register`, or configure an existing one with `okta login`

## Get the Code

Grab and configure this project using `okta start spring-boot`.

> **NOTE**: If you'd like to use WebFlux instead of Spring MVC, use `okta start spring-boot --branch webflux`.

## Run the Example

```bash
./mvnw spring-boot:run
```

For more details on how to build an application with Okta and Spring Boot / Spring Security you can read [this blog post](https://developer.okta.com/blog/2019/05/15/spring-boot-login-options).

[Okta Spring Boot Library]: https://github.com/okta/okta-spring-boot
[OIDC Web Application Setup Instructions]: https://developer.okta.com/authentication-guide/implementing-authentication/auth-code#1-setting-up-your-application
[Authorization Code Flow]: https://developer.okta.com/authentication-guide/implementing-authentication/auth-code
