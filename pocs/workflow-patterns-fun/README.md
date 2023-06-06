### Build 
```bash
./mvnw clean install 
```

### Workflow Patterns in Java

Imagine you need to run several pieces of code in form of tasks ie:
 * Task 1 - Fetch Stock price of Company X
 * Task 2 - Fetch Social Media Sentiment Analysis for Company X
 * Task 3 - Check Google for Aquisitions of Company X
 * Task 4 - Decide if Buy or Sell Stock

Now imagine that each stock, might fail anytime and you need to resume the steps
or imagine you might want to stop each stop on the db so you can resume where you
stoped. Now can we design a code that has the properties?
* Resumable (start from scracht or where we stop last time)
* Declarative, Composable, Elegant 
* Easy to undertsand and Mantainable
* Avoid bad Duplication and Complexity

Were is the implementation using 3 different Design Patterns and Java:
 * Chain of Responsibility
 * Builder
 * Decorator

### Basic Patterns Reference

Chain of Responsibility: https://refactoring.guru/design-patterns/chain-of-responsibility <br/>
Builder: https://refactoring.guru/design-patterns/builder <br/>
Decorator: https://refactoring.guru/design-patterns/decorator <br/>

### Other Options to consider:

* Template Method Pattern
* Apache Camel
* AWS Lambda + Step Functions
* Spring StateMachine
