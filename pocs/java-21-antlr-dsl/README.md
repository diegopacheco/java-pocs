### Build 
```bash
./mvnw clean install 
```
### Generate source from Grammar

```bash
./generate-antlt-sources.sh
```
```
❯ ./generate-antlt-sources.sh
[INFO] Scanning for projects...
[INFO] 
[INFO] ---------< com.github.diegopacheco.javapocs:java-21-antlr-dsl >---------
[INFO] Building java-21-antlr-dsl 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- clean:3.2.0:clean (default-clean) @ java-21-antlr-dsl ---
[INFO] Deleting /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/java-21-antlr-dsl/target
[INFO] 
[INFO] --- antlr4:4.13.2:antlr4 (default) @ java-21-antlr-dsl ---
[INFO] ANTLR 4: Processing source directory /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/java-21-antlr-dsl/src/main/antlr4
[INFO] Processing grammar: MathOperations.g4
[INFO] 
[INFO] --- build-helper:3.2.0:add-source (add-source) @ java-21-antlr-dsl ---
[INFO] Source directory: /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/java-21-antlr-dsl/target/generated-sources/antlr4 added.
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.062 s
[INFO] Finished at: 2024-12-20T00:27:12-08:00
[INFO] ------------------------------------------------------------------------
```

### Result

```
Input: 10 plus 10 Result == 20
Input: 200 divided by 200 Result == 1
Input: 500 plus 10 minus 1 Result == 509
Input: 20 multiply by 2 plus 25 Result == 65
Input: 10 plus 10 add 6 Result == 26
```