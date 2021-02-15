package luozix.start.lambdas.exams.examples.chapter1.exercises.chapter5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import luozix.start.lambdas.exams.examples.chapter1.Artist;
import luozix.start.lambdas.exams.examples.chapter1.SampleData;
import luozix.start.lambdas.exams.exercises.chapter5.LongestName;

public class LongestNameTest {

    @Test
    public void findsLongestNameByReduce() {
        Artist artist = LongestName.byReduce(SampleData.getThreeArtists());
        assertEquals(SampleData.johnColtrane, artist);
    }

    @Test
    public void findsLongestNameByCollecting() {
        Artist artist = LongestName.byCollecting(SampleData.getThreeArtists());
        assertEquals(SampleData.johnColtrane, artist);
    }

}
