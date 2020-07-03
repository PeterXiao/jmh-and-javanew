package effectivejava.chapter5.item29.technqiue1;

import java.util.Arrays;

import effectivejava.chapter5.item29.EmptyStackException;

// Generic stack using E[] (Pages 130-3)
public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    // The elements array will contain only E instances from push(E).
    // This is sufficient to ensure type safety, but the runtime
    // type of the array won't be E[]; it will always be Object[]!
    @SuppressWarnings("unchecked")
    public Stack() {
	elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(final E e) {
	ensureCapacity();
	elements[size++] = e;
    }

    public E pop() {
	if (size == 0) {
	    throw new EmptyStackException();
	}
	final E result = elements[--size];
	elements[size] = null; // Eliminate obsolete reference
	return result;
    }

    public boolean isEmpty() {
	return size == 0;
    }

    private void ensureCapacity() {
	if (elements.length == size) {
	    elements = Arrays.copyOf(elements, 2 * size + 1);
	}
    }

    // Little program to exercise our generic Stack
    public static void main(final String[] args) {
	final Stack<String> stack = new Stack<>();
	for (final String arg : args) {
	    stack.push(arg);
	}
	while (!stack.isEmpty()) {
	    System.out.println(stack.pop().toUpperCase());
	}
    }
}
