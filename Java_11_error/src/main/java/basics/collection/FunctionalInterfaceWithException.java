package basics.collection;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class FunctionalInterfaceWithException {
	public static void main(String[] args) {
		InterfaceWithException target = i -> {};
		try {
			target.apply(10);
		} catch (Exception e) {
			e.printStackTrace();
		}

		  var createdArray = new AtomicReference<String[]>();
		    var usedArray = List.of("A", "B", "C").toArray(__ -> {
		        createdArray.set(new String[5]);
		        return createdArray.get();
		    });

		    var message = String.format(
		            "%s (length: %d; identical with created array: %s)",
		            Arrays.toString(usedArray), usedArray.length, usedArray == createdArray.get());
		    System.out.println(message);
	}
}
@FunctionalInterface
interface InterfaceWithException {
	void apply(int i) throws Exception;
}
