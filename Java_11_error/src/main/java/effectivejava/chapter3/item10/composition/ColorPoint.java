package effectivejava.chapter3.item10.composition;

import java.util.Objects;

import effectivejava.chapter3.item10.Color;
import effectivejava.chapter3.item10.Point;

// Adds a value component without violating the equals contract (page 44)
public class ColorPoint {
    private final Point point;
    private final Color color;

    public ColorPoint(final int x, final int y, final Color color) {
	point = new Point(x, y);
	this.color = Objects.requireNonNull(color);
    }

    /**
     * Returns the point-view of this color point.
     */
    public Point asPoint() {
	return point;
    }

    @Override
    public boolean equals(final Object o) {
	if (!(o instanceof ColorPoint)) {
	    return false;
	}
	final ColorPoint cp = (ColorPoint) o;
	return cp.point.equals(point) && cp.color.equals(color);
    }

    @Override
    public int hashCode() {
	return 31 * point.hashCode() + color.hashCode();
    }
}