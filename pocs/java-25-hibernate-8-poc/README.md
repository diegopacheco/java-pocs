# java-25-hibernate-8-poc

Java 25 + Spring Boot 4.0.6 service running **Hibernate ORM 8.0.0.Alpha1** against **MySQL 9.7** on Podman, with schema generated automatically by Hibernate and REST endpoints covered by random-port integration tests.

## What is new in Hibernate 8

### Unified entity loading with `KeyType`

Hibernate 8 collapses "load by id" and "load by natural id" into a single `find` entry point. The selector is an enum, `org.hibernate.KeyType`, which implements `jakarta.persistence.FindOption`, so it slots straight into the standard `find(Class, Object, FindOption...)` signature.

```java
@Entity
class Person {
    @Id
    Integer id;
    @NaturalId
    String name;
}

session.find(Person.class, 1);                       // by id, implicit
session.find(Person.class, 1, KeyType.IDENTIFIER);   // by id, explicit
session.find(Person.class, "Bilbo Baggins", KeyType.NATURAL);

session.findMultiple(Person.class,
        List.of("Bilbo Baggins", "Gandolph the Grey"),
        KeyType.NATURAL);
```

`findMultiple` replaces the old `byMultipleIds` / `byMultipleNaturalId` access builders with one method that takes a `List` of keys and the same `KeyType` selector, returning a `List` of entities.

### Built on Jakarta Persistence 4.0

Hibernate 8.0.0.Alpha1 compiles against `jakarta.persistence-api:4.0.0-M1` (Jakarta EE 12), which introduces new SPI types such as `jakarta.persistence.EntityHandler`. This is newer than the Jakarta Persistence 3.2 that Spring Boot 4.0 ships by default, so this project pins the API version explicitly (see the build notes below).

### Java 25

The whole stack compiles and runs on Java 25 (Corretto 25 verified).

## How this app is wired

This service bootstraps Hibernate natively rather than through Spring Data JPA. A single `SessionFactory` bean is built from `org.hibernate.cfg.Configuration`, and the service layer runs each call through `SessionFactory.fromTransaction` / `inTransaction`, which open a short-lived `Session`, run the work inside a transaction, commit (or roll back on error), and close the session. That is the idiomatic Hibernate unit-of-work pattern and exposes the raw Hibernate 8 `find` / `findMultiple` API directly. Connections come from a HikariCP pool wired in through `hibernate.connection.provider_class`. Keeping Spring's JPA adapter out of the path avoids any version mismatch between the alpha Hibernate and Spring Boot's managed Hibernate.

```
config/HibernateConfig   builds the SessionFactory (datasource + dialect + hbm2ddl)
model/Person             @Entity with @Id and @NaturalId
service/PersonService    find / findByIdentifier / findByNaturalId / findByNaturalIds / save / findAll
controller/PersonController   REST endpoints
DataInitializer          seeds four people on startup
```

Schema creation is handled by Hibernate via `hibernate.hbm2ddl.auto=create`; the `Person` table is dropped and recreated on each boot.

## `@Id` vs `@NaturalId`

The `Person` entity carries two kinds of key, and they are not the same thing:

```java
@Id
Integer id;        // primary key  - the database's technical identity
@NaturalId
String name;       // natural key  - the domain's business identity
```

`@Id` (Jakarta Persistence) is the **primary key**: the row's technical, internal identity. Every entity must have one. Hibernate uses it to track entities in the persistence context, to build foreign keys for associations, and as the target of `find(Person.class, id)`. It is typically a stable surrogate value (here, an `Integer`) that never has to change even when the real-world data does.

`@NaturalId` (Hibernate-specific, not part of JPA) is the **business key**: the value that identifies the entity in the real world — a username, an email, an ISBN, a country code. Here it is `name`. You look an entity up by the value the domain actually cares about, and Hibernate resolves that natural key to the primary key (caching the natural-id → id mapping) before loading by primary key.

