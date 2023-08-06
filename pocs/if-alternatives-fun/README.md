### Build 
```bash
./mvnw clean install 
```

### How to handle decisions?

9 different techniques to handle branches:
* IFs
* Switch
* SCM branches
* Maps
* Enums
* IF Objects
* Filters
* Reflection and InstanceOf
* Type System + Polymorphism

### Branches

* IFs
  * Pros: Fast, simple to do
  * Cons: Harder to understand, more verbose
* Switch
  * Pros: Easier to understand, more compact than ifs
  * CONS: Requires IFs in some scenarios
* SCM branches (git branches, svn branches, mercurial(hg) branches)
  * PROS: Might be the only solution (lack of BC) 
  * CONS: Harder to maintain, is a bit more obscure 

### Elegant IFs

Loose some performance

* Maps
  * PROS: Elegant, compact, concise
  * CONS: Slower, Breaks type system (Runtime Eval)
* Enums
  * PROS: Concise, Type System
  * CONS: Break type system (Runtime eval) - Sucks with serialization, DB loads
* IF Objects
  * PROS: 
  * CONS:  
* Predicates, Suppliers and Functions: 
  * PROS:  
  * CONS: 

### Polymorphism + Type System

Use the language and proper OO Design

* Reflection and InstanceOf
  * PROS: 
  * CONS: 
* Type System + Polymorphism
  * PROS: 
  * CONS:  