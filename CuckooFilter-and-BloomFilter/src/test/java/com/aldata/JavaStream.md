Stream处理

数组获取Stream
Arrays.Stream(arr);
集合获取Stream
list.stream()
set.stream();
map.entrySet().stream()

Stream基本操作

中间操作

filter  过滤数据
map    转换数据
distinct
skip  跳过前N个元素
flatMap 将多个流合并为一个流
limit
sorted

最终操作

collect 转换成集合
forEach 遍历
count  计数
anyMatch  匹配任意一个返回true
allMatch  全部匹配返回true
noneMatch 全部不匹配 返回true
findAny  返回任意一个
findFirst  返回第一个
reduce  2种重载方法reduce(0,(a,b)->{}); reduce((a,b)->{});

数值流

mapToInt
mapToLong
mapToDouble
boxed  装箱
max
sum

生成数据流

Arrays.stream()
list.stream()
set.stream()
map.entrySet().stream()
IntStream.rangeClosed(start,end) 生成一个[start,end]的流
Stream.of(obj1,obj2,obj3)
Stream.iterator(T seed,Supply) 生成的是一个无限流
Stream.generator(Supply()) 生成的是一个无限流

