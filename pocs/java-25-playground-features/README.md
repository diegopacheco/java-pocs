# Java 25

```
470:	PEM Encodings of Cryptographic Objects (Preview)
502:	Stable Values (Preview)
503:	Remove the 32-bit x86 Port
505:	Structured Concurrency (Fifth Preview)
506:	Scoped Values
507:	Primitive Types in Patterns, instanceof, and switch (Third Preview)
508:	Vector API (Tenth Incubator)
509:	JFR CPU-Time Profiling (Experimental)
510:	Key Derivation Function API
511:	Module Import Declarations
512:	Compact Source Files and Instance Main Methods
513:	Flexible Constructor Bodies
514:	Ahead-of-Time Command-Line Ergonomics
515:	Ahead-of-Time Method Profiling
518:	JFR Cooperative Sampling
519:	Compact Object Headers
520:	JFR Method Timing & Tracing
521:	Generational Shenandoah
```

https://openjdk.org/projects/jdk/25/

### Build

```bash
./mvnw clean install 
```

### Result

java -version
```
❯ java -version
openjdk version "25" 2025-09-16 LTS
OpenJDK Runtime Environment Zulu25.28+85-CA (build 25+36-LTS)
OpenJDK 64-Bit Server VM Zulu25.28+85-CA (build 25+36-LTS, mixed mode, sharing)
```

./run.sh
```

```

### Java 25 on IntelliJ

<img src="intellij-java-25.png" />

### CPU Profile

```
❯ ./profile-cpu.sh com.github.diegopacheco.java25.features.VectorAPI
Using execution sampling (CPU-time profiling not supported on this platform)
WARNING: Using incubator modules: jdk.incubator.vector
[0.144s][info][jfr,startup] Started recording 1. The result will be written to:
[0.144s][info][jfr,startup]
[0.144s][info][jfr,startup] /Users/diegopacheco/Documents/git/diegopacheco/java-pocs/pocs/java-25-playground-features/cpu-profile.jfr
Vector API Test Starting...
Species length: 4
Input a: [1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0]
Input b: [2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0]
Result: [6.0, 10.0, 14.0, 18.0, 22.0, 26.0, 30.0, 34.0]
Profile saved to: cpu-profile.jfr
View with: jfr view hot-methods cpu-profile.jfr
❯ jfr view hot-methods cpu-profile.jfr

                       Java Methods that Execute the Most

Method                                                          Samples Percent
--------------------------------------------------------------- ------- -------
java.lang.invoke.MemberName.asSpecial()                               1 100.00%
```

### Mkethod Timing

```
❯ ./jfr-method-timing.sh
=== JFR Method Timing & Tracing ===
Method Timing - measuring constructor performance:
[0.158s][info][jfr,startup] Started recording 1. No limit specified, using maxsize=250MB as default.
[0.158s][info][jfr,startup]
[0.158s][info][jfr,startup] Use jcmd 37967 JFR.dump name=1 to copy recording data to file.
Age: 25, Department: Engineering

No events found for 'Method Timing'.
Method Tracing - tracking all constructors:
./jfr-method-timing.sh: line 13: init: No such file or directory
jfr view: could not open file /Users/diegopacheco/Documents/git/diegopacheco/java-pocs/pocs/java-25-playground-features/trace.jfr (No such file or directory)
Combined Timing & Tracing - all methods in target class:
[0.192s][info][jfr,startup] Started recording 1. No limit specified, using maxsize=250MB as default.
[0.192s][info][jfr,startup]
[0.192s][info][jfr,startup] Use jcmd 37971 JFR.dump name=1 to copy recording data to file.
Age: 25, Department: Engineering

                                                     Method Timing

Timed Method                                                         Invocations Minimum Time Average Time Maximum Time
-------------------------------------------------------------------- ----------- ------------ ------------ ------------
com.github.diegopacheco.java25.features.FlexibleConstructorBodies...           1  1.100000 ms  1.100000 ms  1.100000 ms
com.github.diegopacheco.java25.features.FlexibleConstructorBodies...           0          N/A          N/A          N/A
jfr view: Could not find a view or an event type named method-trace
JFR files created:
-rw-r--r--@ 1 diegopacheco  staff  391075 Sep 17 00:31 combined.jfr
-rw-r--r--@ 1 diegopacheco  staff  408869 Sep 16 23:57 cpu-profile.jfr
-rw-r--r--@ 1 diegopacheco  staff  391426 Sep 17 00:31 timing.jfr
```