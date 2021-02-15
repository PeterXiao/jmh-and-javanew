package luozix.start.lambdas.exams.examples.chapter1.answers.chapter4;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import luozix.start.lambdas.exams.answers.chapter4.PerformanceFixed;
import luozix.start.lambdas.exams.examples.chapter1.Artist;
import luozix.start.lambdas.exams.examples.chapter1.SampleData;

public class PerformanceTest {

    @Test
    public void findsAllTheBeatles() {
		luozix.start.lambdas.exams.answers.chapter4.PerformanceFixed stub = new PerformanceFixed() {
            @Override
            public String getName() {
                throw new UnsupportedOperationException();
            }

            @Override
            public Stream<Artist> getMusicians() {
                return Stream.of(SampleData.theBeatles);
            }
        };

        List<Artist> allMusicians = stub.getAllMusicians().collect(toList());
        assertThat(allMusicians, hasItem(SampleData.theBeatles));
        // There really must be a better way than this
        assertThat(allMusicians, hasItems(SampleData.membersOfTheBeatles.toArray(new Artist[0])));
    }

}
