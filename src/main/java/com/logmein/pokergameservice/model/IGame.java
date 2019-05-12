package com.logmein.pokergameservice.model;

import java.util.List;
import java.util.Map;

public interface IGame {

    void addPlayer(Player player);
    void removePlayer(Player player);
    List<Card> getCardsByPlayer(int index);
    void dealCards(int indexPlayer);
    List<Player> orderByDescPlayerScore();
    Map<Suit, Integer> countCardsBySuit();
    Map<Card, Integer> countRemainingCards();
}
