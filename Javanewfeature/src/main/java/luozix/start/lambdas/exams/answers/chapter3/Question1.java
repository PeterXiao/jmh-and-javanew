package luozix.start.lambdas.exams.answers.chapter3;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;

import luozix.start.lambdas.exams.examples.chapter1.Album;
import luozix.start.lambdas.exams.examples.chapter1.Artist;

public class Question1 {
    public static int addUp(Stream<Integer> numbers) {
        return numbers.reduce(0, (acc, x) -> acc + x);
    }

    public static List<String> getNamesAndOrigins(List<Artist> artists) {
        return artists.stream()
                      .flatMap(artist -> Stream.of(artist.getName(), artist.getNationality()))
                      .collect(toList());
    }

    public static List<Album> getAlbumsWithAtMostThreeTracks(List<Album> input) {
        return input.stream()
                    .filter(album -> album.getTrackList().size() <= 3)
                    .collect(toList());
    }
}
