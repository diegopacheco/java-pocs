### Build 
```bash
./mvnw clean install 
```
### Shell
```bash
mvn groovy:shell
```
```bash
groovy:000> . ./src/main/groovy/Person.groovy 
===> true
groovy:000> Person.std                        
===> Person{ name: John email: j@j.com job: code }
groovy:000> . ./src/main/groovy/main.groovy   
===> [import Person]
works from Groovy! Person{ name: John email: j@j.com job: code }
===> null
groovy:000> import Week
===> [import Person, import Week]
groovy:000> Week.WEEKEND
===> WEEKEND
groovy:000>
```
