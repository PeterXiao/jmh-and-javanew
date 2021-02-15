package luozix.start.lambdas.exams.examples.chapter1.examples.chapter6;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import luozix.start.lambdas.exams.examples.chapter6.ArrayExamples;

@RunWith(value = Parameterized.class)
public class ArrayExamplesTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                { 0, new double[]{} },
                { 2, new double[]{0, 1} },
                { 4, new double[]{0, 1, 2, 3}  }
        };
        return Arrays.asList(data);
    }

    private final int size;
    private final double[] output;

    public ArrayExamplesTest(int size, double[] output) {
        this.size = size;
        this.output = output;
    }

    @Test
    public void parallel() {
        assertArrayEquals(output, ArrayExamples.parallelInitialize(size), 0.0);
    }

    @Test
    public void imperative() {
        assertArrayEquals(output, ArrayExamples.imperativeInitilize(size), 0.0);
    }

}
