package luozix.start.lambdas.exams.examples.chapter1.answers.chapter3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import org.junit.Test;

import luozix.start.lambdas.exams.answers.chapter3.StringExercises;

public class StringExercisesTest {

    @Test
    public void noLowercaseLettersInAnEmptyString() {
		assertEquals(0, luozix.start.lambdas.exams.answers.chapter3.StringExercises.countLowercaseLetters(""));
    }

    @Test
    public void countsLowercaseLetterExample() {
		assertEquals(3, luozix.start.lambdas.exams.answers.chapter3.StringExercises.countLowercaseLetters("aBcDeF"));
    }

    @Test
    public void suppoertsNoLowercaseLetters() {
		assertEquals(0, luozix.start.lambdas.exams.answers.chapter3.StringExercises.countLowercaseLetters("ABCDEF"));
    }

    @Test
    public void noStringReturnedForEmptyList() {
		assertFalse(luozix.start.lambdas.exams.answers.chapter3.StringExercises
				.mostLowercaseString(Collections.<String>emptyList()).isPresent());
    }

    @Test
    public void findsMostLowercaseString() {
        Optional<String> result = StringExercises.mostLowercaseString(Arrays.asList("a", "abc", "ABCde"));
        assertEquals(Optional.of("abc"), result);
    }

}
