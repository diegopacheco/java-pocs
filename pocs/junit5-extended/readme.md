## Dont use Inhehitance in tests

This is a very recommended reading

* https://www.petrikainulainen.net/programming/unit-testing/3-reasons-why-we-should-not-use-inheritance-in-our-tests/
* https://www.petrikainulainen.net/programming/testing/writing-clean-tests-it-starts-from-the-configuration/

## Take Aways

* We are using Junit 5(Jupiter API) here https://junit.org/junit5/docs/current/user-guide/
* Dont use Inheritance
* Tests are versionated by Package -> https://github.com/diegopacheco/java-pocs/tree/master/pocs/junit5-extended/src/test/java/com/github/diegopacheco/sandbox/java/service/test
* All common and resuable code goes here: https://github.com/diegopacheco/java-pocs/blob/master/pocs/junit5-extended/src/test/java/com/github/diegopacheco/sandbox/java/service/test/DataServiceTestConfig.java
* DataServiceTestConfig should not have assertions
* Suites was removed in Junit 5, Its possible to use backward compatibility but is better use TAGS now.

## Running with Gradle

We need to make sue we are using gradle >= 4.6 (4.7 or highther would be even better).</BR>
In gradle.build we need configure to use the Junit 5 engine and print more info.
```grovy
test {
    useJUnitPlatform {
        includeTags 'v1x', 'v2x'
        includeEngines 'junit-jupiter'
    }
    failFast = true
    testLogging {
        events 'PASSED', 'FAILED', 'SKIPPED'
    }
    afterSuite { desc, result ->
        if (!desc.parent) {
            println "\nTest result: ${result.resultType}"
            println "Test summary: ${result.testCount} tests, " +
                    "${result.successfulTestCount} succeeded, " +
                    "${result.failedTestCount} failed, " +
                    "${result.skippedTestCount} skipped"
        }
    }
}
```
So we can run: $ ./gradlew cleanTest test
