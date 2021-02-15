package luozix.start.lambdas.exams.exercises.chapter9;

import java.util.function.Consumer;
import java.util.function.Function;

import luozix.start.lambdas.exams.examples.chapter1.Artist;
import luozix.start.lambdas.exams.exercises.Exercises;

public class CallbackArtistAnalyser implements ArtistAnalyzer {

    private final Function<String, Artist> artistLookupService;

    public CallbackArtistAnalyser(Function<String, Artist> artistLookupService) {
        this.artistLookupService = artistLookupService;
    }

    @Override
	public void isLargerGroup(String artistName, String otherArtistName, Consumer<Boolean> handler) {
        Exercises.replaceThisWithSolution();
    }

    private long getNumberOfMembers(String artistName) {
        return Exercises.replaceThisWithSolution();
    }

}
