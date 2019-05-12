package com.logmein.pokergameservice.controller;

import com.logmein.pokergameservice.model.Deck;
import com.logmein.pokergameservice.model.Game;
import com.logmein.pokergameservice.model.IGame;
import com.logmein.pokergameservice.service.IGameService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/game")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GameController {

    @Autowired
    IGameService gameService;

    @PostMapping("")
    public ResponseEntity<Void> create(@RequestBody Game game){
        this.gameService.create(game);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}/deck")
    public ResponseEntity<Game> addDeck(@PathVariable(value = "id") String id, @RequestBody Deck deck){
        Optional<Game> optionalGame = this.gameService.addDeck(id, deck);
        return optionalGame
                .map(game -> ResponseEntity.status(HttpStatus.CREATED).body(game))
                .orElseGet( () -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") String id){
        this.gameService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
