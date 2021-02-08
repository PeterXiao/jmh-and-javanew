# Hotspot Compiler Difference?
This test highlights a compiler difference between JDK 8 and JDK 11 that exhibits slower performance with older code.

## Results

All test have been executed on Ubuntu 18.04, kernel 4.15, 64 bit on a Lenovo Thinkpad T450s, Intel(R) Core(TM) i7-5600U CPU @ 2.60GHz, 20 GB RAM.

The interesting part is the difference between `cpu_02a_StringTokenizer` and `cpu_03a_LightTokenizer` within the test on a particular JDK and in between JDKs. `cpu_03b_LightTokenizerArray`and `cpu_03c_LightTokenizerCharDelimiter`are just meant to aid debugging later on or help to get closer to the problem.

More documenatation within the source code of course.

### JDK 1.8.0_242, OpenJDK 64-Bit Server VM, 25.242-b08
```
Benchmark                            Mode  Cnt     Score     Error  Units
cpu_02a_StringTokenizer              avgt   10  1959.135 ± 193.704  ns/op
cpu_03a_LightTokenizer               avgt   10  1891.080 ± 112.096  ns/op
cpu_03b_LightTokenizerArray          avgt   10  1784.534 ±  27.250  ns/op
cpu_03c_LightTokenizerCharDelimiter  avgt   10  1850.560 ±  34.720  ns/op
```

### JDK 11.0.6, OpenJDK 64-Bit Server VM, 11.0.6+10
```
Benchmark                            Mode  Cnt     Score    Error  Units
cpu_02a_StringTokenizer              avgt   10  1960.939 ± 23.210  ns/op
cpu_03a_LightTokenizer               avgt   10  2388.414 ± 87.207  ns/op
cpu_03b_LightTokenizerArray          avgt   10  1742.801 ± 39.567  ns/op
cpu_03c_LightTokenizerCharDelimiter  avgt   10  2095.683 ± 34.275  ns/op
```
### JDK 15-ea, OpenJDK 64-Bit Server VM, 15-ea+12-431
```
Benchmark                            Mode  Cnt     Score     Error  Units
cpu_02a_StringTokenizer              avgt   10  1657.819 ±  25.612  ns/op
cpu_03a_LightTokenizer               avgt   10  2156.099 ±  59.667  ns/op
cpu_03b_LightTokenizerArray          avgt   10  1420.077 ±  52.796  ns/op
cpu_03c_LightTokenizerCharDelimiter  avgt   10  1860.914 ± 115.203  ns/op
```

## Execution
The tests have been executed with this command line:

```
mvn clean compile install
java -Xms2g -Xmx2g -XX:+UseG1GC -XX:+AlwaysPreTouch -jar target/benchmarks.jar LightStringTokenizerBenchmark
```


## More results 

### Macbook Pro 15" 2017, MacOS Mojave 10.14.6, 2,8 GHz Intel Core i7 @ 16 GB 2133 MHz LPDDR3, (Power cable attached)

#### JDK 11.0.1, OpenJDK 64-Bit Server VM, 11.0.1+13, 

```
Benchmark                                                          Mode  Cnt     Score     Error  Units
LightStringTokenizerBenchmark.cpu_02a_StringTokenizer              avgt   10  1306,780 ±  98,676  ns/op
LightStringTokenizerBenchmark.cpu_03a_LightTokenizer               avgt   10  1506,114 ± 140,924  ns/op
LightStringTokenizerBenchmark.cpu_03b_LightTokenizerArray          avgt   10  1055,453 ±  61,357  ns/op
LightStringTokenizerBenchmark.cpu_03c_LightTokenizerCharDelimiter  avgt   10  1248,843 ±  24,023  ns/op
```

#### JDK 1.8.0_202, OpenJDK 64-Bit Server VM, 25.202-b08

```
Benchmark                                                          Mode  Cnt     Score     Error  Units
LightStringTokenizerBenchmark.cpu_02a_StringTokenizer              avgt   10  1352,127 ±  48,014  ns/op
LightStringTokenizerBenchmark.cpu_03a_LightTokenizer               avgt   10  1323,923 ±  27,704  ns/op
LightStringTokenizerBenchmark.cpu_03b_LightTokenizerArray          avgt   10  1240,263 ±  93,318  ns/op
LightStringTokenizerBenchmark.cpu_03c_LightTokenizerCharDelimiter  avgt   10  1381,135 ± 170,458  ns/op
```
