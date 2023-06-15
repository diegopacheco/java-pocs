### About

This is a simple Java application calling Zig as Dynamic Lib(so).
It uses the amazing JNR-FFI(https://github.com/jnr/jnr-ffi) same that JRuby uses.
makes so easy call FFI without JNI madness.

### Build
First go build Zig
```bash
cd zig-add-lib/
./build.sh
```
Now build and run Java
```bash
./mvnw clean install 
./run.sh
```

### Simple Benchmark
```bash
Zig lib loaded. 
Result from Zig zig_add:  70
Call took : 19521 ns
Calling Pure Java
Result from Java JavaAdd.add:  70
Call took : 346746 ns
```