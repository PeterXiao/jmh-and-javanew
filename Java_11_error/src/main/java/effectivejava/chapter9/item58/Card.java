package effectivejava.chapter9.item58;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Card {
	private final Suit suit;
	private final Rank rank;

	// Can you spot the bug?
	enum Suit {
		CLUB, DIAMOND, HEART, SPADE
	}

	enum Rank {
		ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
	}

	static Collection<Suit> suits = Arrays.asList(Suit.values());
	static Collection<Rank> ranks = Arrays.asList(Rank.values());

	Card(final Suit suit, final Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public static void main(final String[] args) {
		final List<Card> deck = new ArrayList<>();

		for (final Suit suit2 : suits) {
			for (final Rank rank2 : ranks) {
				deck.add(new Card(suit2, rank2));
			}
		}

//        // Preferred idiom for nested iteration on collections and arrays
//        for (Suit suit : suits)
//            for (Rank rank : ranks)
//                deck.add(new Card(suit, rank));
	}
}
