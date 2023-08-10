# IF Alternatives

### Disclaimer

Think carefully before applying this techniques like there is no tomorrow!
<img src="wisdom.jpg" width="550" ></img>

Branches, IFs, Decisions all the same thing. I'm not saying never 
ever do simple IFs anymore and just do reflections all time. However,
some problems might justify different techniques.

## Rationale

There are many ways we can handle decisions, from the simple *if* in the 
code to a generic service with admin interface using a database.
There are many ways we can express deciions, our decision can be rooted in different schools of tought like:
* Procedural Style - C language style
* Object Oriented - DDD, Pure Objects, Elegant Objects
* Generic - using generic data structures and dynamic tecniques

The tradeoffs go from compile time and type systems to runtime and 
dynamic programing. Such chooses to some degree are a matter of taste and preference. 
IMHO Type systems and compilers are better because reduce the 
amount of test we need todo and increase the feedback loop.

You always need to think if the cost and complexity of the solution is 
really worth it to use the technique, there is no right or wrong 
just tradeoffs.

### How to handle decisions(ifs) ?

13 different techniques to handle branches:<br/>
```
Basic Branches
 * IFs
 * Switch
 * SCM branches
Generic Options
 * Enums
 * Maps
 * Properties
 * Reflection
Annotations
 * Annotations 
Elegant Options
 * IF Objects
 * Functional
 * Composable Decorators
Polymorphism + Type System
 * Reflection and InstanceOf
 * Type System + Polymorphism
```

### Basic Branches

* IFs
  * Pros: Fast, simple to do
  * Cons: Harder to understand, more verbose
* Switch
  * Pros: Easier to understand, more compact than ifs
  * CONS: Requires IFs in some scenarios
* SCM branches (git branches, svn branches, mercurial(hg) branches)
  * PROS: Might be the only solution (lack of BC) 
  * CONS: Harder to maintain, is a bit more obscure 

### Generic Options

* Enums
  * PROS: Concise, Type System
  * CONS: Break type system (Runtime eval) - Sucks with serialization, DB loads
* Maps
  * PROS: Elegant, compact, concise
  * CONS: Slower, Breaks type system (Runtime Eval)
* Properties:
  * PROS: Generic Code 
  * CONS: Depends on disk now, dont work well for embedded jars (libraries)
* Reflection
  * PROS: Generic
  * CONS: Slower, Obscure, Complex

### Annotations

* Annotations
  * PROS: Declarative, Generic - Has IFs but code won't grow.
  * CONS: More complexity - Cache, Runtime only 

### Elegant Options

Loose some performance

* IF Objects
  * PROS: Concise, Good Code Readability
  * CONS: Uses more memory (more objects)
* Functional: (Predicates, Suppliers and Functions) 
  * PROS: Greater reuse: Granular Functions, Functional Style 
  * CONS: More Complex, Still has IFs
* Composable Decorator (from Elegant Objects)
  * PROS: Elegant Pure OOP Style
  * CONS: More memory usage, a bit more complex 

### Polymorphism + Type System

Use the language and proper OO Design

* Reflection and InstanceOf
  * PROS: More elegant
  * CONS: A bit more complex, Break the Type System - instanceOf is resolved at runtime
* Type System + Polymorphism
  * PROS: Best solution, Simple, OO, Fast, Elegant
  * CONS: Has the IFs(Factory no way to avoid it) 


### Build
```bash
./mvnw clean install 
```