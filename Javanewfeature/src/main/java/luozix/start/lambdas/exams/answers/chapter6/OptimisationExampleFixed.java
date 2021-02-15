package luozix.start.lambdas.exams.answers.chapter6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.RunnerException;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
public class OptimisationExampleFixed {

    public static void main(String[] ignore) throws RunnerException, IOException {
        final String[] args = {
                ".*OptimisationExampleFixed.*",
                "-wi",
                "10",
                "-i",
                "10",
                "-f",
                "1"
        };
        Main.main(args);
    }

    private List<Integer> arrayListOfNumbers;
    private List<Integer> linkedListOfNumbers;

    @Setup
    public void init() {
        arrayListOfNumbers= new ArrayList<>();
        addNumbers(arrayListOfNumbers);

        linkedListOfNumbers = new LinkedList<>();
        addNumbers(linkedListOfNumbers);
    }

    private void addNumbers(List<Integer> container) {
        IntStream.range(0, 1_000_000)
                .forEach(container::add);
    }

	@Benchmark
    public int slowSumOfSquares() {
        return linkedListOfNumbers.parallelStream()
                                  .map(x -> x * x)
                                  .reduce(0, (acc, x) -> acc + x);
    }

	@Benchmark
    public int serialSlowSumOfSquares() {
        return linkedListOfNumbers.stream()
                                  .map(x -> x * x)
                                  .reduce(0, (acc, x) -> acc + x);
    }

	@Benchmark
    public int intermediateSumOfSquares() {
        return arrayListOfNumbers.parallelStream()
                                 .map(x -> x * x)
                                 .reduce(0, (acc, x) -> acc + x);
    }

	@Benchmark
    public int serialIntermediateSumOfSquares() {
        return arrayListOfNumbers.stream()
                                 .map(x -> x * x)
                                 .reduce(0, (acc, x) -> acc + x);
    }

	@Benchmark
    public int fastSumOfSquares() {
        return arrayListOfNumbers.parallelStream()
                                 .mapToInt(x -> x * x)
                                 .sum();
    }

	@Benchmark
    public int serialFastSumOfSquares() {
        return arrayListOfNumbers.stream()
                           .mapToInt(x -> x * x)
                           .sum();
    }

}
