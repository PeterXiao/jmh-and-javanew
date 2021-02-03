/**
 * 
 */
package luozix.start.exams.alg;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Vector;

/**
 * @author xiaoy
 *
 */
public class TestTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int limit = 100;
		int sum = 0;
		int i = 1;
		do {
			sum = sum + i;
			i++;
		} while (i <= limit);
		System.out.println("sum=" + sum);

		LinkedList<String> lList = new LinkedList<String>();
		lList.add("1");
		lList.add("2");
		lList.add("3");
		lList.add("4");
		lList.add("5");
		System.out.println(lList);
		lList.addFirst("0");
		System.out.println(lList);
		lList.addLast("6");
		System.out.println(lList);

		lList.add("100");
		lList.add("200");
		lList.add("300");
		lList.add("400");
		lList.add("500");
		System.out.println("链表的第一个元素是：" + lList.getFirst());
		System.out.println("链表的最后一个元素是：" + lList.getLast());

		lList.add("1");
		lList.add("8");
		lList.add("6");
		lList.add("4");
		lList.add("5");
		System.out.println(lList);
		lList.subList(2, 4).clear();
		System.out.println(lList);

		TestTest stack = new TestTest();
		for (int i1 = 30; i1 < 40; i1++)
			stack.push(new Integer(i1));
		System.out.println(stack.top());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

		Vector v = new Vector();
		v.add("X");
		v.add("M");
		v.add("D");
		v.add("A");
		v.add("O");
		Collections.sort(v);
		System.out.println(v);
		int index = Collections.binarySearch(v, "D");
		System.out.println("元素索引值为 : " + index);
	}

	private LinkedList list = new LinkedList();

	public void push(Object v) {
		list.addFirst(v);
	}

	public Object top() {
		return list.getFirst();
	}

	public Object pop() {
		return list.removeFirst();
	}
}
