dataType[] arrayRefVar;   // 首选的方法
 
或
 
dataType arrayRefVar[];  // 效果相同，但不是首选方法


arrayRefVar = new dataType[arraySize];

上面的语法语句做了两件事：

一、使用 dataType[arraySize] 创建了一个数组。
二、把新创建的数组的引用赋值给变量 arrayRefVar。
数组变量的声明，和创建数组可以用一条语句完成，如下所示：

dataType[] arrayRefVar = new dataType[arraySize];
另外，你还可以使用如下的方式创建数组。

dataType[] arrayRefVar = {value0, value1, ..., valuek};
数组的元素是通过索引访问的。数组索引从 0 开始，所以索引值从 0 到 arrayRefVar.length-1。

多维数组
多维数组可以看成是数组的数组，比如二维数组就是一个特殊的一维数组，其每一个元素都是一个一维数组，例如：

String str[][] = new String[3][4];
多维数组的动态初始化（以二维数组为例）
1. 直接为每一维分配空间，格式如下：

type[][] typeName = new type[typeLength1][typeLength2];
type 可以为基本数据类型和复合数据类型，arraylength1 和 arraylength2 必须为正整数，arraylength1 为行数，arraylength2 为列数。