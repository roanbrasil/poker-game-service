package com.logmein.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
@AllArgsConstructor
public class Card implements Comparable<Card>{

    private Suit suit;
    private Rank rank;

    @Override
    public int compareTo(Card card) {
        return Integer.compare(card.suit.getValue() + (card.rank.getValue() * 10),
                this.suit.getValue() + (this.rank.getValue() * 10));
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Card))
            return false;
        if (obj == this)
            return true;

        Card that = (Card)obj;
        return that.getRank() == getRank()
                && that.getSuit() == getSuit();
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getRank(), getSuit());
    }
}
