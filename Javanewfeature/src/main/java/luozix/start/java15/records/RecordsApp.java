/**
 * 
 */
package luozix.start.java15.records;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import lombok.experimental.var;

/**
 * @author xiaoy
 *
 */
public class RecordsApp {
	public static void main(String[] args) {

		Point point = new Point(2, 3);

		System.out.println(point);

		int x = point.x();
		int y = point.y();
		System.out.format("X: %d, Y: %d", x, y);

		Point point1 = new Point(2, 3);
		Point point2 = new Point(2, 3);

		System.out.println("Equal? " + point1.equals(point2));

		var l = new Location("New York", "US");
		// var l1 = new Location("New York", null);
		var l2 = new Location("New York", "");
		System.out.println(l.city());

		try (var oss = new ObjectOutputStream(new FileOutputStream("serial.data"))) {
			oss.writeObject(1);
		} catch (Exception e) {
			// TODO: handle exception
		}

		Location location;
		try (var in = new ObjectInputStream(new FileInputStream("serial.data"))) {
			location = (Location) in.readObject();
			System.out.println(location.city());
		} catch (Exception e) {
			// TODO: handle exception

		}


	}
}
