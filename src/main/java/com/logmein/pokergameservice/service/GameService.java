package com.logmein.pokergameservice.service;

import com.logmein.pokergameservice.model.Deck;
import com.logmein.pokergameservice.model.Game;
import com.logmein.pokergameservice.model.GameDeck;
import com.logmein.pokergameservice.model.IGame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
public class GameService implements IGameService {

    Map<String, Game> gameMap;


    @Autowired
    public GameService(){
        this.gameMap = new HashMap<>();
    }

    @Override
    public void create(Game game) {
        log.info("Game Added: {}", game);
        this.gameMap.putIfAbsent(game.getId(), game);
    }

    @Override
    public void delete(String id) {
        log.info("Game Deleted: {} -> {}", id, this.gameMap.get(id));
        this.gameMap.remove(id);
    }

    @Override
    public Optional<Game> addDeck(String id, Deck deck) {
        log.info("Game Deleted: {} -> {}", id, deck);
        Game game = this.gameMap.get(id);

        if(game != null) {
            log.debug("Old Game Not Updated: {} ---> Map: {}", game, this.gameMap);

            GameDeck gameDeck = new GameDeck();
            gameDeck.addDeck(deck);

            game.setGameDeck(gameDeck);

            this.gameMap.replace(id, game);
            log.debug("New Game Updated: {} ---> Map: {}", game, this.gameMap);
        }

        return Optional.ofNullable(game);
    }
}
