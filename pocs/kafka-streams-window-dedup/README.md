### Build 
```bash
./mvnw clean install 
```
### Version
Java: 21 <BR/>
Kafka: kafka_2.13-3.6.2 <BR/>
Zookeeper: zookeeper-3.4.14 <BR/>

### KafkaStream Code
```java
  KTable<Windowed<String>, String> deduplicated = source
            .flatMapValues(value -> Arrays.asList(pattern.split(value.toLowerCase())))
            .groupBy((key, word) -> word)
            .windowedBy(TimeWindows.of(Duration.ofSeconds(30)))
            .reduce((value1, value2) -> value1); // Deduplicate by keeping the first occurrence
```

### Result
<img src="result-working.png" />