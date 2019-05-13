package com.logmein.model;

import lombok.*;

import java.util.*;

import static java.util.Comparator.comparingInt;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    private String id;
    private List<Player> playerList;
    private GameDeck gameDeck;

    public void addPlayerList(List<Player> playerList){
        this.playerList.addAll(playerList);
    }

    public void removePlayerList(List<Player> playerList){
        this.playerList.removeAll(playerList);
    }

    public List<Card> getCardsByPlayer(int index){
        return this.playerList.get(index).getHand();
    }

    public void dealCards(int indexPlayer){
        if(!gameDeck.getDeck().isEmpty()){
            Card card = gameDeck.getDeck().get(0);
            gameDeck.getDeck().remove(0);

            this.playerList.get(indexPlayer-1)
                    .add(card.getRank()
                            .getValue());

            this.playerList.get(indexPlayer-1)
                    .getHand()
                    .add(card);
        }
    }

    public List<Player> orderByDescPlayerScore(){
        List<Player> playerList = new ArrayList<>(this.playerList);
         playerList
                 .sort(comparingInt(Player::getTotalValue)
                         .reversed());
         return playerList;
    }

    public Map<Suit, Integer> countCardsBySuit(){
        Map<Suit, Integer> resultCardsBySuit = new HashMap<>();
        gameDeck.getDeck().forEach( card -> resultCardsBySuit.put(card.getSuit(),
                resultCardsBySuit.get(card.getSuit()) != null ? resultCardsBySuit.get(card.getSuit()) + 1 : 1 ));

        return resultCardsBySuit;
    }

    public Map<Card, Integer> countRemainingCards(){
        LinkedHashMap<Card, Integer> remainingCards = new LinkedHashMap<>();

        List<Card> cardList = new ArrayList<>(gameDeck.getDeck());
        Collections.sort(cardList);

        for(Card card : cardList){
            remainingCards.put(card,
                    remainingCards.get(card) != null ? remainingCards.get(card) + 1 : 1);
        }

        return remainingCards;
    }
}