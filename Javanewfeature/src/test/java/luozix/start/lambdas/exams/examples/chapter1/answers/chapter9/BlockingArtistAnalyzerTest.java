package luozix.start.lambdas.exams.examples.chapter1.answers.chapter9;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import luozix.start.lambdas.exams.answers.chapter9.BlockingArtistAnalyzer;

public class BlockingArtistAnalyzerTest {

	private final luozix.start.lambdas.exams.answers.chapter9.BlockingArtistAnalyzer analyser = new BlockingArtistAnalyzer(
			new FakeLookupService()::lookupArtistName);

    @Test
    public void largerGroupsAreLarger() {
        assertTrue(analyser.isLargerGroup("The Beatles", "John Coltrane"));
    }

    @Test
    public void smallerGroupsArentLarger() {
        assertFalse(analyser.isLargerGroup("John Coltrane", "The Beatles"));
    }

}
