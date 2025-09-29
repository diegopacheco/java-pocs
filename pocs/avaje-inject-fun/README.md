### Build 

```bash
./mvnw clean install 
```

### Result

```
BeanScope{BeanMap{{io.avaje.inject.events.spi.DObserverManager=[Bean{source=io.avaje.inject.DBeanScopeBuilder$$Lambda/0x00001fff01045800@6ae40994, name='null', priority=2147483647, sourceModule=null}], io.avaje.inject.events.ObserverManager=[Bean{source=io.avaje.inject.DBeanScopeBuilder$$Lambda/0x00001fff01045800@6ae40994, name='null', priority=2147483647, sourceModule=null}], com.example.DependencyClass=[Bean{source=com.example.DependencyClass@4e515669, name='null', priority=0, sourceModule=class com.example.ExampleModule}], com.example.ExampleFactory=[Bean{source=com.example.ExampleFactory@17d10166, name='null', priority=0, sourceModule=class com.example.ExampleModule}], com.example.DependencyClass2=[Bean{source=com.example.DependencyClass2@1b9e1916, name='null', priority=0, sourceModule=class com.example.ExampleModule}], com.example.Example=[Bean{source=com.example.Example@ba8a1dc, name='null', priority=0, sourceModule=class com.example.ExampleModule}]}}}
com.example.Example@ba8a1dc
```


