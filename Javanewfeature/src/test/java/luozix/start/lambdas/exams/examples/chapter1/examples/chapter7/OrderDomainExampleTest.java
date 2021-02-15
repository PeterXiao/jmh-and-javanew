package luozix.start.lambdas.exams.examples.chapter1.examples.chapter7;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import luozix.start.lambdas.exams.examples.chapter1.Album;
import luozix.start.lambdas.exams.examples.chapter4.OrderDomain;

/**
 * Sample code for chapter7 OrderDomain from the
 * previous chapter.
 */
public class OrderDomainExampleTest {

    // BEGIN can_count_albums
    @Test
    public void canCountFeatures() {
        OrderDomain order = new OrderDomain(asList(
                newAlbum("Exile on Main St."),
                newAlbum("Beggars Banquet"),
                newAlbum("Aftermath"),
                newAlbum("Let it Bleed")));

        assertEquals(8, order.countFeature(album -> 2));
    }
    // END can_count_albums

	private Album newAlbum(String name) {
		return new Album(name, emptyList(), emptyList());
	}

//	public long countFeature(ToLongFunction<Album> function) {
//		return albums.stream().mapToLong(function).sum();
//	}
//
//	public long countTracks() {
//		return countFeature(album -> album.getTracks().count());
//	}
//
//	public long countRunningTime() {
//		return countFeature(album -> album.getTracks().mapToLong(track -> track.getLength()).sum());
//	}
//
//	public long countMusicians() {
//		return countFeature(album -> album.getMusicians().count());
//	}

}
