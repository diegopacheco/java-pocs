### About

This is a simple Java application callind Rust as Dynamic Lib(so).
It uses the amazing JNR-FFI(https://github.com/jnr/jnr-ffi) same that JRuby uses.
makes so easy call FFI without JNI madness.

### Build
First go build Rust
```bash
cd doublelib/
cargo build --release
```
Now build and run Java
```bash
./mvnw clean install 
./run.sh
```

### Simple Benchmark
```bash
Rust lib loaded. 
Result from rust double_input:  60
Call took : 10261 ns
Calling Pure Java
Result from Java JavaDouble.it:  60
Call took : 285591 ns
```
