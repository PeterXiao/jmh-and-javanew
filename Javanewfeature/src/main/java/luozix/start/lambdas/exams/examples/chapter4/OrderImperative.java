package luozix.start.lambdas.exams.examples.chapter4;


import java.util.List;

import luozix.start.lambdas.exams.examples.chapter1.Album;
import luozix.start.lambdas.exams.examples.chapter1.Track;

public class OrderImperative extends Order {

    public OrderImperative(List<Album> albums) {
        super(albums);
    }

    // BEGIN body
@Override
public long countRunningTime() {
    long count = 0;
    for (Album album : albums) {
        for (Track track : album.getTrackList()) {
            count += track.getLength();
        }
    }
    return count;
}

@Override
public long countMusicians() {
    long count = 0;
    for (Album album : albums) {
        count += album.getMusicianList().size();
    }
    return count;
}

@Override
public long countTracks() {
    long count = 0;
    for (Album album : albums) {
        count += album.getTrackList().size();
    }
    return count;
}
    // END body

}
