package com.logmein.model;

public enum Suit {
    HEART(4),
    SPADE(3),
    CLUB(2),
    DIAMOND(1);

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
