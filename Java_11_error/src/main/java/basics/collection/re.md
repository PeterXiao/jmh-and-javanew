1)

interface X { int m(Iterable<String> arg); }
interface Y { int m(Iterable<String> arg); }
interface Z extends X, Y {}
接口Z继承了X,Y接口的m方法，由于这两个方法的签名相同，返回值也一样，所以Z有唯一的一个抽象方法int m(Iterable<String> arg);,可以作为函数式接口。

2)

interface X { Iterable m(Iterable<String> arg); }
interface Y { Iterable<String> m(Iterable arg); }
interface Z extends X, Y {}
方法签名Y.m 既满足签名是X.m，并且返回值也满足return-type-substitutable。所以Z是函数式接口，函数类型为Iterable<String> m(Iterable arg)。

3)

interface X { int m(Iterable<String> arg); }
interface Y { int m(Iterable<Integer> arg); }
interface Z extends X, Y {}
编译出错， 没有一个方法的签名是所有方法的子签名：

4)

interface X { int m(Iterable<String> arg, Class c); }
interface Y { int m(Iterable arg, Class<?> c); }
interface Z extends X, Y {}
Compiler error: No method has a subsignature of all abstract methods
编译出错， 没有一个方法的签名是所有方法的子签名

5)

interface X { long m(); }
interface Y { int m(); }
interface Z extends X, Y {}
Compiler error: no method is return type substitutable
编译出错， 返回值类型不同。

6)

interface Foo<T> { void m(T arg); }
interface Bar<T> { void m(T arg); }
interface FooBar<X, Y> extends Foo<X>, Bar<Y> {}
Compiler error: different signatures, same erasure
编译出错

7)

interface Foo { void m(String arg); }
interface Bar<T> { void m(T arg); }
interface FooBar<T> extends Foo, Bar<T> {}
不是一个函数式接口， 两个方法的类型参数不一样。

8)

interface X { void m() throws IOException; }
interface Y { void m() throws EOFException; }
interface Z { void m() throws ClassNotFoundException; }
interface XY extends X, Y {}
interface XYZ extends X, Y, Z {}
X.m,Y.m,Z.m方法签名相同，返回值类型都是void，只是异常列表不同。 EOFException是IOException的子类。
在这种情况下XY和XYZ都是函数式接口，但是函数类型不同。
// XY has function type ()->void throws EOFException
// XYZ has function type ()->void (throws nothing)

9)

interface A {
  List<String> foo(List<String> arg) throws IOException, SQLTransientException;
}
interface B {
  List foo(List<String> arg) throws EOFException, SQLException, TimeoutException;
}
interface C {
  List foo(List arg) throws Exception;
}
interface D extends A, B {}
interface E extends A, B, C {}
// D has function type (List)->List throws EOFException, SQLTransientException
// E has function type (List)->List throws EOFException, SQLTransientException

10)

interface G1 {
  <E extends Exception> Object m() throws E;
}
interface G2 {
  <F extends Exception> String m() throws Exception;
}
interface G extends G1, G2 {}
// G has function type ()->String throws F

函数式接口的交集
1)

public class Z {
	public static void main(String[] args) {
		Object o = (I & J) () -> {};
	}
}
interface I {
	void foo();
}
interface J {
	void foo();
}
I和J方法的交集依然符合函数式接口的定义。 上述代码可以用JDK中的javac编译通过但是Eclipse报错，这是Eclipse的一个bug。

2)

public class Z {
	public static void main(String[] args) {
		Object o = (I & J) () -> {};
	}
}
interface I {
	void foo();
}
interface J {
	void foo();
	void bar();
}
上述代码Eclipse不会报错但是javac无法编译，javac认为 (I & J)不是一个函数式接口。 看起来javac工作正常， Eclipse处理这样的case还有问题。