### Build 
```bash
./mvnw clean install 
```

### How to run
```bash
./run-mysq-5.7-podman.sh
./create-dd.sh
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
```bash
curl http://localhost:8080/metrics
```
```json
{
  "tables.write": "[Contact]",
  "tables": "[my_table_sequence, Contact]",
  "table.write.count": "10",
  "table.count": "12"
}
```