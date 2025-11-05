### Build 

```bash
./mvnw clean install 
```

### Result

```
First test class (RedisStringOperationsTest):
- Container ID before start: null (new container being created)
- Container ID after start: e246bb793527dd9e38b57333dfa0b79cc571c928adc1006d8a5ed63c248d7f05
- Time elapsed: 2.059s (includes container startup)

Second test class (RedisHashOperationsTest):
- Container ID before start: e246bb793527dd9e38b57333dfa0b79cc571c928adc1006d8a5ed63c248d7f05 (same
container!)
- Container ID after start: e246bb793527dd9e38b57333dfa0b79cc571c928adc1006d8a5ed63c248d7f05
- Time elapsed: 0.029s (just reusing existing container)

Third test class (RedisListOperationsTest):
- Container ID before start: e246bb793527dd9e38b57333dfa0b79cc571c928adc1006d8a5ed63c248d7f05 (same
container!)
- Container ID after start: e246bb793527dd9e38b57333dfa0b79cc571c928adc1006d8a5ed63c248d7f05
- Time elapsed: 0.017s (just reusing existing container)

The logs clearly demonstrate that:
1. The container starts only once during the first test class
2. All subsequent test classes reuse the same container (same Container ID)
3. Performance improvement is significant: first test ~2s vs subsequent tests ~0.02s
```


