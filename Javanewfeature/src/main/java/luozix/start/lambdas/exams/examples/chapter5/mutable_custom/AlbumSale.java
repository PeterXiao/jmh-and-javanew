package luozix.start.lambdas.exams.examples.chapter5.mutable_custom;

import luozix.start.lambdas.exams.examples.chapter1.Album;

public final class AlbumSale {

    private final Album album;
    private final Customer customer;
    private final long price;

    public AlbumSale(Album album, Customer customer, long price) {
        this.album = album;
        this.customer = customer;
        this.price = price;
    }

    public Album getAlbum() {
        return album;
    }

    public Customer getCustomer() {
        return customer;
    }

    public long getPrice() {
        return price;
    }
}
