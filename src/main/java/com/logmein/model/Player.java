package com.logmein.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@ToString
public class Player{

    @Setter
    private String id;
    private List<Card> hand;
    private int totalValue;

    public Player(){
        this.hand = new ArrayList<>();
        this.totalValue = 0;
    }

    public void add(int value){
        this.totalValue += value;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Card))
            return false;
        if (obj == this)
            return true;

        Player that = (Player)obj;
        return that.getId().equals(this.getId());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.getId());
    }
}
