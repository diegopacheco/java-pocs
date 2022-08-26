### Build 
```bash
./mvnw clean install 
```
## Results
```bash
Person{name='Person1', email='person@people.com', dob='2020/01/01'}
Bench Unsafe ************
Unsafe Benchmark 419537 ns
Unsafe Benchmark 9661 ns
Unsafe Benchmark 8496 ns
Unsafe Benchmark 27927 ns
Unsafe Benchmark 8486 ns
Unsafe Benchmark 8690 ns
Unsafe Benchmark 8830 ns
Unsafe Benchmark 8452 ns
Unsafe Benchmark 10162 ns
Unsafe Benchmark 10836 ns
PersonV2{name='Person1', email='person@people.com'}
AVG(ns): 1083 ns
Bench Reflections ************
Reflections Benchmark 175466 ns
Reflections Benchmark 10575 ns
Reflections Benchmark 9950 ns
Reflections Benchmark 9970 ns
Reflections Benchmark 9650 ns
Reflections Benchmark 8783 ns
Reflections Benchmark 8540 ns
Reflections Benchmark 11003 ns
Reflections Benchmark 5885 ns
Reflections Benchmark 5732 ns
PersonV2{name='Person1', email='person@people.com'}
AVG(ns): 25555 ns
```