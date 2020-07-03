#为什么要重写hashCode()方法和equals()方法以及如何进行重写

1、首先我们为什么需要重写hashCode()方法和equals()方法？

2、在什么情况下需要重写hashCode()方法和equals()方法？

3、如何重写这两个方法？

1、首先我们为什么需要重写hashCode()方法和equals()方法？

首先，为什么要重写equals()方法。我们在定义类时，我们经常会希望两个不同对象的某些属性值相同时就认为他们相同

2、在什么情况下需要重写hashCode()方法和equals()方法？

当我们自定义的一个类，想要把它的实例保存在集合中时，我们就需要重写这两个方法；集合(Collection)有两个类，一个是List，一个是Set。


3、如何重写这两个方法？

我们先看看 JavaSE 8 Specification中对equals()方法的说明：

自反性：A.equals(A)要返回true；

对称性：如果A.equals(B)返回true, 则B.equals(A)也要返回true；

传递性：如果A.equals(B)为true, B.equals(C)为true, 则A.equals(C)也要为true. 说白了就是 A = B , B = C , 那么A = C；

一致性：只要A,B对象的状态没有改变，A.equals(B)必须始终返回true；

A.equals(null) 要返回false；

