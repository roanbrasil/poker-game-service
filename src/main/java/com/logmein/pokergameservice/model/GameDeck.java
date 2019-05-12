package com.logmein.pokergameservice.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GameDeck {
    private List<Deck> deckList;

    public GameDeck(){
        deckList = new ArrayList<>();
    }


}
