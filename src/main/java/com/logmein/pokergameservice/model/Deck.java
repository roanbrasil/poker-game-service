package com.logmein.pokergameservice.model;

import lombok.*;

import java.util.Collections;
import java.util.Optional;
import java.util.Stack;

@Getter
@ToString
public class Deck implements IDeck{

    private Stack<Card> cardStack;

    public Deck(){
        this(false);
    }

    public Deck(final boolean mustShuffle){
       this.cardStack = createDeck(mustShuffle);
    }

    private Stack<Card> createDeck(boolean mustShuffle) {
        Stack<Card> cardStack = new Stack<>();
        for(final Suit suit : Suit.values()) {
            for(final Rank rank : Rank.values()) {
                cardStack.push(Card.getCard(rank, suit));
            }
        }

        if(mustShuffle) {
            this.shuffle();
        }

        return cardStack;

    }

    public Optional<Card> deal() {
        return this.cardStack.empty() ? Optional.empty() :
                Optional.of(this.cardStack.pop());
    }

    public int size(){
        return cardStack.size();
    }

    public boolean contains(final Card card){
        return this.cardStack.contains(card);
    }

    public void shuffle(){
        Collections.shuffle(cardStack);
    }
}
