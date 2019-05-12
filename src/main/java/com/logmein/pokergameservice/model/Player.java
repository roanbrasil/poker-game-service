package com.logmein.pokergameservice.model;


import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Player{
    private List<Card> hand;
    private int totalValue;

    public Player(){
        this.hand = new ArrayList<>();
        this.totalValue = 0;
    }
    public void add(int value){
        this.totalValue += value;
    }
}
