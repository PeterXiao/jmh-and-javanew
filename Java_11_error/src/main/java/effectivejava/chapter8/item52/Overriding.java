package effectivejava.chapter8.item52;

import java.util.List;

// Classification using method overrriding (Page 239)
public class Overriding {
    public static void main(final String[] args) {
	final List<Wine> wineList = List.of(new Wine(), new SparklingWine(), new Champagne());

	for (final Wine wine : wineList) {
	    System.out.println(wine.name());
	}
    }
}
