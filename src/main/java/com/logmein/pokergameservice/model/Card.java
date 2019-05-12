package com.logmein.pokergameservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Card {//implements Comparable<Card>{

    private Suit suit;
    private Rank rank;

//    private final static Map<String, Card> CACHE = createCache();
//
//    private static Map<String, Card> createCache() {
//        final Map<String, Card> cache = new HashMap<>();
//        for (final Suit suit : Suit.values()) {
//            for (final Rank rank : Rank.values()) {
//                cache.put(concatSuitAndRank(suit, rank), new Card(suit, rank));
//            }
//        }
//        return Collections.unmodifiableMap(cache);
//    }
//
//    static Card getCard(final Rank rank,
//                        final Suit suit) {
//        final Card card = CACHE.get(concatSuitAndRank(suit, rank));
//        if (card != null) {
//            return card;
//        }
//        throw new RuntimeException("Null Card is not accept " + rank + " " + suit);
//    }

    public String concatSuitAndRank() {
        return this.suit + " " + this.rank.getValue();
    }

//    @Override
//    public int compareTo(Card o) {
//        final int rankComparison = Integer.compare(this.rank.getValue(), o.rank.getValue());
//        return rankComparison != 0 ? rankComparison : Integer.compare(this.suit.getValue(), o.suit.getValue());
//    }
//
//    @Override
//    public boolean equals(final Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        final Card card = (Card) o;
//        return this.rank == card.rank && this.suit == card.suit;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = this.rank != null ? this.rank.hashCode() : 0;
//        result = 31 * result + (this.suit != null ? this.suit.hashCode() : 0);
//        return result;
//    }
}