| | `@Id` | `@NaturalId` |
|---|---|---|
| Defined by | Jakarta Persistence (standard) | Hibernate (`org.hibernate.annotations`) |
| Role | Primary key / technical identity | Business / domain identity |
| Required | Every entity needs one | Optional |
| Mutability | Effectively fixed | Immutable by default (`mutable=true` to opt out) |
| Generated DDL | `primary key (id)` | `unique` constraint on the column |
| Loaded with | `find(Class, id)` · `KeyType.IDENTIFIER` | `KeyType.NATURAL` · `findMultiple(..., KeyType.NATURAL)` |

Hibernate's generated schema reflects exactly this split:

```sql
create table Person ( id integer not null, ..., name varchar(255), primary key (id) );
alter table Person add constraint UK... unique (name);
```

So Bilbo can be loaded either by his surrogate key `id = 1` or by his natural key `name = "Bilbo Baggins"` — and `KeyType.IDENTIFIER` vs `KeyType.NATURAL` is precisely how you choose between the two.

## REST endpoints

| Method | Path                      | Hibernate call                                        |
|--------|---------------------------|-------------------------------------------------------|
| GET    | `/people`                 | `createQuery("from Person ...")`                      |
| GET    | `/people/{id}`            | `find(Person.class, id)`                              |
| GET    | `/people/identifier/{id}` | `find(Person.class, id, KeyType.IDENTIFIER)`          |
| GET    | `/people/natural/{name}`  | `find(Person.class, name, KeyType.NATURAL)`           |
| POST   | `/people/natural`         | `findMultiple(Person.class, names, KeyType.NATURAL)`  |
| POST   | `/people`                 | `persist(person)`                                     |

`GET` by id or natural id returns `404` when nothing matches. `POST /people/natural` takes a JSON array of names.

```bash
curl localhost:8081/people
curl localhost:8081/people/1
curl localhost:8081/people/identifier/2
curl "localhost:8081/people/natural/Bilbo%20Baggins"
curl -X POST localhost:8081/people/natural -H 'Content-Type: application/json' \
  -d '["Bilbo Baggins","Gandolph the Grey"]'
curl -X POST localhost:8081/people -H 'Content-Type: application/json' \
  -d '{"id":100,"name":"Samwise Gamgee","city":"Hobbiton"}'
```

## Scripts

| Script     | Action                                                                 |
|------------|------------------------------------------------------------------------|
| `start.sh` | Starts MySQL on Podman, waits until it answers, then runs the app      |
| `stop.sh`  | Stops the app and tears down the MySQL container                       |
| `test.sh`  | Starts MySQL, waits until ready, runs the integration tests            |

```bash
./test.sh     # MySQL up + mvn test (random-port integration tests)
./start.sh    # MySQL up + app on http://localhost:8081
./stop.sh     # stop app + MySQL
```

MySQL runs from `compose.yaml` via `podman-compose` (image `mysql:9.7.0`, database `peopledb`, root/root).

## Tests

`PersonApiTests` runs the full application on a random port with `@SpringBootTest(webEnvironment = RANDOM_PORT)` and drives the REST endpoints through Spring Framework 7's `RestTestClient` (the successor to `TestRestTemplate`, which was removed in Spring Boot 4.0). Each `KeyType` access path has a dedicated test, plus a `404` case and a create-then-read-back case.

```
Tests run: 7, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

## Build notes

- `jakarta-persistence.version` is overridden to `4.0.0-M1` in `pom.xml` so the Jakarta Persistence API matches what Hibernate 8 compiles against (Spring Boot 4.0 pins `3.2.0`).
- Connection pooling uses HikariCP 7.0.2 via the `hibernate-hikaricp` module; pool size is set with `app.db.pool-size` (default 10). Without it, Hibernate falls back to its built-in pool, which logs "not intended for production use".
- Packaging is `jar`; the app uses the embedded server.
- MySQL connection uses `allowPublicKeyRetrieval=true&useSSL=false` for MySQL 9's `caching_sha2_password` over a local connection.

## Versions

| Component         | Version       |
|-------------------|---------------|
| Java              | 25            |
| Spring Boot       | 4.0.6         |
| Hibernate ORM     | 8.0.0.Alpha1  |
| Jakarta Persistence | 4.0.0-M1    |
| HikariCP          | 7.0.2         |
| MySQL             | 9.7.0         |
| MySQL connector   | 9.7.0         |
