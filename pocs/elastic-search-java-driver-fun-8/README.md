Fun with https://www.elastic.co/guide/en/elasticsearch/reference/current/mapping-source-field.html

### Build 
```bash
./mvnw clean install 
```
### Console sample
```bash
curl -X PUT "localhost:9200/posts?pretty" -H 'Content-Type: application/json' -d'
{
  "mappings": {
    "_source": {
      "includes": [
        "*.postDate",
        "*.message"
      ],
      "excludes": [
        "*.user"
      ]
    }
  }
}
```
### Search all
```bash
curl localhost:9200/posts/_search | jq . 
```