Java Object clone() 方法
Java String类Java Object 类

Object clone() 方法用于创建并返回一个对象的拷贝。

clone 方法是浅拷贝，对象内属性引用的对象只会拷贝引用地址，而不会将引用的对象重新分配内存，相对应的深拷贝则会连引用的对象也重新创建。

语法
object.clone()
参数
无 。

返回值
返回一个对象的拷贝。

由于 Object 本身没有实现 Cloneable 接口，所以不重写 clone 方法并且进行调用的话会发生 CloneNotSupportedException 异常。

