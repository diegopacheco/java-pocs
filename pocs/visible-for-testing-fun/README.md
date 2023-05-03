### Build 
```bash
./mvnw clean install 
```

### Some Thoughts

The main tradeoffs here is how much we can protect the solution in sense of:
* Encapsulation
* Information Hiding
* Cohesion
* Loosing Coupling

But at the same time
* Be testable
* Do not need crazy mocking

What options do we have here?

```
1. Make it public access normaly
2. Make it private access with reflection
3. Make it package protected or protected
4. Change the Design so is testable
```

#### 1. Make it public access normally

When public makes sense, and is the right call. 
The information published is the right one and no tricks needs to be performed.
Does not work for all cases, unfortunately.

#### 2. Make it private access with reflection

This is a good option, although is a bit ugly. because you do the right design
and you also protect and ecanpsulate the data and logic, however you cannot test
but you also prevent abuses to some degree. People can always do reflections to abuse 
or hack the memory. But this makes only the test do the unlgy part not the code.

#### 3. Make it package protected or protected

This is what I design for this solution, Package protected is not public but still can be abused from the very same package
Java does not prevent you to create packages so is weak. i.e you can create any package anywhere just like how I did with the test.

#### 4. Change the Design so is testable

Can be okay, sometimes is the right call but might require bigger refactoring and might be cost to migrate all consumers and make sure is a smooth change.
You need to because to make weaker in sense of encapsulation now. So there are tradeoffs here, this is a good option.
