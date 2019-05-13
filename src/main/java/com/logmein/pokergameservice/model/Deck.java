package com.logmein.pokergameservice.model;

import lombok.*;

import java.util.*;

@Getter
@ToString
public class Deck {

    @Setter
    private String id;
    private List<Card> cardList;

    public Deck(){
       this.cardList = createDeck();
    }

    private List<Card> createDeck() {
        List<Card> cardList = new ArrayList<>();
        for(final Suit suit : Suit.values()) {
            for(final Rank rank : Rank.values()) {
                cardList.add(new Card(suit, rank));
            }
        }

        return cardList;

    }
}
