### Build 

```bash
./mvnw clean install 
```

### Result

```bash
./test.sh
```

```
[INFO] --- surefire:3.5.2:test (default-test) @ java-25-junit-tag-control ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO]
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running NonBadTestSuite
[INFO] Running CalculatorTest
[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.015 s -- in CalculatorTest
[INFO] Tests run: 0, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.031 s -- in NonBadTestSuite
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.709 s
[INFO] Finished at: 2025-10-10T22:36:13-07:00
[INFO] ------------------------------------------------------------------------
```