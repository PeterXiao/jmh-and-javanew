package effectivejava.chapter3.item10.inheritance;

import effectivejava.chapter3.item10.Color;
import effectivejava.chapter3.item10.Point;

// Attempting to add a value component to Point (Page 41)
public class ColorPoint extends Point {
    private final Color color;

    public ColorPoint(final int x, final int y, final Color color) {
	super(x, y);
	this.color = color;
    }

    // Broken - violates symmetry! (Page 41)
    @Override
    public boolean equals(final Object o) {
	if (!(o instanceof ColorPoint)) {
	    return false;
	}
	return super.equals(o) && ((ColorPoint) o).color == color;
    }

//    // Broken - violates transitivity! (page 42)
//    @Override public boolean equals(Object o) {
//        if (!(o instanceof Point))
//            return false;
//
//        // If o is a normal Point, do a color-blind comparison
//        if (!(o instanceof ColorPoint))
//            return o.equals(this);
//
//        // o is a ColorPoint; do a full comparison
//        return super.equals(o) && ((ColorPoint) o).color == color;
//    }

    public static void main(final String[] args) {
	// First equals function violates symmetry (Page 42)
	final Point p = new Point(1, 2);
	final ColorPoint cp = new ColorPoint(1, 2, Color.RED);
	System.out.println(p.equals(cp) + " " + cp.equals(p));

	// Second equals function violates transitivity (Page 42)
	final ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
	final Point p2 = new Point(1, 2);
	final ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
	System.out.printf("%s %s %s%n", p1.equals(p2), p2.equals(p3), p1.equals(p3));
    }
}
