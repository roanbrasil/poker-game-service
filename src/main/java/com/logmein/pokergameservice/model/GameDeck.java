package com.logmein.pokergameservice.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GameDeck {

    private List<Card> deck;

    public GameDeck(){
        this.deck = new ArrayList<>();
    }

    public void addDeck(Deck deck){
        this.deck.addAll(deck.getCardList());
    }

}
