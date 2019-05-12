package com.logmein.pokergameservice.model;

import lombok.*;

import java.util.*;

@Getter
@ToString
public class Deck { //implements IDeck{

//    private Stack<Card> cardStack;

    private List<Card> cardList;

    public Deck(){
       this.cardList = createDeck();
       this.shuffle();
    }

    //Create a deck
    private List<Card> createDeck() {
        List<Card> cardList = new ArrayList<>();
        for(final Suit suit : Suit.values()) {
            for(final Rank rank : Rank.values()) {
//                cardStack.push(Card.getCard(rank, suit));
                cardList.add(new Card(suit, rank));
            }
        }

        return cardList;

    }

//    public Optional<Card> deal() {
//        return this.cardList.empty() ? Optional.empty() :
//                Optional.of(this.cardStack.pop());
//    }

    public int size(){
        return cardList.size();
    }

    public boolean contains(final Card card){
        return this.cardList.contains(card);
    }

    public void shuffle(){
        Random rnd = new Random();
        for (int i = cardList.size() - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Card card = cardList.get(index);
            cardList.set(index, cardList.get(i));
            cardList.set(i, card);
        }
    }

//    public static void main(String[] args) {
//        Deck deck = new Deck();
////        deck.cardList.forEach(System.out::println);
//        System.out.println(deck.cardList);
//        deck.shuffle();
//        System.out.println(deck.cardList);
////        deck.cardList.forEach(System.out::println);
//    }
}
