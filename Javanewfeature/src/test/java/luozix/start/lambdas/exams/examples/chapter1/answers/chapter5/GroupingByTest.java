package luozix.start.lambdas.exams.examples.chapter1.answers.chapter5;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.Test;

import luozix.start.lambdas.exams.answers.chapter5.GroupingBy;

public class GroupingByTest {

    @Test
    public void stringsByLength() {
		luozix.start.lambdas.exams.answers.chapter5.GroupingBy<String, Integer> stringIntegerGroupingBy = new GroupingBy<>(
				String::length);
        Map<Integer,List<String>> results = Stream.of("a", "b", "cc", "dd")
                                                  .collect(stringIntegerGroupingBy);

        System.out.println(results);

        assertEquals(2, results.size());
        assertEquals(asList("a", "b"), results.get(1));
        assertEquals(asList("cc", "dd"), results.get(2));
    }

}
