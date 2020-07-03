package basics.collection.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTestPerf {
	private static final int MAX_INT = 1_000_000;

	public static void stream() {
		List<String> list = new ArrayList<>();
		IntStream.range(0, MAX_INT).forEach(value -> {
			UUID uuid = UUID.randomUUID();
			list.add(uuid.toString());
		});

		long startTime = System.nanoTime();

		list.stream().sorted().collect(Collectors.toList());

		long endTime = System.nanoTime();
		long durationTime = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
		System.out.println("stream execute time : " + durationTime);
	}

	public static void parallelStream() {
		List<String> list = new ArrayList<>();
		IntStream.range(0, MAX_INT).forEach(value -> {
			UUID uuid = UUID.randomUUID();
			list.add(uuid.toString());
		});

		long startTime = System.nanoTime();

		list.parallelStream().sorted().collect(Collectors.toList());

		long endTime = System.nanoTime();
		long durationTime = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
		System.out.println("parallelStream execute time : " + durationTime);
	}

	public static void main(String[] args) {
		stream();
		parallelStream();
	}


}
