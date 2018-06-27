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
