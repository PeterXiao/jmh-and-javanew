/**
 *
 */
package io.github.biezhi.java11.interfaces;

/**
 * @author LiY
 * @time 下午7:44:29
 */
public class ExampleTest implements Example {

	/*
	 * (non-Javadoc)
	 *
	 * @see io.github.biezhi.java11.interfaces.Example#normalInterfaceMethod()
	 */
	@Override
	public void normalInterfaceMethod() {
		// TODO Auto-generated method stub

	}

	void sayHello() {
		System.out.println("help");
	}

	/**
	 * @param args
	 * @throws Throwable
	 */
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		final ExampleTest exampleTest = new ExampleTest();

		exampleTest.sayHello();
	}

}
