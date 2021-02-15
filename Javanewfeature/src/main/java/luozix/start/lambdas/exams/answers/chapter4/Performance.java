package luozix.start.lambdas.exams.answers.chapter4;

import java.util.stream.Stream;

import luozix.start.lambdas.exams.examples.chapter1.Artist;

/** A Performance by some musicians - e.g., an Album or Gig. */
public interface Performance {

    public String getName();

    public Stream<Artist> getMusicians();

}