package com.logmein.pokergameservice.model;

public enum Suit {
    SPADE(1),
    HEART(2),
    CLUB(3),
    DIAMOND(4);

    private int value;

    Suit(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
}
