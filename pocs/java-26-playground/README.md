### Build

```bash
./mvnw clean install
```

### Run

```bash
./run.sh
```

### Result

```
=== Java 26 Playground ===

AOT Object Caching Feature (JEP 516):
  Stores objects in GC-agnostic format using logical indices
  Works with any garbage collector (not just G1)
  Current GC: G1 Young Generation, G1 Concurrent GC, G1 Old Generation
  Usage: java -XX:AOTCacheOutput=app.aot -cp app.jar App

G1 GC Throughput Improvement (JEP 522):
  Second card table reduces synchronization overhead
  5-15% throughput improvement for reference-heavy workloads
  Max Memory: 30688 MB
  Total Memory: 32 MB
  Free Memory: 28 MB
  Available Processors: 16

HTTP/3 Response Status: 200
HTTP/3 Protocol Version: HTTP_3

PEM Encoded Public Key:
-----BEGIN PUBLIC KEY-----
MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8A...
PEM Encoded Private Key:
-----BEGIN PRIVATE KEY-----
MIIEvQIBADANBgkqhkiG9w0BAQEFAAS...
Decoded Public Key Algorithm: RSA

Structured Concurrency Results:
  Task-1 done
  Task-2 done
  Task-3 done

Lazy Constants Feature:
  Before first access - value not yet computed
  Computing lazy value...
  First access: Hello from LazyConstant!
  Second access (no recomputation): Hello from LazyConstant!
  Computing lazy number...
  Lazy number: 42

Primitive Pattern Matching:
  Switch on int:
    Room size 1 -> Toilet
    Room size 2 -> Bedroom
    Room size 30 -> Classroom
    Room size 500 -> Cinema
    Room size 7000 -> Stadium
    Room size 99 -> Unsupported: 99
  Switch on boolean:
    In tune=true -> Ready to play a song.
    In tune=false -> Let's take five!
  Primitive instanceof:
    Value 42 fits in a byte: 42
    Value 7 fits in a byte: 7

Final Field Reflection Feature (JEP 500):
  Original number of strings: 6
  After reflection mutation: 12
  WARNING: Final field was mutated via reflection (JDK 26 warns about this)

Applet API Removal (JEP 504):
  Removed: java.applet package
  Removed: javax.swing.JApplet
  Removed: java.beans.AppletInitializer
  Reason: Browser plugin support ended, security concerns
  Status: java.applet.Applet successfully removed
```
