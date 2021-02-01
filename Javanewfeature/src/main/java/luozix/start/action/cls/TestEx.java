/**
 * 
 */
package luozix.start.action.cls;

/**
 * @author xiaoy
 *
 */
class Animal {
	void eat() {
		System.out.println("animal : eat");
	}
}

class DogLL extends Animal {
	@Override
	void eat() {
		System.out.println("dog : eat");
	}

	void eatTest() {
		this.eat(); // this 调用自己的方法
		super.eat(); // super 调用父类方法
	}
}

public class TestEx {
	public static void main(String[] args) {
		Animal a = new Animal();
		a.eat();
		DogLL d = new DogLL();
		d.eatTest();
	}
	}
