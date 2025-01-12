### Build 

```bash
./mvnw clean install 
```

### Problems, Smells and Anti-Patterns

1. IFs Sucks, they are procedural, IFs often lead to duplicated code and procedural code.
2. Enums Sucks! Enums segregate data and force IFs to happen. 
3. Avoid Enums, Avoid IFs, avoid procedural code, THINK OO!

### Solutions

1. Use Polymorphism, use OO, use interfaces, use abstract classes, use design patterns.
2. Use Proper Datastructures and/or Design Patterns

### How do we detect bad code?

1. When you see IFs/Switches and Enums.
2. When you see duplicated code but just 1-2 things are changing.
3. When you see a lot of procedural code.

### Why Enums Sucks?

1. Enums are not OO, very often lead to procedural code(people need todo IFs and 
propagate code to many places rather than center on a class).
2. Enums are not flexible, you can't extend to do sub-typing. Can't do a proper TypeSystem with them.
3. Enums has fixed set of values cannot be changed at runtime.
4. Enums can have awful serialization/deserialization nasty issues, what if you try to load a value from DB is not present on enum? 
what happens is a nightmare.
5. Enums are for limited use cases (fixed, immutable lisr of values i.e days of the week).

### References

1. Highly recommend read: https://github.com/diegopacheco/java-pocs/tree/master/pocs/if-alternatives-fun
2. Elegant Object vol1: https://github.com/diegopacheco/Elegant.Objects
3. Elegant Object vol2: https://github.com/diegopacheco/Elegant.Objects.vol.2 