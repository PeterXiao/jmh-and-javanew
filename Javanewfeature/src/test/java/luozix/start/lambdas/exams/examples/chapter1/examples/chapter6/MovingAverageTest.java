package luozix.start.lambdas.exams.examples.chapter1.examples.chapter6;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

import luozix.start.lambdas.exams.examples.chapter6.ArrayExamples;

public class MovingAverageTest {

    /*@Test(expected = IllegalArgumentException.class)
    public void emptyArray() {
        ArrayExamples.simpleMovingAverage(new double[]{}, 3);
    }*/

    @Test
    public void smallArray() {
        double[] input = {0, 1, 2, 3, 4, 3.5};
        double[] result = ArrayExamples.simpleMovingAverage(input, 3);
        System.out.println(Arrays.toString(result));
        double[] expected = {1, 2, 3, 3.5};
        assertArrayEquals(expected, result, 0.0);
    }

}
