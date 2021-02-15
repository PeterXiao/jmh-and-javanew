package luozix.start.lambdas.exams.examples.chapter1.exercises.chapter4;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;

import luozix.start.lambdas.exams.examples.chapter1.Artist;
import luozix.start.lambdas.exams.examples.chapter1.SampleData;
import luozix.start.lambdas.exams.exercises.chapter4.Artists;

public class ArtistsTest {

    private final Artists optionalExamples = new Artists(SampleData.getThreeArtists());

    @Test
    public void indexWithinRange() {
        Artist artist = optionalExamples.getArtist(0);
        assertNotNull(artist);
    }

    @Test(expected = IllegalArgumentException.class)
    public void indexOutsideRange() {
        optionalExamples.getArtist(4);
    }

    @Test
    public void nameIndexInsideRange() {
        String artist = optionalExamples.getArtistName(0);
        Assert.assertEquals("John Coltrane", artist);
    }

    @Test
    public void nameIndexOutsideRange() {
        String artist = optionalExamples.getArtistName(4);
        assertEquals("unknown", artist);
    }

}
