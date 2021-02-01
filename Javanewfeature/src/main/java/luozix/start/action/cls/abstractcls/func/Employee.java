/**
 * 
 */
package luozix.start.action.cls.abstractcls.func;

/**
 * @author xiaoy
 *
 */
public abstract class Employee {
	private String name;
	private String address;
	private int number;

	public abstract double computePay();

	// 其余代码
}
/*
 * 声明抽象方法会造成以下两个结果：
 * 
 * 如果一个类包含抽象方法，那么该类必须是抽象类。
 * 
 * 任何子类必须重写父类的抽象方法，或者声明自身为抽象类。
 * 
 * 继承抽象方法的子类必须重写该方法。否则，该子类也必须声明为抽象类。
 * 
 * 最终，必须有子类实现该抽象方法，否则，从最初的父类到最终的子类都不能用来实例化对象。
 * 
 */