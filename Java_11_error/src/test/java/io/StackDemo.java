/**
 *
 */
package io;

/**
 * @author LiY
 *
 */
import java.util.EmptyStackException;
import java.util.Stack;

public class StackDemo {

	static void showpush(Stack<Integer> st, int a) {
		st.push(new Integer(a));
		System.out.println("push(" + a + ")");
		System.out.println("stack: " + st);
	}

	static void showpop(Stack<Integer> st) {
		System.out.print("pop -> ");
		final Integer a = st.pop();
		System.out.println(a);
		System.out.println("stack: " + st);
	}

	public static void main(String args[]) {
		final Stack<Integer> st = new Stack<Integer>();
		System.out.println("stack: " + st);
		showpush(st, 42);
		showpush(st, 66);
		showpush(st, 99);
		showpop(st);
		showpop(st);
		showpop(st);
		try {
			showpop(st);
		} catch (final EmptyStackException e) {
			System.out.println("empty stack");
		}
	}
}