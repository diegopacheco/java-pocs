### Build 

```bash
./mvnw clean install 
```

### Result

```
[INFO] Scanning for projects...
[INFO]
[INFO] ------< com.github.diegopacheco.javapocs:java-25-apache-calcite >-------
[INFO] Building java-25-apache-calcite 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- exec:3.5.0:java (default-cli) @ java-25-apache-calcite ---
2025-09-22 21:18:31 DEBUG parser:890 - Reduced `AGE` > 21
Parsed SQL: SELECT `NAME`, `AGE`
FROM `USERS`
WHERE `AGE` > 21
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.387 s
[INFO] Finished at: 2025-09-22T21:18:31-07:00
[INFO] ------------------------------------------------------------------------
```

## Calcite

⏺ Apache Calcite has many powerful features:

Core SQL Features:
- SQL parser, validator, and JDBC driver
- Query optimization with relational algebra
- Cost-based query planning
- Rule-based query transformations

Data Integration:
- Adapters for various data sources (CSV, JSON, MongoDB, Elasticsearch, etc.)
- Schema discovery and metadata management
- Query federation across multiple data sources

Advanced Capabilities:
- Streaming SQL for real-time data processing
- Materialized view support
- Custom functions and operators
- Lattice-based aggregation optimization

Query Processing:
- Volcano-style query execution
- Code generation for performance
- Push-down optimization to data sources
- Join reordering and predicate pushdown

Extensibility:
- Pluggable cost models
- Custom planning rules
- Schema adapters for any data format
- Function libraries


