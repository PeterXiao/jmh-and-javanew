/**
 * 
 */
package luozix.start.java15.switches;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author xiaoy
 *
 */
public class SwitchApp3 {
	public static void main(String[] args) {

		VehicleType vehicleType = VehicleType.TRUCK;

		int speedLimit = switch (vehicleType) {
		case BIKE, SCOOTER -> 40;
		case MOTORBIKE, AUTOMOBILE -> 140;
		case TRUCK -> {
			int randomSpeed = ThreadLocalRandom.current().nextInt(70, 80);
			yield randomSpeed;
		}
		};

		System.out.println("Speed limit: " + speedLimit);
	}
}
