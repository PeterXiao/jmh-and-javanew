package luozix.start.lambdas.exams.examples.chapter1.exercises.chapter6;

import static org.junit.Assert.assertEquals;

import java.util.stream.IntStream;

import org.junit.Test;

import luozix.start.lambdas.exams.exercises.chapter6.SerialToParallel;

public class SerialToParallelTest {

    @Test
    public void testSerialToParallel() {
        IntStream range = IntStream.range(0, 100);
        assertEquals(328350, SerialToParallel.sumOfSquares(range));
    }

}
