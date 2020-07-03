package effectivejava.chapter5.item30;

import java.util.function.UnaryOperator;

// Generic singleton factory pattern (Page 136-7)
public class GenericSingletonFactory {
    // Generic singleton factory pattern
    private static UnaryOperator<Object> IDENTITY_FN = (t) -> t;

    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identityFunction() {
	return (UnaryOperator<T>) IDENTITY_FN;
    }

    // Sample program to exercise generic singleton
    public static void main(final String[] args) {
	final String[] strings = { "jute", "hemp", "nylon" };
	final UnaryOperator<String> sameString = identityFunction();
	for (final String s : strings) {
	    System.out.println(sameString.apply(s));
	}

	final Number[] numbers = { 1, 2.0, 3L };
	final UnaryOperator<Number> sameNumber = identityFunction();
	for (final Number n : numbers) {
	    System.out.println(sameNumber.apply(n));
	}
    }
}