package com.logmein.pokergameservice.service;

import com.logmein.pokergameservice.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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
    public Optional<Game> addDeck(String gameId, Deck deck) {
        log.info("Deck to Add in the Game: {} -> {}", gameId, deck);
        Game game = this.gameMap.get(gameId);

        if(game != null) {
            log.debug("Old Game Not Updated: {} ---> Map: {}", game, this.gameMap);

            GameDeck gameDeck = new GameDeck();
            gameDeck.addDeck(deck);

            game.setGameDeck(gameDeck);

            this.gameMap.replace(gameId, game);
            log.debug("New Game Updated: {} ---> Map: {}", game, this.gameMap);
        }

        return Optional.ofNullable(game);
    }

    @Override
    public Optional<Game> addPlayer(String gameId, List<Player> playerList) {
        log.info("Player to Add in the Game: {} -> {}", gameId, playerList);
        Game game = this.gameMap.get(gameId);
        if(game != null) {
            log.debug("Old Game Not Updated: {} ---> Map: {}", game, this.gameMap);

            game.setPlayerList(playerList);

            this.gameMap.replace(gameId, game);
            log.debug("New Game Updated: {} ---> Map: {}", game, this.gameMap);
        }

        return Optional.ofNullable(game);
    }

    @Override
    public void deletePlayer(String gameId, String playerId) {
        log.info("Player to Delete in the Game: {} --> Player Id: {}", gameId, playerId);
        Game game = this.gameMap.get(gameId);

        Player foundPlayer = game.getPlayerList()
               .stream()
               .filter(player -> player.getId().equals(playerId))
               .findFirst()
               .get();

        game.getPlayerList().remove(foundPlayer);
    }

    @Override
    public Optional<Game> dealCards(String gameId, String playerId) {
        log.info("Deal Cards: {} --> Player Id: {}", gameId, playerId);
        Game game = this.gameMap.get(gameId);
        if(game != null) {
            game.dealCards(Integer.valueOf(playerId));
        }

        return Optional.ofNullable(game);
    }

    @Override
    public Optional<List<Card>> getCardListFromAPlayer(String gameId, String playerId) {
        log.info("Get Cards From Player: {} --> Player Id: {}", gameId, playerId);
        Game game = this.gameMap.get(gameId);
        Player foundPlayer = game.getPlayerList()
                .stream()
                .filter(player -> player.getId().equals(playerId))
                .findFirst()
                .get();

        return Optional.ofNullable(foundPlayer.getHand());
    }

    @Override
    public Optional<List<Player>> getPlayersListAndTheirScore(String gameId) {
        return Optional.empty();
    }

    @Override
    public void shuffleCards(String gameId) {
        log.info("Deal Cards: {}", gameId);
        Game game = this.gameMap.get(gameId);
        if(game != null) {
            game.getGameDeck().shuffle();
        }
    }

    @Override
    public Optional<Map<Card, Integer>> getRemainingCards(String gameId) {
        return Optional.empty();
    }

    @Override
    public Optional<Map<Suit, Integer>> getQtyCardsPerSuitUndealt(String gameId) {
        return Optional.empty();
    }

}
