# XTDB

XTDB(https://github.com/xtdb/xtdb) is a general-purpose, document-oriented database with bitemporal queries.

### Build 

```bash
./mvnw clean install 
```

### Result

```
XTDB started with in-memory storage
Writing initial data...
Initial data written at: xtdb.api.TransactionInstant@92227d0e
Updating data...
Data updated at: xtdb.api.TransactionInstant@9222850c
Querying current state...
Current state:
  ["Alice" 31 "Boston"]
  ["Bob" 25 "San Francisco"]
Time travel queries...
Historical state (3 seconds ago):
  ["Alice" 30 "New York"]
  ["Bob" 25 "San Francisco"]
Current Alice: xtdb.api.XtdbDocument@afa4c1d6
Historical Alice: xtdb.api.XtdbDocument@94290537
```


