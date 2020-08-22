### Build 
```bash
./mvnw clean install 
```
### Limitations

using src/test/resources/mockito-extensions/org.mockito.plugins.MockMaker: true. 
 * You can mock final classes
 * You can mock final methods
 * You can mock final methods with overrides
 
you can't:
 * mock *static final* methods
 
PS: Mockito 2 will allow mock static final.