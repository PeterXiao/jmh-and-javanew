package luozix.start.lambdas.exams.examples.chapter1.answers.chapter9;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import luozix.start.lambdas.exams.answers.chapter9.ArtistAnalyzer;
import luozix.start.lambdas.exams.answers.chapter9.CallbackArtistAnalyser;
import luozix.start.lambdas.exams.exercises.chapter9.CompletableFutureArtistAnalyser;

@RunWith(Parameterized.class)
public class ArtistAnalyzerTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        FakeLookupService lookupService = new FakeLookupService();
        Object[][] data = new Object[][] {
            { new CallbackArtistAnalyser(lookupService::lookupArtistName) },
            { new CompletableFutureArtistAnalyser(lookupService::lookupArtistName) },
        };
        return Arrays.asList(data);
    }

    private final ArtistAnalyzer analyser;

    public ArtistAnalyzerTest(ArtistAnalyzer analyser) {
        this.analyser = analyser;
    }

    @Test
    public void largerGroupsAreLarger() {
        assertLargerGroup(true, "The Beatles", "John Coltrane");
    }

    @Test
    public void smallerGroupsArentLarger() {
        assertLargerGroup(false, "John Coltrane", "The Beatles");
    }

    private void assertLargerGroup(boolean expected, String artistName, String otherArtistName) {
        AtomicBoolean isLarger = new AtomicBoolean(!expected);
        analyser.isLargerGroup(artistName, otherArtistName, isLarger::set);
        assertEquals(expected, isLarger.get());
    }

}
