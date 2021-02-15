package luozix.start.lambdas.exams.examples.chapter1.answers.chapter3;

import static java.util.Arrays.asList;
import static luozix.start.lambdas.exams.examples.chapter1.SampleData.aLoveSupreme;
import static luozix.start.lambdas.exams.examples.chapter1.SampleData.manyTrackAlbum;
import static luozix.start.lambdas.exams.examples.chapter1.SampleData.sampleShortAlbum;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import luozix.start.lambdas.exams.answers.chapter3.Question1;
import luozix.start.lambdas.exams.examples.chapter1.Album;
import luozix.start.lambdas.exams.examples.chapter1.SampleData;

public class Question1Test {

    @Test
    public void addsEmptyList() {
        int result = luozix.start.lambdas.exams.answers.chapter3.Question1.addUp(Stream.empty());
        assertEquals(0, result);
    }

    @Test
    public void addsListWithValues() {
        int result = luozix.start.lambdas.exams.answers.chapter3.Question1.addUp(Stream.of(1, 3, -2));
        assertEquals(2, result);
    }

    @Test
    public void extractsNamesAndOriginsOfArtists() {
		List<String> namesAndOrigins = luozix.start.lambdas.exams.answers.chapter3.Question1
				.getNamesAndOrigins(SampleData.getThreeArtists());
        assertEquals(asList("John Coltrane", "US", "John Lennon", "UK", "The Beatles", "UK"), namesAndOrigins);
    }

    @Test
    public void findsShortAlbums() {
        List<Album> input = asList(manyTrackAlbum, sampleShortAlbum, aLoveSupreme);
        List<Album> result = Question1.getAlbumsWithAtMostThreeTracks(input);
        assertEquals(asList(sampleShortAlbum, aLoveSupreme), result);
    }

}
