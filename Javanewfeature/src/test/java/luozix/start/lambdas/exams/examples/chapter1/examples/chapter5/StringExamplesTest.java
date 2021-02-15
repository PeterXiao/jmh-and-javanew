package luozix.start.lambdas.exams.examples.chapter1.examples.chapter5;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Function;

import org.junit.Test;

import luozix.start.lambdas.exams.examples.chapter1.Artist;
import luozix.start.lambdas.exams.examples.chapter1.SampleData;
import luozix.start.lambdas.exams.examples.chapter5.StringExamples;

public class StringExamplesTest {

    @Test
    public void beatlesExample() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        joiner.add("John");
        joiner.add("Paul");
        joiner.add("Ringo");
        assertEquals("[John, Paul, Ringo]", joiner.toString());
    }

    @Test
    public void allStringJoins() {
        List<Function<List<Artist>, String>> formatters = Arrays.<Function<List<Artist>, String>>asList(
            StringExamples::formatArtists,
            StringExamples::formatArtistsForLoop,
            StringExamples::formatArtistsRefactor1,
            StringExamples::formatArtistsRefactor2,
            StringExamples::formatArtistsRefactor3,
            StringExamples::formatArtistsRefactor4,
            StringExamples::formatArtistsRefactor5
        );

        formatters.forEach(formatter -> {
            System.out.println("Testing: " + formatter.toString());
            String result = formatter.apply(SampleData.getThreeArtists());
            assertEquals("[John Coltrane, John Lennon, The Beatles]", result);

            result = formatter.apply(Collections.emptyList());
            assertEquals("[]", result);
        });
    }

    @Test
    public void explicitForLoop() {
        String result = StringExamples.formatArtists(SampleData.getThreeArtists());
        assertEquals("[John Coltrane, John Lennon, The Beatles]", result);
    }

	@Test
	public void caseStream() {
		var artists = SampleData.getThreeArtists();
		StringBuilder reduced = artists.stream().map(Artist::getName).reduce(new StringBuilder(), (builder, name) -> {
			if (builder.length() > 0)
				builder.append(", ");

			builder.append(name);
			return builder;
		}, (left, right) -> left.append(right));

		reduced.insert(0, "[");
		reduced.append("]");
		String result = reduced.toString();

	}

}
