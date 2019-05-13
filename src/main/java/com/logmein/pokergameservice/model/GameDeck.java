package com.logmein.pokergameservice.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class GameDeck {

    private List<Card> deck;

    public GameDeck(){
        this.deck = new ArrayList<>();
    }

    public void addDeck(Deck deck){
        this.deck.addAll(deck.getCardList());
        this.shuffle();
    }

    public void shuffle(){
        Random rnd = new Random();
        for (int i = deck.size() - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Card card = deck.get(index);
            deck.set(index, deck.get(i));
            deck.set(i, card);
        }
    }

}
