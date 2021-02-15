package luozix.start.lambdas.exams.examples.chapter1.answers.chapter5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import luozix.start.lambdas.exams.answers.chapter5.LongestName;
import luozix.start.lambdas.exams.examples.chapter1.Artist;
import luozix.start.lambdas.exams.examples.chapter1.SampleData;

public class LongestNameTest {

    @Test
    public void findsLongestNameByReduce() {
		Artist artist = luozix.start.lambdas.exams.answers.chapter5.LongestName.byReduce(SampleData.getThreeArtists());
        assertEquals(SampleData.johnColtrane, artist);
    }

    @Test
    public void findsLongestNameByCollecting() {
        Artist artist = LongestName.byCollecting(SampleData.getThreeArtists());
        assertEquals(SampleData.johnColtrane, artist);
    }

}
