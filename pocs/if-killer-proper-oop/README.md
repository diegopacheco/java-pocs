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

### References

1. Highly recommend read: https://github.com/diegopacheco/java-pocs/tree/master/pocs/if-alternatives-fun