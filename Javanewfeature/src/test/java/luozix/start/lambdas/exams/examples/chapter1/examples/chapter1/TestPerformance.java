package luozix.start.lambdas.exams.examples.chapter1.examples.chapter1;

import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toSet;
import static junit.framework.Assert.assertEquals;
import static luozix.start.lambdas.exams.examples.chapter1.SampleData.theBeatles;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import luozix.start.lambdas.exams.examples.chapter1.Album;
import luozix.start.lambdas.exams.examples.chapter1.Artist;
import luozix.start.lambdas.exams.examples.chapter1.SampleData;
import luozix.start.lambdas.exams.examples.chapter1.Track;

public class TestPerformance {

    @Test
    public void allMembers() {
        Album album = new Album("foo", Collections.<Track>emptyList(), singletonList(theBeatles));
        Set<Artist> musicians = album.getAllMusicians().collect(toSet());
        Set<Artist> expectedMusicians = new HashSet<>(SampleData.membersOfTheBeatles);
        expectedMusicians.add(theBeatles);
        assertEquals(expectedMusicians, musicians);
    }

}
