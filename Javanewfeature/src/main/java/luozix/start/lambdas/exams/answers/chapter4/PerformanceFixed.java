package luozix.start.lambdas.exams.answers.chapter4;

import static java.util.stream.Stream.concat;

import java.util.stream.Stream;

import luozix.start.lambdas.exams.examples.chapter1.Artist;

/** A Performance by some musicians - eg an Album or Gig. */
public interface PerformanceFixed {

    public String getName();

    public Stream<Artist> getMusicians();

    public default Stream<Artist> getAllMusicians() {
        return getMusicians()
              .flatMap(artist -> concat(Stream.of(artist), artist.getMembers()));
    }

}
