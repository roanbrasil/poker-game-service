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
       this.shuffle();
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

    public void shuffle(){
        Random rnd = new Random();
        for (int i = cardList.size() - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Card card = cardList.get(index);
            cardList.set(index, cardList.get(i));
            cardList.set(i, card);
        }
    }
}
