package com.logmein.pokergameservice.service;

import com.logmein.pokergameservice.model.Game;

public interface IGameService {

    void create(Game game);

    void delete(String id);

}
