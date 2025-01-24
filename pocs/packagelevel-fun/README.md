### Build 
```bash
./mvnw clean install 
```

### Result

package-info.java
```
@SecureLogging
package com.github.diegopacheco.packagelevelfun.dao;
```

Running the main class:
```
[DEBUG]: {name=*****}
[DEBUG]: {ssn=###-##-####}
[DEBUG]: {email=*****@*****}
[DEBUG]: {name=John Doe, email=mail1@gmail.com, ssn=000-00-0000}
```

### Rationale

Trying to show usage of Package objects in Java.
The Main utility is that we can add annotations on the package level rather than put in all classes.
This POC shows:
* How to use Package Object with Annotations
* How to read info from runtime/stack
* Simple Fuzzy Matching

### Pros

1. Avoid misconfiguration of missing @Secure annotation on classes, and also avoid duplication of the same annotation on multiple classes.

### Cons

1. So far solution is complex and expensive, it would be better off on a startup or agent level solution.
2. It's a bit implicit and non-obvious
3. Hard to test because consider the runtime packages and stack

### Future Ideas of improvement

1. Add cache for stacktrace
2. Pre-process method names on start
3. Create a proxy rather than a Logger class
4. Move it to agentic-level