package com.logmein.pokergameservice.controller;

import com.logmein.pokergameservice.model.*;
import com.logmein.pokergameservice.service.IGameService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/game")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GameController {

    @Autowired
    IGameService gameService;

    @PostMapping()
    public ResponseEntity<Void> create(@RequestBody Game game){
        this.gameService.create(game);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{gameId}/deck")
    public ResponseEntity<Game> addDeck(@PathVariable(value = "gameId") String gameId, @RequestBody Deck deck){
        Optional<Game> optionalGame = this.gameService.addDeck(gameId, deck);
        return optionalGame
                .map(game -> ResponseEntity.status(HttpStatus.CREATED).body(game))
                .orElseGet( () -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{gameId}/player")
    public ResponseEntity<Game> addPlayer(@PathVariable(value = "gameId") String gameId, @RequestBody List<Player> playerList){
        Optional<Game> optionalGame = this.gameService.addPlayer(gameId, playerList);
        return optionalGame
                .map(game -> ResponseEntity.status(HttpStatus.CREATED).body(game))
                .orElseGet( () -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{gameId}/player/{playerId}/deal")
    public ResponseEntity<Game> dealCards(@PathVariable(value = "gameId") String gameId, @PathVariable(value = "playerId") String playerId){
        Optional<Game> optionalGame = this.gameService.dealCards(gameId, playerId);

        return optionalGame
                .map(game -> ResponseEntity.status(HttpStatus.CREATED).body(game))
                .orElseGet( () -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{gameId}/player/{playerId}")
    public ResponseEntity<List<Card>> getCardListFromAPlayer(@PathVariable(value = "gameId") String gameId, @PathVariable(value = "playerId") String playerId){
        Optional<List<Card>> optionalCardList = this.gameService.getCardListFromAPlayer(gameId, playerId);

        return optionalCardList
                .map(cardList -> ResponseEntity.status(HttpStatus.CREATED).body(cardList))
                .orElseGet( () -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{gameId}/player/")
    public ResponseEntity<List<Player>> getPlayersListAndTheirScore(@PathVariable(value = "gameId") String gameId){
        Optional<List<Player>> optionalPlayerList = this.gameService.getPlayersListAndTheirScore(gameId);

        return optionalPlayerList
                .map(players -> ResponseEntity.status(HttpStatus.CREATED).body(players))
                .orElseGet( () -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{gameId}/deck")
    public ResponseEntity<Map<Suit, Integer>> getQtyCardsPerSuitUndealt(@PathVariable(value = "gameId") String gameId){
        Optional<Map<Suit, Integer>> optionalSuitUndealt = this.gameService.getQtyCardsPerSuitUndealt(gameId);

        return optionalSuitUndealt
                .map(suitUndealt -> ResponseEntity.status(HttpStatus.CREATED).body(suitUndealt))
                .orElseGet( () -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{gameId}/deck/cards")
    public ResponseEntity<Map<Card, Integer>> getRemainingCards(@PathVariable(value = "gameId") String gameId){
        Optional<Map<Card, Integer>> optionalRemainingCards = this.gameService.getRemainingCards(gameId);

        return optionalRemainingCards
                .map(remainingCards -> ResponseEntity.status(HttpStatus.CREATED).body(remainingCards))
                .orElseGet( () -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{gameId}/shuffle")
    public ResponseEntity<Void> shuffleCards(@PathVariable(value = "gameId") String gameId){
        this.gameService.shuffleCards(gameId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{gameId}/player/{playerId}")
    public ResponseEntity<Void> deletePlayer(@PathVariable(value = "gameId") String gameId, @PathVariable(value = "playerId") String playerId){
        this.gameService.deletePlayer(gameId, playerId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @DeleteMapping("/{gameId}")
    public ResponseEntity<Void> delete(@PathVariable(value = "gameId") String gameId){
        this.gameService.delete(gameId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
