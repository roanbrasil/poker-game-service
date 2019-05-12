package com.logmein.pokergameservice.model;

import java.util.Optional;

public interface IDeck {

    Optional<Card> deal();
    int size();
    boolean contains(final Card card);
    void shuffle();
}
