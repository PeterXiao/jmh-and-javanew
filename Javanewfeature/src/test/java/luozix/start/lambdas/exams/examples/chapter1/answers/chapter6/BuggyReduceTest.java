package luozix.start.lambdas.exams.examples.chapter1.answers.chapter6;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import luozix.start.lambdas.exams.answers.chapter6.BuggyReduce;

public class BuggyReduceTest {

    @Test
    public void sample() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        int result = BuggyReduce.multiplyThrough(numbers);
        assertEquals(30, result);
    }

}
