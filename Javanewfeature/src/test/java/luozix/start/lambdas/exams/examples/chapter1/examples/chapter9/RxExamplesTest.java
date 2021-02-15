package luozix.start.lambdas.exams.examples.chapter1.examples.chapter9;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import luozix.start.lambdas.exams.examples.chapter1.Artist;
import luozix.start.lambdas.exams.examples.chapter1.SampleData;
import luozix.start.lambdas.exams.examples.chapter9.RxExamples;

public class RxExamplesTest {

    @Test
    public void filtersAlbums() throws InterruptedException {
        RxExamples examples = new RxExamples(SampleData.getThreeArtists());
		Artist artist = examples.search("John", "UK", 5).toBlocking()
				.single(); // .toBlockingObservable() 版本调整

		System.out.println(artist);
        assertEquals(SampleData.johnLennon, artist);
    }

}
