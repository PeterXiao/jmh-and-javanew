/**
 * 
 */
package luozix.start.java15.records;

/**
 * @author xiaoy
 *
 */
public class RecordsApp1 {
	public static void main(String[] args) {

		Point point = new Point(2, 3);

		System.out.println(point);

		int x = point.x();
		int y = point.y();
		System.out.format("X: %d, Y: %d", x, y);

		Point point1 = new Point(2, 3);
		Point point2 = new Point(2, 3);

		System.out.println("Equal? " + point1.equals(point2));
	}
}
