### Run

```bash
mvn rewrite:run
```

```
❯ mvn rewrite:run

[INFO] Scanning for projects...
[INFO] 
[INFO] ------------< org.springframework.samples:spring-petclinic >------------
[INFO] Building petclinic 1.5.1
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] >>> rewrite:5.39.0:run (default-cli) > process-test-classes @ spring-petclinic >>>
[INFO] 
[INFO] --- git-commit-id:2.2.6:revision (default) @ spring-petclinic ---
[INFO] dotGitDirectory /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/.git
[INFO] git.build.user.name diegopacheco
[INFO] git.build.user.email diego.pacheco.it@gmail.com
[INFO] git.branch master
[INFO] --always = true
[INFO] --dirty = -dirty
[INFO] --abbrev = 7
[INFO] Tag refs [[]]
[INFO] Created map: [{}]
[INFO] evalCommit is [7fcd2a8ffd4f1fc6ea936fe880803981359261f7]
[INFO] git.commit.id.describe 7fcd2a8
[INFO] git.commit.id 7fcd2a8ffd4f1fc6ea936fe880803981359261f7
[INFO] git.commit.id.abbrev 7fcd2a8
[INFO] git.dirty false
[INFO] git.commit.user.name diegopacheco
[INFO] git.commit.user.email diego.pacheco.it@gmail.com
[INFO] git.commit.message.full open re-write
[INFO] git.commit.message.short open re-write
[INFO] git.commit.time 2024-08-13T23:06:36-0700
[INFO] git.remote.origin.url https://github.com/diegopacheco/java-pocs.git
[INFO] git.tags 
[INFO] evalCommit is [7fcd2a8ffd4f1fc6ea936fe880803981359261f7]
[INFO] Tag refs [[]]
[INFO] Created map: [{}]
[INFO] git.closest.tag.name 
[INFO] evalCommit is [7fcd2a8ffd4f1fc6ea936fe880803981359261f7]
[INFO] Tag refs [[]]
[INFO] Created map: [{}]
[INFO] git.closest.tag.commit.count 
[INFO] git.total.commit.count 1902
[INFO] git.build.time 2024-08-13T23:07:54-0700
[INFO] git.build.version 1.5.1
[INFO] git.build.host 4winds
[INFO] git.commit.id.describe-short 7fcd2a8
[INFO] found property git.tags
[INFO] found property git.closest.tag.commit.count
[INFO] found property git.build.version
[INFO] found property git.commit.user.name
[INFO] found property git.commit.id.abbrev
[INFO] found property git.branch
[INFO] found property git.build.host
[INFO] found property git.commit.id.describe-short
[INFO] found property git.total.commit.count
[INFO] found property git.commit.id.describe
[INFO] found property git.build.user.email
[INFO] found property git.commit.id
[INFO] found property git.commit.message.short
[INFO] found property git.commit.user.email
[INFO] found property git.closest.tag.name
[INFO] found property git.commit.time
[INFO] found property git.build.time
[INFO] found property git.build.user.name
[INFO] found property git.dirty
[INFO] found property git.commit.message.full
[INFO] found property git.remote.origin.url
[INFO] Reading existing properties file [/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/target/classes/git.properties] (for module petclinic)...
[INFO] Writing properties file to [/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/target/classes/git.properties] (for module petclinic)...
[INFO] 
[INFO] --- spring-boot:2.1.18.RELEASE:build-info (default) @ spring-petclinic ---
[INFO] 
[INFO] --- wro4j:1.9.0:run (default) @ spring-petclinic ---
[INFO] /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/src/main/less
[INFO] Executing the mojo: 
[INFO] Wro4j Model path: /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/src/main/wro/wro.xml
[INFO] targetGroups: null
[INFO] minimize: true
[INFO] ignoreMissingResources: null
[INFO] parallelProcessing: false
[INFO] buildDirectory: /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/target
[INFO] destinationFolder: /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/target
[INFO] cssDestinationFolder: /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/target/classes/static/resources/css
[INFO] The following groups will be processed: [petclinic]
[INFO] folder: /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/target/classes/static/resources/css
[INFO] processing group: petclinic.css
[WARNING] Less warnings are:
[WARNING] 10:1 Cannot link source map. Css result location is not know and could not be deduced from input less source..
[INFO] file size: petclinic.css -> 152399 bytes
[INFO] /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/target/classes/static/resources/css/petclinic.css (152399 bytes)
[INFO] folder: /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/target
[INFO] processing group: petclinic.js
[INFO] 
[INFO] --- resources:3.1.0:resources (default-resources) @ spring-petclinic ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 2 resources
[INFO] Copying 35 resources
[INFO] 
[INFO] --- compiler:3.8.1:compile (default-compile) @ spring-petclinic ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 34 source files to /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/target/classes
[INFO] /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/src/main/java/org/springframework/samples/petclinic/model/Person.java: Some input files use or override a deprecated API.
[INFO] /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/src/main/java/org/springframework/samples/petclinic/model/Person.java: Recompile with -Xlint:deprecation for details.
[INFO] 
[INFO] --- resources:3.1.0:testResources (default-testResources) @ spring-petclinic ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/src/test/resources
[INFO] 
[INFO] --- compiler:3.8.1:testCompile (default-testCompile) @ spring-petclinic ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 11 source files to /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/target/test-classes
[INFO] /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/src/test/java/org/springframework/samples/petclinic/owner/PetTypeFormatterTests.java: /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/src/test/java/org/springframework/samples/petclinic/owner/PetTypeFormatterTests.java uses or overrides a deprecated API.
[INFO] /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/src/test/java/org/springframework/samples/petclinic/owner/PetTypeFormatterTests.java: Recompile with -Xlint:deprecation for details.
[INFO] 
[INFO] <<< rewrite:5.39.0:run (default-cli) < process-test-classes @ spring-petclinic <<<
[INFO] 
[INFO] 
[INFO] --- rewrite:5.39.0:run (default-cli) @ spring-petclinic ---
[INFO] Using active recipe(s) [org.openrewrite.java.OrderImports]
[INFO] Using active styles(s) []
[INFO] Validating active recipes...
[INFO] Project [petclinic] Resolving Poms...
[INFO] Project [petclinic] Parsing source files
[INFO] Running recipe(s)...
[WARNING] Changes have been made to pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/src/main/java/org/springframework/samples/petclinic/visit/VisitRepository.java by:
[WARNING]     org.openrewrite.java.OrderImports
[WARNING] Changes have been made to pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/src/main/java/org/springframework/samples/petclinic/visit/Visit.java by:
[WARNING]     org.openrewrite.java.OrderImports
[WARNING] Changes have been made to pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/src/main/java/org/springframework/samples/petclinic/owner/Owner.java by:
[WARNING]     org.openrewrite.java.OrderImports
[WARNING] Changes have been made to pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/src/main/java/org/springframework/samples/petclinic/owner/OwnerController.java by:
[WARNING]     org.openrewrite.java.OrderImports
[WARNING] Changes have been made to pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/src/main/java/org/springframework/samples/petclinic/owner/PetRepository.java by:
[WARNING]     org.openrewrite.java.OrderImports
[WARNING] Changes have been made to pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/src/main/java/org/springframework/samples/petclinic/owner/Pet.java by:
[WARNING]     org.openrewrite.java.OrderImports
[WARNING] Changes have been made to pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/src/main/java/org/springframework/samples/petclinic/owner/VisitController.java by:
[WARNING]     org.openrewrite.java.OrderImports
[WARNING] Changes have been made to pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/src/main/java/org/springframework/samples/petclinic/owner/PetType.java by:
[WARNING]     org.openrewrite.java.OrderImports
[WARNING] Changes have been made to pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/src/main/java/org/springframework/samples/petclinic/owner/OwnerRepository.java by:
[WARNING]     org.openrewrite.java.OrderImports
[WARNING] Changes have been made to pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/src/main/java/org/springframework/samples/petclinic/owner/PetTypeFormatter.java by:
[WARNING]     org.openrewrite.java.OrderImports
[WARNING] Changes have been made to pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/src/main/java/org/springframework/samples/petclinic/owner/PetController.java by:
[WARNING]     org.openrewrite.java.OrderImports
[WARNING] Changes have been made to pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/src/main/java/org/springframework/samples/petclinic/system/CacheConfig.java by:
[WARNING]     org.openrewrite.java.OrderImports
[WARNING] Changes have been made to pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/src/main/java/org/springframework/samples/petclinic/vet/Vet.java by:
[WARNING]     org.openrewrite.java.OrderImports
[WARNING] Changes have been made to pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/src/main/java/org/springframework/samples/petclinic/vet/Specialty.java by:
[WARNING]     org.openrewrite.java.OrderImports
[WARNING] Changes have been made to pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/src/main/java/org/springframework/samples/petclinic/vet/Vets.java by:
[WARNING]     org.openrewrite.java.OrderImports
[WARNING] Changes have been made to pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/src/main/java/org/springframework/samples/petclinic/vet/VetRepository.java by:
[WARNING]     org.openrewrite.java.OrderImports
[WARNING] Changes have been made to pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/src/main/java/org/springframework/samples/petclinic/model/Person.java by:
[WARNING]     org.openrewrite.java.OrderImports
[WARNING] Changes have been made to pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/src/main/java/org/springframework/samples/petclinic/model/BaseEntity.java by:
[WARNING]     org.openrewrite.java.OrderImports
[WARNING] Changes have been made to pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/src/test/java/org/springframework/samples/petclinic/service/EntityUtils.java by:
[WARNING]     org.openrewrite.java.OrderImports
[WARNING] Changes have been made to pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/src/test/java/org/springframework/samples/petclinic/service/ClinicServiceTests.java by:
[WARNING]     org.openrewrite.java.OrderImports
[WARNING] Changes have been made to pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/src/test/java/org/springframework/samples/petclinic/system/CrashControllerTests.java by:
[WARNING]     org.openrewrite.java.OrderImports
[WARNING] Changes have been made to pocs/open-rewrite-simple-poc/migrated/spring-petclinic-migration/src/test/java/org/springframework/samples/petclinic/model/ValidatorTests.java by:
[WARNING]     org.openrewrite.java.OrderImports
[WARNING] Please review and commit the results.
[WARNING] Estimate time saved: 1h 50m
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  52.822 s
[INFO] Finished at: 2024-08-13T23:08:40-07:00
[INFO] ------------------------------------------------------------------------
  /mnt/e/d/gi/d/java-pocs/p/open-r/migrated/spring-petclinic-migration   master !22 
```

### Results

* Compare `original` and `migrated` folder.
* Full diff in `migrated/results` folder.