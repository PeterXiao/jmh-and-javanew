/**
 * 
 */
package luozix.start.exams.alg;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

/**
 * @author xiaoy
 *
 */
public class QueueTest {
	public static void main(String[] args) {
		// add()和remove()方法在失败的时候会抛出异常(不推荐)
		Queue<String> queue = new LinkedList<String>();
		// 添加元素
		queue.offer("a");
		queue.offer("b");
		queue.offer("c");
		queue.offer("d");
		queue.offer("e");
		for (String q : queue) {
			System.out.println(q);
		}
		System.out.println("===");
		System.out.println("poll=" + queue.poll()); // 返回第一个元素，并在队列中删除
		for (String q : queue) {
			System.out.println(q);
		}
		System.out.println("===");
		System.out.println("element=" + queue.element()); // 返回第一个元素
		for (String q : queue) {
			System.out.println(q);
		}
		System.out.println("===");
		System.out.println("peek=" + queue.peek()); // 返回第一个元素
		for (String q : queue) {
			System.out.println(q);
		}

		Vector v = new Vector();
		v.add(new Double("3.4324"));
		v.add(new Double("3.3532"));
		v.add(new Double("3.342"));
		v.add(new Double("3.349"));
		v.add(new Double("2.3"));
		Object obj = Collections.max(v);
		System.out.println("最大元素是：" + obj);

		LinkedList officers = new LinkedList();
		officers.add("B");
		officers.add("B");
		officers.add("T");
		officers.add("H");
		officers.add("P");
		System.out.println(officers);
		officers.set(2, "M");
		System.out.println(officers);

		Vector<String> v1 = new Vector();
		v1.add("1");
		v1.add("2");
		v1.add("3");
		v1.add("4");
		v1.add("5");
		System.out.println(v1);
		Collections.swap(v1, 0, 4);
		System.out.println("旋转后");
		System.out.println(v1);
	}
}

/*
 * offer，add 区别：
 * 
 * 一些队列有大小限制，因此如果想在一个满的队列中加入一个新项，多出的项就会被拒绝。
 * 
 * 这时新的 offer 方法就可以起作用了。它不是对调用 add() 方法抛出一个 unchecked 异常，而只是得到由 offer() 返回的
 * false。
 * 
 * poll，remove 区别：
 * 
 * remove() 和 poll() 方法都是从队列中删除第一个元素。remove() 的行为与 Collection 接口的版本相似， 但是新的
 * poll() 方法在用空集合调用时不是抛出异常，只是返回 null。因此新的方法更适合容易出现异常条件的情况。
 * 
 * peek，element区别：
 * 
 * element() 和 peek() 用于在队列的头部查询元素。与 remove() 方法类似，在队列为空时， element() 抛出一个异常，而
 * peek() 返回 null。
 */