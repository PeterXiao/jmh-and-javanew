/**
 * 
 */
package luozix.start.exams.alg;

import java.util.LinkedList;

/**
 * @author xiaoy
 *
 */
public class MyStack {
	private int maxSize;
	private long[] stackArray;
	private int top;

	public MyStack(int s) {
		maxSize = s;
		stackArray = new long[maxSize];
		top = -1;
	}

	public void push(long j) {
		stackArray[++top] = j;
	}

	public long pop() {
		return stackArray[top--];
	}

	public long peek() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == maxSize - 1);
	}

	public static void main(String[] args) {
		MyStack theStack = new MyStack(10);
		theStack.push(10);
		theStack.push(20);
		theStack.push(30);
		theStack.push(40);
		theStack.push(50);
		while (!theStack.isEmpty()) {
			long value = theStack.pop();
			System.out.print(value);
			System.out.print(" ");
		}
		System.out.println("");

		LinkedList lList = new LinkedList();
		lList.add("1");
		lList.add("2");
		lList.add("3");
		lList.add("4");
		lList.add("5");
		lList.add("2");
		System.out.println("元素 2 第一次出现的位置：" + lList.indexOf("2"));
		System.out.println("元素 2 最后一次出现的位置：" + lList.lastIndexOf("2"));
	}
}
