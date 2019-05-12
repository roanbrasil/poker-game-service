package com.logmein.pokergameservice.service;

import com.logmein.pokergameservice.model.Game;
import com.logmein.pokergameservice.model.IGame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class GameService implements IGameService {

    Map<String, IGame> gameMap;


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
}
