package effectivejava.chapter9.item58;

import java.util.Collection;
import java.util.EnumSet;

// Same bug as NestIteration.java (but different symptom)!! - Page 213
public class DiceRolls {
    enum Face {
	ONE, TWO, THREE, FOUR, FIVE, SIX
    }

    public static void main(final String[] args) {
	// Same bug, different symptom!
	final Collection<Face> faces = EnumSet.allOf(Face.class);

	for (final Face face : faces) {
	    for (final Face face2 : faces) {
		System.out.println(face + " " + face2);
	    }
	}

	System.out.println("***************************");

	for (final Face f1 : faces) {
	    for (final Face f2 : faces) {
		System.out.println(f1 + " " + f2);
	    }
	}
    }
}
