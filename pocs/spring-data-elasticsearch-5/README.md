### Spring Data Elasticsearch

When the app boot up data is inserted into Elasticsearch.

### Versions

```
java: 23
Spring Boot: 3.4.x
Spring Data ES: 5.4.x
Elasticsearch: 8.10.x
```

### Build
```bash
./mvnw clean install
```

### Run ES 8

```bash
./run-es.sh
```

### Test Application on Browser

List all products
```
http://localhost:8080/api/products
```

```
[
  {
    "id": "1",
    "name": "Laptop",
    "description": "High-performance laptop",
    "price": 1299.99
  },
  {
    "id": "2",
    "name": "Smartphone",
    "description": "Latest model smartphone",
    "price": 899.99
  }
]
```

Get product by ID

```
 http://localhost:8080/api/products/1
```

```
{
  "id": "1",
  "name": "Laptop",
  "description": "High-performance laptop",
  "price": 1299.99
}
```

Searching via application rest endpoint using Spring Data ES under the hood

```
http://localhost:8080/api/products/search?name=Laptop
```

```
[
  {
    "id": "1",
    "name": "Laptop",
    "description": "High-performance laptop",
    "price": 1299.99
  }
]
```

Searching directly into ES 8

```
curl -s -X GET "http://localhost:9200/products/_search" -u elastic:changeme -H "Content-Type: application/json" -d'
{
  "query": {
    "match": {
      "name": "Laptop"
    }
  }
}' | jq .
```

```
{
  "took": 5,
  "timed_out": false,
  "_shards": {
    "total": 1,
    "successful": 1,
    "skipped": 0,
    "failed": 0
  },
  "hits": {
    "total": {
      "value": 1,
      "relation": "eq"
    },
    "max_score": 0.6931471,
    "hits": [
      {
        "_index": "products",
        "_id": "1",
        "_score": 0.6931471,
        "_source": {
          "_class": "com.github.diegopacheco.sandboxspring.model.Product",
          "id": "1",
          "name": "Laptop",
          "description": "High-performance laptop",
          "price": 1299.99
        }
      }
    ]
  }
}
```

Doing a more generic search 

```
❯ curl -s -X GET "http://localhost:9200/products/_search" -u elastic:changeme -H "Content-Type: application/json" -d'
{
  "query": {
    "query_string": {
      "default_field": "name",
      "query": "*a*"
    }
  }
}' | jq .
```

```
{
  "took": 4,
  "timed_out": false,
  "_shards": {
    "total": 1,
    "successful": 1,
    "skipped": 0,
    "failed": 0
  },
  "hits": {
    "total": {
      "value": 2,
      "relation": "eq"
    },
    "max_score": 1.0,
    "hits": [
      {
        "_index": "products",
        "_id": "1",
        "_score": 1.0,
        "_source": {
          "_class": "com.github.diegopacheco.sandboxspring.model.Product",
          "id": "1",
          "name": "Laptop",
          "description": "High-performance laptop",
          "price": 1299.99
        }
      },
      {
        "_index": "products",
        "_id": "2",
        "_score": 1.0,
        "_source": {
          "_class": "com.github.diegopacheco.sandboxspring.model.Product",
          "id": "2",
          "name": "Smartphone",
          "description": "Latest model smartphone",
          "price": 899.99
        }
      }
    ]
  }
}
```