package effectivejava.chapter6.item34;

import static java.util.stream.Collectors.toMap;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

// Enum type with constant-specific class bodies and data (Pages 163-4)
public enum Operation {
	PLUS("+") {
		@Override
		public double apply(double x, double y) {
			return x + y;
		}
	},
	MINUS("-") {
		@Override
		public double apply(double x, double y) {
			return x - y;
		}
	},
	TIMES("*") {
		@Override
		public double apply(double x, double y) {
			return x * y;
		}
	},
	DIVIDE("/") {
		@Override
		public double apply(double x, double y) {
			return x / y;
		}
	};

	private final String symbol;

	Operation(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}

	public abstract double apply(double x, double y);

	// Implementing a fromString method on an enum type (Page 164)
	private static final Map<String, Operation> stringToEnum = Stream.of(values())
			.collect(toMap(Object::toString, e -> e));

	// Returns Operation for string, if any
	public static Optional<Operation> fromString(String symbol) {
		return Optional.ofNullable(stringToEnum.get(symbol));
	}

	public static void main(String[] args) {
		final double x = Double.parseDouble(args[0]);
		final double y = Double.parseDouble(args[1]);
		for (final Operation op : Operation.values()) {
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
		}
	}
}
