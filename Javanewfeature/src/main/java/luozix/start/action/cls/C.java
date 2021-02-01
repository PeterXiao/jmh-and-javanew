/**
 * 
 */
package luozix.start.action.cls;

/**
 * @author xiaoy
 *
 */
interface A {
	public void eat();

	public void sleep();
}

interface B {
	public void show();
}

public class C implements A, B {

	/*
	 * (non-Javadoc)
	 * 
	 * @see luozix.start.action.cls.B#show()
	 */
	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see luozix.start.action.cls.A#eat()
	 */
	@Override
	public void eat() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see luozix.start.action.cls.A#sleep()
	 */
	@Override
	public void sleep() {
		// TODO Auto-generated method stub

	}
}
