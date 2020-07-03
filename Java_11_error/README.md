# Java11 Examples

This repository contains some new feature code after Java8, which runs on top of JDK 11.

- [var](src/main/java/io/github/biezhi/java11/var)
- [string](src/main/java/io/github/biezhi/java11/string)
- [collections](src/main/java/io/github/biezhi/java11/collections)
- [interface](src/main/java/io/github/biezhi/java11/interfaces)
- [http](src/main/java/io/github/biezhi/java11/http)
- [processor](src/main/java/io/github/biezhi/java11/processor)
- [try with resources](src/main/java/io/github/biezhi/java11/trywithresources)
- [files](src/main/java/io/github/biezhi/java11/files)
- [time](src/main/java/io/github/biezhi/java11/time)
- [single file](src/main/java/io/github/biezhi/java11/singlefile)

# License

[MIT](LICENSE)

单元测试/接口测试关注
模块接口测试

　　通过所测模块的数据流进行测试。调用所测模块时的输入参数与模块的形式参数的个数、属性和顺序是否匹配。 

局部数据结构测试

　　局部数据结构是为了保证临时存储在模块内的数据在程序执行过程中完整、正确、模块的局部数据结构往往是错误的根源。 

路径测试

　　对模块中重要的执行路径进行测试。 

错误处理测试 

　　比较完善的模块设计要求能遇见出错的条件，并设置适当的出错处理，以便在一旦程序出错时，能对出错程序重做安排，保证其逻辑上的正确性。 

边界条件测试 

　　软件经常在便捷上失效，边界条件测试是一项基础测试，也是后面系统测试中的功能测试的重点。 


细节，魔鬼在细节

Java SE 11 = 55,
Java SE 10 = 54,
Java SE 9 = 53,
Java SE 8 = 52,
Java SE 7 = 51,
Java SE 6.0 = 50,
Java SE 5.0 = 49,
JDK 1.4 = 48,
JDK 1.3 = 47,
JDK 1.2 = 46,
JDK 1.1 = 45

            │ Class │ Package │ Subclass │ Subclass │ World
            │       │         │(same pkg)│(diff pkg)│ 
────────────┼───────┼─────────┼──────────┼──────────┼────────
public      │   +   │    +    │    +     │     +    │   +     
────────────┼───────┼─────────┼──────────┼──────────┼────────
protected   │   +   │    +    │    +     │     +    │         
────────────┼───────┼─────────┼──────────┼──────────┼────────
no modifier │   +   │    +    │    +     │          │    
────────────┼───────┼─────────┼──────────┼──────────┼────────
private     │   +   │         │          │          │    

+ : accessible
blank : not accessible


761
down vote
To summarize the other answers and combine them with what I know, I found 10 main ways to do this (see below). Also, I wrote some performance tests (see results below). For example, if we want to find the sum of all of the keys and values of a map, we can write:

Using iterator and Map.Entry

long i = 0;
Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
while (it.hasNext()) {
    Map.Entry<Integer, Integer> pair = it.next();
    i += pair.getKey() + pair.getValue();
}
Using foreach and Map.Entry

long i = 0;
for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
    i += pair.getKey() + pair.getValue();
}
Using forEach from Java 8

final long[] i = {0};
map.forEach((k, v) -> i[0] += k + v);
Using keySet and foreach

long i = 0;
for (Integer key : map.keySet()) {
    i += key + map.get(key);
}
Using keySet and iterator

long i = 0;
Iterator<Integer> itr2 = map.keySet().iterator();
while (itr2.hasNext()) {
    Integer key = itr2.next();
    i += key + map.get(key);
}
Using for and Map.Entry

long i = 0;
for (Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator(); entries.hasNext(); ) {
    Map.Entry<Integer, Integer> entry = entries.next();
    i += entry.getKey() + entry.getValue();
}
Using the Java 8 Stream API

final long[] i = {0};
map.entrySet().stream().forEach(e -> i[0] += e.getKey() + e.getValue());
Using the Java 8 Stream API parallel

final long[] i = {0};
map.entrySet().stream().parallel().forEach(e -> i[0] += e.getKey() + e.getValue());
Using IterableMap of Apache Collections

long i = 0;
MapIterator<Integer, Integer> it = iterableMap.mapIterator();
while (it.hasNext()) {
    i += it.next() + it.getValue();
}
Using MutableMap of Eclipse (CS) collections

final long[] i = {0};
mutableMap.forEachKeyValue((key, value) -> {
    i[0] += key + value;
});


常用的 Lombok 注解：

@Getter：自动生成所有属性的 getter 方法。

@Setter：自动生成所有属性的 setter 方法。

@ToString：自动生成 toString() 方法。

@EqualsAndHashCode：生成 equal() 和 hashCode() 方法。

@NoArgsConstructor：生成一个无参构造器。

@AllArgsConstructor：生成一个全参构造器。

@NonNull：为字段参数生成非空检查，避免 NullPointerException;

@RequiredArgsConstructor：为所有必填字段生成一个构造器。

@Cleanup：用在局部变量上，作为资源使用完成后的释放。比如 FileInputStream 这类的文件流，会在使用完成后调用 close() 方法。

@SneakyThrows：用在方法或者构造器上，抛出需要 throw 的异常。比如 @SneakyThrows(UnsupportedEncodingException.class)。

@Synchronized：用在方法上。相当于对方法使用了 synchronized 关键字。

@Data：神器，相当于同时使用了 @Getter、@Setter、@RequiredArgsConstructor、@ToString、@EqualsAndHashCode。