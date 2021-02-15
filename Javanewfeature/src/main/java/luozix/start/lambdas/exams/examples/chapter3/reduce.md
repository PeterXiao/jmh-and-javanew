

	Object accumulator = initialValue; 
	for(Object element : collection) {    
	 accumulator = combine(accumulator, element); 
	 }
	 
首先赋给 accumulator 一个初始值：initialValue，然后在循环体中，通过调用 combine 函 数，拿 accumulator 和集合中的每一个元素做运算，再将运算结果赋给 accumulator，最后 accumulator 的值就是想要的结果。
这个模式中的两个可变项是 initialValue 初始值和 combine 函数。

### 被函数式编程程序员称为高阶函数的操作。高阶函数是指接受另外一个函 数作为参数，或返回一个函数的函数。高阶函数不难辨认：看函数签名就够了。如果函数 的参数列表里包含函数接口，或该函数返回一个函数接口，那么该函数就是高阶函数。
