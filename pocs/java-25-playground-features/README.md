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