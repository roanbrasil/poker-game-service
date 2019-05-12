package com.logmein.pokergameservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.SortedSet;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    public final static int NUMBER_CARDS_IN_HAND = 2;
    private String name;
    private SortedSet<Card> hand;
}
