package luozix.start.lambdas.exams.exercises.chapter4;



import java.util.stream.Stream;

import luozix.start.lambdas.exams.answers.chapter4.ArtistsFixed;
import luozix.start.lambdas.exams.examples.chapter1.Artist;
import luozix.start.lambdas.exams.exercises.Exercises;

/** A Performance by some musicians - eg an Album or Gig. */
public interface PerformanceFixed {

    public String getName();

    public Stream<ArtistsFixed> getMusicians();

    public default Stream<Artist> getAllMusicians() {
        return Exercises.replaceThisWithSolution();
    }

}
