### Build 
```bash
./mvnw clean install 
```

### How to handle decisions?

10 different techniques to handle branches:<br/>
```
Basic Branches
 * IFs
 * Switch
 * SCM branches
Elegant Options
 * Maps
 * Enums
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

### Elegant Options

Loose some performance

* Maps
  * PROS: Elegant, compact, concise
  * CONS: Slower, Breaks type system (Runtime Eval)
* Enums
  * PROS: Concise, Type System
  * CONS: Break type system (Runtime eval) - Sucks with serialization, DB loads
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
  * PROS: 
  * CONS:  