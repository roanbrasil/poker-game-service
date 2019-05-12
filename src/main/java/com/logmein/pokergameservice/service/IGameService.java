package com.logmein.pokergameservice.service;

import com.logmein.pokergameservice.model.Deck;
import com.logmein.pokergameservice.model.Game;

import java.util.Optional;

public interface IGameService {

    void create(Game game);

    void delete(String id);

    Optional<Game> addDeck(String id, Deck deck);

}
