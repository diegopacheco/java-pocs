### Rationale

This POC has some different ways we can do loops and 
some tradeoffs and food for taught for each 
style and approach.

### Alternatives

C Style
 * Classical for
 * Common to many languages
 * great for one pointer and simple collection iteration
 * Works well for multiple processing at once

While Style
 * Good for multiple pointers
 * Good when you are not doing a "linear" loop
 * Clean

ForEach
 * Evolution of C-Style
 * Simplify the initialization and increment
 * No Help for multiple pointers 

Iterator
 * The way to go with collections
 * When you create your own DS is how you can loop over
 * Avoid when you dont need is a bit more code

Iterable
 * IS the syntax sugar for ForEach
 * You can make all your collections/DS use for each by implementing it
 * Can make "range" like python, go, rust in Java

Recursion
 * More complex
 * usually done with 2 functions
 * IF dont have 2 functions need to push complexity to caller
 * Languages that dont have tail recursion - is a bad idea and slow
 * More complex

Stream
 * "Functional" Style in java
 * Deriving (hidden loops) like Loki :-)
 * Slower, can be more complex

Did you know
 * Several things you, methods you call do loops under the hood
 * Always look the source code

### Build 
```bash
./mvnw clean install 
```
