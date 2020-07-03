package effectivejava.chapter7.item42;

import java.util.function.DoubleBinaryOperator;

// Enum with function object fields & constant-specific behavior (Page 195)
public enum Operation {
    PLUS("+", (x, y) -> x + y), MINUS("-", (x, y) -> x - y), TIMES("*", (x, y) -> x * y), DIVIDE("/", (x, y) -> x / y);

    private final String symbol;
    private final DoubleBinaryOperator op;

    Operation(final String symbol, final DoubleBinaryOperator op) {
	this.symbol = symbol;
	this.op = op;
    }

    @Override
    public String toString() {
	return symbol;
    }

    public double apply(final double x, final double y) {
	return op.applyAsDouble(x, y);
    }

    // Main method from Item 34 (Page 163)
    public static void main(final String[] args) {
	final double x = Double.parseDouble(args[0]);
	final double y = Double.parseDouble(args[1]);
	for (final Operation op : Operation.values()) {
	    System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
	}
    }
}
