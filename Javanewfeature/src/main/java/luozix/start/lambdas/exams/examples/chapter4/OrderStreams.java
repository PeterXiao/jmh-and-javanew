package luozix.start.lambdas.exams.examples.chapter4;


import java.util.List;

import luozix.start.lambdas.exams.examples.chapter1.Album;

public class OrderStreams extends Order {

    public OrderStreams(List<Album> albums) {
        super(albums);
    }

    // BEGIN body
@Override
public long countRunningTime() {
    return albums.stream()
            .mapToLong(album -> album.getTracks()
                                     .mapToLong(track -> track.getLength())
                                     .sum())
            .sum();
}

@Override
public long countMusicians() {
    return albums.stream()
            .mapToLong(album -> album.getMusicians().count())
            .sum();
}

@Override
public long countTracks() {
    return albums.stream()
            .mapToLong(album -> album.getTracks().count())
            .sum();
}
    // END body

}
