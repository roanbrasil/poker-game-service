package com.logmein.service;

import com.logmein.model.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IGameService {

    void create(Game game);

    void delete(String id);

    Optional<Game> addDeck(String gameId, Deck deck);

    Optional<Game> addPlayer(String gameId, List<Player> player);

    void deletePlayer(String gameId, String playerId);

    Optional<Game> dealCards(String gameId, String playerId);

    Optional<List<Card>> getCardListFromAPlayer(String gameId, String playerId);

    Optional<List<Player>> getPlayersListAndTheirScore(String gameId);

    void shuffleCards(String gameId);

    Optional<Map<Card, Integer>> getRemainingCards(String gameId);

    Optional<Map<Suit, Integer>> getQtyCardsPerSuitUndealt(String gameId);
}
