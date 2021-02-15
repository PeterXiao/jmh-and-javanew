package luozix.start.lambdas.exams.examples.chapter4;


import java.util.List;

import luozix.start.lambdas.exams.examples.chapter1.Album;

public abstract class Order {

    protected final List<Album> albums;

    public Order(List<Album> albums) {
        this.albums = albums;
    }

    public abstract long countRunningTime();

    public abstract long countMusicians();

    public abstract long countTracks();

}
