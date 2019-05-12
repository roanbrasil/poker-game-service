package com.logmein.pokergameservice.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GameDeck {
//    private List<Deck> deckList;

    private List<Card> deck;

    public GameDeck(){
//        this.deckList = new ArrayList<>();
        this.deck = new ArrayList<>();
    }

    //Add a deck to a game deck
    //Please note that once a deck has been added to a game deck it cannot be removed.
    public void addDeck(Deck deck){
//        this.deckList.add(deck);
        this.deck.addAll(deck.getCardList());
    }

}
