package com.logmein.pokergameservice.model;

import lombok.Getter;

import java.util.*;

import static java.util.Comparator.comparingInt;

@Getter
public class Game {

    private List<Player> playerList;
    private GameDeck gameDeck;

    public Game(GameDeck gameDeck){
        this.playerList = new ArrayList<>();
        this.gameDeck = gameDeck;
    }

    public void addPlayer(Player player){
        this.playerList.add(player);
    }

    public void removePlayer(Player player){
        this.playerList.remove(player);
    }

    public List<Card> getCardsByPlayer(int index){
        return this.playerList.get(index).getHand();
    }

    public void dealCards(int indexPlayer){
        Card card;
//        for(Deck deck: gameDeck.getDeckList()){
            if(!gameDeck.getDeck().isEmpty()){
                card = gameDeck.getDeck().get(0);
                gameDeck.getDeck().remove(0);
                this.playerList.get(indexPlayer-1).add(card.getRank().getValue());
                this.playerList.get(indexPlayer-1).getHand().add(card);
            }
//        }
    }

    public List<Player> orderByDescPlayerScore(){
         List<Player> playerList = new ArrayList<>();
         playerList.addAll(this.playerList);
         playerList.sort(comparingInt(Player::getTotalValue).reversed());
         return playerList;
    }

    public Map<Suit, Integer> countCardsBySuit(){
        Map<Suit, Integer> resultCardsBySuit = new HashMap<>();
        gameDeck.getDeck().forEach( card -> {
            resultCardsBySuit.put(card.getSuit(),
                    resultCardsBySuit.get(card.getSuit()) != null ?
                            resultCardsBySuit.get(card.getSuit())+1 : 1 );

        });

        return resultCardsBySuit;
    }


    public static void main(String[] args) {
        Deck deck = new Deck();
        GameDeck gameDeck = new GameDeck();
        gameDeck.addDeck(deck);
        Deck deck2 = new Deck();
        gameDeck.addDeck(deck2);
        Game game = new Game(gameDeck);


        game.addPlayer(new Player());
        game.addPlayer(new Player());
        for(int i = 0; i < 52; i++){
            game.dealCards(1);
        }

        for(int i = 0; i <= 30; i++){
            game.dealCards(2);
        }
//        System.out.println(game.playerList);
        System.out.println(game.playerList.get(0).getHand().size());
        System.out.println(game.orderByDescPlayerScore().get(0));
        System.out.println(game.orderByDescPlayerScore().get(1));
        System.out.println(game.orderByDescPlayerScore().get(0).getTotalValue());
        System.out.println(game.orderByDescPlayerScore().get(1).getTotalValue());
        System.out.println(game.countCardsBySuit());

    }
}