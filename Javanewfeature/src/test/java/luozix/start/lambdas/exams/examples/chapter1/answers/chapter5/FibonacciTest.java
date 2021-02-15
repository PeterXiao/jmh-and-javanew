package luozix.start.lambdas.exams.examples.chapter1.answers.chapter5;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;

import luozix.start.lambdas.exams.answers.chapter5.Fibonacci;

public class FibonacciTest {

    @Test
    public void fibonacciMatchesOpeningSequence() {
        List<Long> fibonacciSequence = Arrays.asList(0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L);

        IntStream.range(0, fibonacciSequence.size())
                 .forEach(x -> {
					luozix.start.lambdas.exams.answers.chapter5.Fibonacci fibonacci = new Fibonacci();
                     long result = fibonacci.fibonacci(x);
                     long expectedResult = fibonacciSequence.get(x);
                     assertEquals(expectedResult, result);
                 });
    }

}
