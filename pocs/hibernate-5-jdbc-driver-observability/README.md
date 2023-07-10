### Build 
```bash
./mvnw clean install 
```

### How to run
```bash
./run-mysq-5.7-podman.sh
./create-db.sh
curl http://localhost:8080/all
```
```json
[
  {
    "id": 1,
    "name": "Person0",
    "email": "contant_email0@gmail.com",
    "phone": "415-1234-120"
  },
  {
    "id": 2,
    "name": "Person1",
    "email": "contant_email1@gmail.com",
    "phone": "415-1234-121"
  },
  {
    "id": 3,
    "name": "Person2",
    "email": "contant_email2@gmail.com",
    "phone": "415-1234-122"
  },
  {
    "id": 4,
    "name": "Person3",
    "email": "contant_email3@gmail.com",
    "phone": "415-1234-123"
  },
  {
    "id": 5,
    "name": "Person4",
    "email": "contant_email4@gmail.com",
    "phone": "415-1234-124"
  },
  {
    "id": 6,
    "name": "Person5",
    "email": "contant_email5@gmail.com",
    "phone": "415-1234-125"
  },
  {
    "id": 7,
    "name": "Person6",
    "email": "contant_email6@gmail.com",
    "phone": "415-1234-126"
  },
  {
    "id": 8,
    "name": "Person7",
    "email": "contant_email7@gmail.com",
    "phone": "415-1234-127"
  },
  {
    "id": 9,
    "name": "Person8",
    "email": "contant_email8@gmail.com",
    "phone": "415-1234-128"
  },
  {
    "id": 10,
    "name": "Person9",
    "email": "contant_email9@gmail.com",
    "phone": "415-1234-129"
  }
]
```

### SQL Metrics
The MetricsManager only reads the queue and process metrics in every *30s*
```bash
curl http://localhost:8080/metrics
```
```json
{
  "connection.count": "10",
  "tables": "[my_table_sequence, Contact]",
  "tables.write": "[Contact]",
  "table.Contact.read": "1",
  "table.Contact.write": "20",
  "table.my_table_sequence.read": "2"
}
```
JSON explained:
* connection.count: Total SQL connections open. 
* tables: All tables that the application is using for real
* tables.write: All tables that have inserts
* table.$TABLE_NAME.read: count of total reads per $TABLE_NAME
* table.$TABLE_NAME.write: count of total writes per $TABLE_NAME

### Benchmarks
Using standard MySQL Driver
```
Benchmark 10  in: 59 ms
Benchmark 100 in: 467 ms
Benchmark 1k  in: 3692 ms
Benchmark 10k in: 28555 ms
```
Using Observability Driver + standard MySQL Driver
```
Benchmark 10  in: 51 ms
Benchmark 100 in: 565 ms
Benchmark 1k  in: 3456 ms
Benchmark 10k in: 28117 ms
```