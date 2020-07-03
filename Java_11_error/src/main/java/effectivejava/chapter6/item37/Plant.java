package effectivejava.chapter6.item37;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Using an EnumMap to associate data with an enum (Pages 171-3)

// Simplistic class representing a plant (Page 171)
class Plant {
    enum LifeCycle {
	ANNUAL, PERENNIAL, BIENNIAL
    }

    final String name;
    final LifeCycle lifeCycle;

    Plant(final String name, final LifeCycle lifeCycle) {
	this.name = name;
	this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
	return name;
    }

    public static void main(final String[] args) {
	final Plant[] garden = { new Plant("Basil", LifeCycle.ANNUAL), new Plant("Carroway", LifeCycle.BIENNIAL),
		new Plant("Dill", LifeCycle.ANNUAL), new Plant("Lavendar", LifeCycle.PERENNIAL),
		new Plant("Parsley", LifeCycle.BIENNIAL), new Plant("Rosemary", LifeCycle.PERENNIAL) };

	// Using ordinal() to index into an array - DON'T DO THIS! (Page 171)
	final Set<Plant>[] plantsByLifeCycleArr = new Set[Plant.LifeCycle.values().length];
	for (int i = 0; i < plantsByLifeCycleArr.length; i++) {
	    plantsByLifeCycleArr[i] = new HashSet<>();
	}
	for (final Plant p : garden) {
	    plantsByLifeCycleArr[p.lifeCycle.ordinal()].add(p);
	}
	// Print the results
	for (int i = 0; i < plantsByLifeCycleArr.length; i++) {
	    System.out.printf("%s: %s%n", Plant.LifeCycle.values()[i], plantsByLifeCycleArr[i]);
	}

	// Using an EnumMap to associate data with an enum (Page 172)
	final Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);
	for (final Plant.LifeCycle lc : Plant.LifeCycle.values()) {
	    plantsByLifeCycle.put(lc, new HashSet<>());
	}
	for (final Plant p : garden) {
	    plantsByLifeCycle.get(p.lifeCycle).add(p);
	}
	System.out.println(plantsByLifeCycle);

	// Naive stream-based approach - unlikely to produce an EnumMap! (Page 172)
	System.out.println(Arrays.stream(garden).collect(groupingBy(p -> p.lifeCycle)));

	// Using a stream and an EnumMap to associate data with an enum (Page 173)
	System.out.println(Arrays.stream(garden)
		.collect(groupingBy(p -> p.lifeCycle, () -> new EnumMap<>(LifeCycle.class), toSet())));
    }
}
