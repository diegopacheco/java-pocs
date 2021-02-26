### Build 
```bash
./mvnw clean install 
```
### Run
```bash
./run.sh
```
### Test
Run KsqlDB client 
```bash
CREATE STREAM MY_STREAM (id VARCHAR, key VARCHAR, value VARCHAR)
  WITH (kafka_topic='my_stream', value_format='json', partitions=1);
  
INSERT INTO MY_STREAM (id, key, value) VALUES ('1', 'p1', 'Diego');
INSERT INTO MY_STREAM (id, key, value) VALUES ('2', 'p2', 'Gandalf');
INSERT INTO MY_STREAM (id, key, value) VALUES ('3', 'p3', 'Melina');
```