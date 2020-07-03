package effectivejava.chapter6.item34;

// Takes earth-weight and prints table of weights on all planets (Page 160)
public class WeightTable {
    public static void main(final String[] args) {
	final double earthWeight = Double.parseDouble("1000.123456789"); // args[0]
	final double mass = earthWeight / Planet.EARTH.surfaceGravity();
	for (final Planet p : Planet.values()) {
	    System.out.printf("Weight on %s is %f%n", p, p.surfaceWeight(mass));
	}
    }
}
