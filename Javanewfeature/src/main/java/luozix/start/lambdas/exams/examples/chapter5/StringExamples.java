package luozix.start.lambdas.exams.examples.chapter5;

import java.util.List;
import java.util.stream.Collectors;

import luozix.start.lambdas.exams.examples.chapter1.Artist;

public class StringExamples {

	public static String formatArtists(List<Artist> artists) {
		// BEGIN collectors_joining
		String result = artists.stream().map(Artist::getName).collect(Collectors.joining(", ", "[", "]"));
		// END collectors_joining
		return result;
	}

	public static String formatArtistsForLoop(List<Artist> artists) {
		// BEGIN for_loop
		StringBuilder builder = new StringBuilder("[");
		for (Artist artist : artists) {
			if (builder.length() > 1)
				builder.append(", ");

			String name = artist.getName();
			builder.append(name);
		}
		builder.append("]");
		String result = builder.toString();
		// END for_loop
		return result;
	}

	public static String formatArtistsRefactor1(List<Artist> artists) {
		// BEGIN refactor_1
		StringBuilder builder = new StringBuilder("[");
		artists.stream().map(Artist::getName).forEach(name -> {
			if (builder.length() > 1)
				builder.append(", ");

			builder.append(name);
		});
		builder.append("]");
		String result = builder.toString();
		// END refactor_1
		return result;
	}

	public static String formatArtistsRefactor2(List<Artist> artists) {
		// BEGIN refactor_2
		StringBuilder reduced = artists.stream().map(Artist::getName).reduce(new StringBuilder(), (builder, name) -> {
			if (builder.length() > 0)
				builder.append(", ");

			builder.append(name);
			return builder;
		}, (left, right) -> left.append(right));

		reduced.insert(0, "[");
		reduced.append("]");
		String result = reduced.toString();
		// END refactor_2
		return result;
	}

	public static String formatArtistsRefactor3(List<Artist> artists) {
		// BEGIN refactor_3
		StringCombiner combined = artists.stream().map(Artist::getName).reduce(new StringCombiner(", ", "[", "]"),
				StringCombiner::add, StringCombiner::merge);

		String result = combined.toString();
		// END refactor_3
		return result;
	}

	public static String formatArtistsRefactor4(List<Artist> artists) {
		// BEGIN refactor_4
		String result = artists.stream().map(Artist::getName)
				.reduce(new StringCombiner(", ", "[", "]"), StringCombiner::add, StringCombiner::merge).toString();
		// END refactor_4
		return result;
	}

	public static String formatArtistsRefactor5(List<Artist> artists) {
		// BEGIN refactor_5
		String result = artists.stream().map(Artist::getName).collect(new StringCollector(", ", "[", "]"));
		// END refactor_5
		return result;
	}

	public static String formatArtistsReducing(List<Artist> artists) {
		// BEGIN reducing
		String result = artists.stream().map(Artist::getName)
				.collect(Collectors.reducing(new StringCombiner(", ", "[", "]"),
						name -> new StringCombiner(", ", "[", "]").add(name), StringCombiner::merge))
				.toString();
		// END reducing
		return result;
	}

//	public Artist getArtist(String name) {
//		Artist artist = artistCache.get(name);
//		if (artist == null) {
//			artist = readArtistFromDB(name);
//			artistCache.put(name, artist);
//		}
//		return artist;
//	}
//
//	public Artist getArtist(String name) {
//		return artistCache.computeIfAbsent(name, this::readArtistFromDB);
//	}
	/*
	 * .reduce(, , StringCombiner::merge) .toString()
	 */

	public static void main(String[] args) {

//		StringBuilder builder = new StringBuilder("[");
//		for (Artist artist : artists) {
//			if (builder.length() > 1)
//				builder.append(", ");
//
//			String name = artist.getName();
//			builder.append(name);
//		}
//		builder.append("]");
//		String result = builder.toString();
//		String result = artists.stream().map(Artist::getName).collect(Collectors.joining(", ", "[", "]"));

//		Map<Artist, Integer> countOfAlbums = new HashMap<>();
//		for (Map.Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
//			Artist artist = entry.getKey();
//			List<Album> albums = entry.getValue();
//			countOfAlbums.put(artist, albums.size());
//		}
//		Map<Artist, Integer> countOfAlbums = new HashMap<>();
//		albumsByArtist.forEach((artist, albums) -> {
//			countOfAlbums.put(artist, albums.size());
//		});


	}
}
