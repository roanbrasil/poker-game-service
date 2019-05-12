package com.logmein.pokergameservice.service;

import com.logmein.pokergameservice.model.Deck;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@Getter
public class DeckService implements IDeckService {

    Map<String, Deck> deckMap;

    @Autowired
    public DeckService(){
        this.deckMap = new HashMap<>();
    }

    @Override
    public void create(Deck deck) {
        log.info("Deck Added = {}", deck);
        this.deckMap.putIfAbsent(deck.getId(), deck);
    }
}
