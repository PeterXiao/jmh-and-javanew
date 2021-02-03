/**
 * 
 */
package luozix.start.exams.funcs;

import java.util.ArrayList;
import java.util.Vector;

/**
 * @author xiaoy
 *
 */
public class Findareas {
	public static void main(String[] agrs) {
		Figure f = new Figure(10, 10);
		Rectangle r = new Rectangle(9, 5);
		Figure figref;
		figref = f;
		System.out.println("Area is :" + figref.area());
		figref = r;
		System.out.println("Area is :" + figref.area());

		Object testObject = new ArrayList();
		displayObjectClass(testObject);

		int[] intary = { 99, 12, 22, 34, 45, 67, 5678, 8990 };
		int no = 5678;
		int i = 0;
		boolean found = false;
		for (; i < intary.length; i++) {
			if (intary[i] == no) {
				found = true;
				break;
			}
		}
		if (found) {
			System.out.println(no + " 元素的索引位置在: " + i);
		} else {
			System.out.println(no + " 元素不在数组中");
		}
		StringBuffer searchstr = new StringBuffer("hello how are you. ");
		int length = searchstr.length();
		int count = 0;
		for (int i1 = 0; i1 < length; i1++) {
			if (searchstr.charAt(i1) != 'h')
				continue;
			count++;
			searchstr.setCharAt(i1, 'h');
		}
		System.out.println("发现 " + count + " 个 h 字符");
		System.out.println(searchstr);

	}

	public static void displayObjectClass(Object o) {
		if (o instanceof Vector)
			System.out.println("对象是 java.util.Vector 类的实例");
		else if (o instanceof ArrayList)
			System.out.println("对象是 java.util.ArrayList 类的实例");
		else
			System.out.println("对象是 " + o.getClass() + " 类的实例");
	}
}

class Figure {
	double dim1;
	double dim2;

	Figure(double a, double b) {
		dim1 = a;
		dim2 = b;
	}

	Double area() {
		System.out.println("Inside area for figure.");
		return (dim1 * dim2);
	}
}

class Rectangle extends Figure {
	Rectangle(double a, double b) {
		super(a, b);
	}

	@Override
	Double area() {
		System.out.println("Inside area for rectangle.");
		return (dim1 * dim2);
	}
}
