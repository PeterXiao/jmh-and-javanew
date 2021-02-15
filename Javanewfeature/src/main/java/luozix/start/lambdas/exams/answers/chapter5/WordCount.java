package luozix.start.lambdas.exams.answers.chapter5;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import luozix.start.lambdas.exams.examples.chapter5.StringCombiner;

public class WordCount {

    public static Map<String, Long> countWords(Stream<String> names) {
        return names.collect(groupingBy(name -> name, counting()));
    }

	public Function<StringCombiner, String> finisher() {
		return StringCombiner::toString;
	}

}
