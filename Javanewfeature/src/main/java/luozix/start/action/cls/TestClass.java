/**
 * 
 */
package luozix.start.action.cls;

/**
 * @author xiaoy
 *
 */
public class TestClass {

	/**
	 * @param args
	 */
	 public static void main(String[] args) {
	      show(new Cat());  // 以 Cat 对象调用 show 方法
			show(new DogL()); // 以 Dog 对象调用 show 方法
	                
			LAnimal a = new Cat(); // 向上转型
	      a.eat();               // 调用的是 Cat 的 eat
	      Cat c = (Cat)a;        // 向下转型  
	      c.work();        // 调用的是 Cat 的 work
	  }  
	            
		public static void show(LAnimal a) {
	      a.eat();  
	        // 类型判断
	        if (a instanceof Cat)  {  // 猫做的事情 
	            Cat c = (Cat)a;  
	            c.work();  
			} else if (a instanceof DogL) { // 狗做的事情
				DogL c = (DogL) a;
	            c.work();  
	        }  
	    }  

}

abstract class LAnimal {
	abstract void eat();
}

class Cat extends LAnimal {
	@Override
	public void eat() {
		System.out.println("吃鱼");
	}

	public void work() {
		System.out.println("抓老鼠");
	}
}

class DogL extends LAnimal {
	@Override
	public void eat() {
		System.out.println("吃骨头");
	}

	public void work() {
		System.out.println("看家");
	}
}
class Shape {
	void draw() {
	}
}

class Circle extends Shape {
	@Override
	void draw() {
		System.out.println("Circle.draw()");
	}
}

class Square extends Shape {
	@Override
	void draw() {
		System.out.println("Square.draw()");
	}
}

class Triangle extends Shape {
	@Override
	void draw() {
		System.out.println("Triangle.draw()");
	}
}