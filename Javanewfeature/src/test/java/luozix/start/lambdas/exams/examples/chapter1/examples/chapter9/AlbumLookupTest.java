package luozix.start.lambdas.exams.examples.chapter1.examples.chapter9;


import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import org.junit.Test;

import luozix.start.lambdas.exams.examples.chapter1.Album;
import luozix.start.lambdas.exams.examples.chapter1.Artist;
import luozix.start.lambdas.exams.examples.chapter1.SampleData;
import luozix.start.lambdas.exams.examples.chapter1.Track;
import luozix.start.lambdas.exams.examples.chapter9.AlbumLookup;
import luozix.start.lambdas.exams.examples.chapter9.CompletableAlbumLookup;
import luozix.start.lambdas.exams.examples.chapter9.FutureAlbumLookup;

public class AlbumLookupTest {

    interface AlbumLookupFactory extends BiFunction<List<Track>, List<Artist>, AlbumLookup> {

    }

    @Test
    public void albumLookedUp() {
        Album album = SampleData.aLoveSupreme;
        List<Track> trackList = album.getTrackList();
        List<Artist> musicianList = album.getMusicianList();

        AlbumLookupFactory completable = CompletableAlbumLookup::new;
        AlbumLookupFactory future = FutureAlbumLookup::new;

        Stream.of(completable, future)
              .forEach(factory -> {
 AlbumLookup lookup = factory.apply(trackList, musicianList);
                  System.out.println("Testing: " + lookup.getClass().getSimpleName());
                  Album result = lookup.lookupByName(album.getName());

                  assertEquals(trackList, result.getTrackList());
                  assertEquals(musicianList, result.getMusicianList());
              });
    }

}
