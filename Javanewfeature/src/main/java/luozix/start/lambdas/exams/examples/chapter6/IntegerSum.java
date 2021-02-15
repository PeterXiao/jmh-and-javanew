package luozix.start.lambdas.exams.examples.chapter6;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.RunnerException;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
public class IntegerSum {

    public static void main(String[] ignore) throws IOException, RunnerException {
        final String[] args = {
            ".*IntegerSum.*",
            "-wi",
            "10",
            "-i",
            "20",
            "-f",
            "1"
        };
        Main.main(args);
    }

    private static final int size = Integer.getInteger("sum.size", 1000000);

    public int[] array;
    public List<Integer> arrayList;
    public LinkedList<Integer> linkedList;
    public TreeSet<Integer> treeSet;
    public HashSet<Integer> hashSet;

    @Setup
    public void createDataSources() {
        array = IntStream.range(0, size).toArray();
        arrayList = numbers().collect(toList());
        linkedList = new LinkedList<>(arrayList);
        treeSet = new TreeSet<>(arrayList);
        hashSet = new HashSet<>(arrayList);
    }

    private Stream<Integer> numbers() {
        return IntStream.range(0, size).mapToObj(i -> i);
    }

	@Benchmark
    public int range() {
        return IntStream.range(0, size).parallel().sum();
    }

	@Benchmark
    public int serialRange() {
        return IntStream.range(0, size).sum();
    }

	@Benchmark
    public int array() {
        return IntStream.of(array).parallel().sum();
    }


	@Benchmark
    public int arrayList() {
        return arrayList.parallelStream().mapToInt(i -> i).sum();
    }

    // BEGIN addIntegers
private int addIntegers(List<Integer> values) {
    return values.parallelStream()
                 .mapToInt(i -> i)
                 .sum();
}
    // END addIntegers

	@Benchmark
    public int linkedList() {
        return linkedList.parallelStream().mapToInt(i -> i).sum();
    }

	@Benchmark
    public int treeSet() {
        return treeSet.parallelStream().mapToInt(i -> i).sum();
    }

	@Benchmark
    public int hashSet() {
        return hashSet.parallelStream().mapToInt(i -> i).sum();
    }

	@Benchmark
    public int serialArray() {
        return IntStream.of(array).sum();
    }

	@Benchmark
    public int serialArrayList() {
        return arrayList.stream().mapToInt(i -> i).sum();
    }

	@Benchmark
    public int serialLinkedList() {
        return linkedList.stream().mapToInt(i -> i).sum();
    }

	@Benchmark
    public int serialTreeSet() {
        return treeSet.stream().mapToInt(i -> i).sum();
    }

	@Benchmark
    public int serialHashSet() {
        return hashSet.stream().mapToInt(i -> i).sum();
    }

}
