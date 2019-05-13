### Requirements

Java 10 and Maven

### A Basic Deck of Cards Game

Your assignment is to code, in Java a set of classes and a REST API that represent a deck of poker-style playing cards along with the services for a very basic game between multiple players holding cards. A deck is defined as follows:  Fifty-two playing cards in four suits: hearts, spades, clubs, and diamonds, with face values of Ace, 2-10, Jack, Queen, and King.

 

The game API is a very basic game in which one or more decks are added to create a ‘game deck’, commonly referred to as a shoe, along with a group of players getting cards from the game deck.

 

You must provide the following operations:

 

* Create and delete a game
* Create a deck
* Add a deck to a game deck
  * Please note that once a deck has been added to a game deck it cannot be removed.
* Add and remove players from a game
* Deal cards to a player in a game from the game deck
  * Specifically, for a game deck containing only one deck of cards, a call to shuffle followed by 52 calls to dealCards(1) for the same player should result in the caller being provided all 52 cards of the deck in a random order. If the caller then makes a 53rd call to dealCard(1), no card is dealt. This approach is to be followed if the game deck contains more than one deck.
* Get the list of cards for a player
* Get the list of players in a game along with the total added value of all the cards each player holds; use face values of cards only. Then sort the list in descending order, from the player with the highest value hand to the player with the lowest value hand:
  * For instance if player ‘A’ holds a 10 + King then her total value is 23 and player ‘B’ holds a 7 + Queen then his total value is 19,  so player ‘A’ will be listed first followed by player ‘B’.
* Get the count of how many cards per suit are left undealt in the game deck (example: 5 hearts, 3 spades, etc.)
* Get the count of each card (suit and value) remaining in the game deck sorted by suit ( hearts, spades, clubs, and diamonds) and face value from high value to low value (King, Queen, Jack, 10….2, Ace with value of 1)
* Shuffle the game deck (shoe)
  * Shuffle returns no value, but results in the cards in the game deck being randomly permuted. Please do not use library-provided “shuffle” operations to implement this function. You may use library- provided random number generators in your solution.
  * Shuffle can be called at any time
 

 

 

The structure of the REST API is up to you but please consider the combination of resources and actions represented by this problem and make appropriate tradeoffs in compliance to strict REST doctrine.

 

We have intentionally left many details of this assignment vague. You should follow the principle of least surprise in making reasonable decisions regarding the implementation.

 

While this is a trivial assignment, pretend that this code will become a foundational part of a new product. Take whatever measures you feel are required for your code to meet this bar within the scope of the allotted time and be prepared to discuss the tradeoffs you made.

### How to Run Each Method

#### Post Method
````
localhost:8080/game
````
Return 201 - Created

#### Post Method
````
localhost:8080/deck

JSON in the body
{
  "id": "12345"
}
````

Return 201 - Created

#### Put Method
````
localhost:8080/game/12345/deck

JSON in the body Request
{
  "id": "12345"
}

Json in the body Response
{
    "id": "12345",
    "playerList": null,
    "gameDeck": {
        "deck": [
            {
                "suit": "DIAMOND",
                "rank": "FOUR"
            },
            {
                "suit": "SPADE",
                "rank": "EIGHT"
            },
            {
                "suit": "SPADE",
                "rank": "TEN"
            },
            {
                "suit": "DIAMOND",
                "rank": "TEN"
            },
            {
                "suit": "HEART",
                "rank": "QUEEN"
            },
            {
                "suit": "SPADE",
                "rank": "TWO"
            },
            {
                "suit": "CLUB",
                "rank": "EIGHT"
            },
            {
                "suit": "DIAMOND",
                "rank": "KING"
            },
            {
                "suit": "CLUB",
                "rank": "TEN"
            },
            {
                "suit": "DIAMOND",
                "rank": "THREE"
            },
            {
                "suit": "DIAMOND",
                "rank": "NINE"
            },
            {
                "suit": "HEART",
                "rank": "FOUR"
            },
            {
                "suit": "CLUB",
                "rank": "ACE"
            },
            {
                "suit": "SPADE",
                "rank": "FIVE"
            },
            {
                "suit": "HEART",
                "rank": "SEVEN"
            },
            {
                "suit": "DIAMOND",
                "rank": "FIVE"
            },
            {
                "suit": "CLUB",
                "rank": "FIVE"
            },
            {
                "suit": "HEART",
                "rank": "KING"
            },
            {
                "suit": "CLUB",
                "rank": "TWO"
            },
            {
                "suit": "HEART",
                "rank": "FIVE"
            },
            {
                "suit": "DIAMOND",
                "rank": "EIGHT"
            },
            {
                "suit": "HEART",
                "rank": "EIGHT"
            },
            {
                "suit": "DIAMOND",
                "rank": "JACK"
            },
            {
                "suit": "DIAMOND",
                "rank": "SEVEN"
            },
            {
                "suit": "CLUB",
                "rank": "THREE"
            },
            {
                "suit": "SPADE",
                "rank": "ACE"
            },
            {
                "suit": "CLUB",
                "rank": "JACK"
            },
            {
                "suit": "HEART",
                "rank": "THREE"
            },
            {
                "suit": "HEART",
                "rank": "SIX"
            },
            {
                "suit": "HEART",
                "rank": "TWO"
            },
            {
                "suit": "HEART",
                "rank": "ACE"
            },
            {
                "suit": "SPADE",
                "rank": "KING"
            },
            {
                "suit": "SPADE",
                "rank": "QUEEN"
            },
            {
                "suit": "DIAMOND",
                "rank": "SIX"
            },
            {
                "suit": "SPADE",
                "rank": "FOUR"
            },
            {
                "suit": "CLUB",
                "rank": "NINE"
            },
            {
                "suit": "DIAMOND",
                "rank": "QUEEN"
            },
            {
                "suit": "HEART",
                "rank": "NINE"
            },
            {
                "suit": "HEART",
                "rank": "JACK"
            },
            {
                "suit": "SPADE",
                "rank": "NINE"
            },
            {
                "suit": "CLUB",
                "rank": "KING"
            },
            {
                "suit": "CLUB",
                "rank": "SIX"
            },
            {
                "suit": "CLUB",
                "rank": "SEVEN"
            },
            {
                "suit": "DIAMOND",
                "rank": "TWO"
            },
            {
                "suit": "SPADE",
                "rank": "THREE"
            },
            {
                "suit": "HEART",
                "rank": "TEN"
            },
            {
                "suit": "DIAMOND",
                "rank": "ACE"
            },
            {
                "suit": "CLUB",
                "rank": "QUEEN"
            },
            {
                "suit": "CLUB",
                "rank": "FOUR"
            },
            {
                "suit": "SPADE",
                "rank": "JACK"
            },
            {
                "suit": "SPADE",
                "rank": "SIX"
            },
            {
                "suit": "SPADE",
                "rank": "SEVEN"
            }
        ]
    }
}
````

Return 200 - Ok

#### Put Method
````
localhost:8080/game/12345/player

JSON in the body Request
[
  	{"id": "12345"}, 
  	{"id": "123"}
  	]


Json in the body Response
{
    "id": "12345",
    "playerList": [
        {
            "id": "12345",
            "hand": [],
            "totalValue": 0
        },
        {
            "id": "123",
            "hand": [],
            "totalValue": 0
        }
    ],
    "gameDeck": {
        "deck": [
            {
                "suit": "DIAMOND",
                "rank": "FOUR"
            },
            {
                "suit": "SPADE",
                "rank": "EIGHT"
            },
            {
                "suit": "SPADE",
                "rank": "TEN"
            },
            {
                "suit": "DIAMOND",
                "rank": "TEN"
            },
            {
                "suit": "HEART",
                "rank": "QUEEN"
            },
            {
                "suit": "SPADE",
                "rank": "TWO"
            },
            {
                "suit": "CLUB",
                "rank": "EIGHT"
            },
            {
                "suit": "DIAMOND",
                "rank": "KING"
            },
            {
                "suit": "CLUB",
                "rank": "TEN"
            },
            {
                "suit": "DIAMOND",
                "rank": "THREE"
            },
            {
                "suit": "DIAMOND",
                "rank": "NINE"
            },
            {
                "suit": "HEART",
                "rank": "FOUR"
            },
            {
                "suit": "CLUB",
                "rank": "ACE"
            },
            {
                "suit": "SPADE",
                "rank": "FIVE"
            },
            {
                "suit": "HEART",
                "rank": "SEVEN"
            },
            {
                "suit": "DIAMOND",
                "rank": "FIVE"
            },
            {
                "suit": "CLUB",
                "rank": "FIVE"
            },
            {
                "suit": "HEART",
                "rank": "KING"
            },
            {
                "suit": "CLUB",
                "rank": "TWO"
            },
            {
                "suit": "HEART",
                "rank": "FIVE"
            },
            {
                "suit": "DIAMOND",
                "rank": "EIGHT"
            },
            {
                "suit": "HEART",
                "rank": "EIGHT"
            },
            {
                "suit": "DIAMOND",
                "rank": "JACK"
            },
            {
                "suit": "DIAMOND",
                "rank": "SEVEN"
            },
            {
                "suit": "CLUB",
                "rank": "THREE"
            },
            {
                "suit": "SPADE",
                "rank": "ACE"
            },
            {
                "suit": "CLUB",
                "rank": "JACK"
            },
            {
                "suit": "HEART",
                "rank": "THREE"
            },
            {
                "suit": "HEART",
                "rank": "SIX"
            },
            {
                "suit": "HEART",
                "rank": "TWO"
            },
            {
                "suit": "HEART",
                "rank": "ACE"
            },
            {
                "suit": "SPADE",
                "rank": "KING"
            },
            {
                "suit": "SPADE",
                "rank": "QUEEN"
            },
            {
                "suit": "DIAMOND",
                "rank": "SIX"
            },
            {
                "suit": "SPADE",
                "rank": "FOUR"
            },
            {
                "suit": "CLUB",
                "rank": "NINE"
            },
            {
                "suit": "DIAMOND",
                "rank": "QUEEN"
            },
            {
                "suit": "HEART",
                "rank": "NINE"
            },
            {
                "suit": "HEART",
                "rank": "JACK"
            },
            {
                "suit": "SPADE",
                "rank": "NINE"
            },
            {
                "suit": "CLUB",
                "rank": "KING"
            },
            {
                "suit": "CLUB",
                "rank": "SIX"
            },
            {
                "suit": "CLUB",
                "rank": "SEVEN"
            },
            {
                "suit": "DIAMOND",
                "rank": "TWO"
            },
            {
                "suit": "SPADE",
                "rank": "THREE"
            },
            {
                "suit": "HEART",
                "rank": "TEN"
            },
            {
                "suit": "DIAMOND",
                "rank": "ACE"
            },
            {
                "suit": "CLUB",
                "rank": "QUEEN"
            },
            {
                "suit": "CLUB",
                "rank": "FOUR"
            },
            {
                "suit": "SPADE",
                "rank": "JACK"
            },
            {
                "suit": "SPADE",
                "rank": "SIX"
            },
            {
                "suit": "SPADE",
                "rank": "SEVEN"
            }
        ]
    }
}
````

Return 200 - Ok

#### Deal Card to Players - Put Method
````
localhost:8080/game/12345/player/12345/deal

JSON in the body Request



Json in the body Response
{
    "id": "12345",
    "playerList": [
        {
            "id": "12345",
            "hand": [
                {
                    "suit": "DIAMOND",
                    "rank": "FOUR"
                }
            ],
            "totalValue": 4
        },
        {
            "id": "123",
            "hand": [],
            "totalValue": 0
        }
    ],
    "gameDeck": {
        "deck": [
            {
                "suit": "SPADE",
                "rank": "EIGHT"
            },
            {
                "suit": "SPADE",
                "rank": "TEN"
            },
            {
                "suit": "DIAMOND",
                "rank": "TEN"
            },
            {
                "suit": "HEART",
                "rank": "QUEEN"
            },
            {
                "suit": "SPADE",
                "rank": "TWO"
            },
            {
                "suit": "CLUB",
                "rank": "EIGHT"
            },
            {
                "suit": "DIAMOND",
                "rank": "KING"
            },
            {
                "suit": "CLUB",
                "rank": "TEN"
            },
            {
                "suit": "DIAMOND",
                "rank": "THREE"
            },
            {
                "suit": "DIAMOND",
                "rank": "NINE"
            },
            {
                "suit": "HEART",
                "rank": "FOUR"
            },
            {
                "suit": "CLUB",
                "rank": "ACE"
            },
            {
                "suit": "SPADE",
                "rank": "FIVE"
            },
            {
                "suit": "HEART",
                "rank": "SEVEN"
            },
            {
                "suit": "DIAMOND",
                "rank": "FIVE"
            },
            {
                "suit": "CLUB",
                "rank": "FIVE"
            },
            {
                "suit": "HEART",
                "rank": "KING"
            },
            {
                "suit": "CLUB",
                "rank": "TWO"
            },
            {
                "suit": "HEART",
                "rank": "FIVE"
            },
            {
                "suit": "DIAMOND",
                "rank": "EIGHT"
            },
            {
                "suit": "HEART",
                "rank": "EIGHT"
            },
            {
                "suit": "DIAMOND",
                "rank": "JACK"
            },
            {
                "suit": "DIAMOND",
                "rank": "SEVEN"
            },
            {
                "suit": "CLUB",
                "rank": "THREE"
            },
            {
                "suit": "SPADE",
                "rank": "ACE"
            },
            {
                "suit": "CLUB",
                "rank": "JACK"
            },
            {
                "suit": "HEART",
                "rank": "THREE"
            },
            {
                "suit": "HEART",
                "rank": "SIX"
            },
            {
                "suit": "HEART",
                "rank": "TWO"
            },
            {
                "suit": "HEART",
                "rank": "ACE"
            },
            {
                "suit": "SPADE",
                "rank": "KING"
            },
            {
                "suit": "SPADE",
                "rank": "QUEEN"
            },
            {
                "suit": "DIAMOND",
                "rank": "SIX"
            },
            {
                "suit": "SPADE",
                "rank": "FOUR"
            },
            {
                "suit": "CLUB",
                "rank": "NINE"
            },
            {
                "suit": "DIAMOND",
                "rank": "QUEEN"
            },
            {
                "suit": "HEART",
                "rank": "NINE"
            },
            {
                "suit": "HEART",
                "rank": "JACK"
            },
            {
                "suit": "SPADE",
                "rank": "NINE"
            },
            {
                "suit": "CLUB",
                "rank": "KING"
            },
            {
                "suit": "CLUB",
                "rank": "SIX"
            },
            {
                "suit": "CLUB",
                "rank": "SEVEN"
            },
            {
                "suit": "DIAMOND",
                "rank": "TWO"
            },
            {
                "suit": "SPADE",
                "rank": "THREE"
            },
            {
                "suit": "HEART",
                "rank": "TEN"
            },
            {
                "suit": "DIAMOND",
                "rank": "ACE"
            },
            {
                "suit": "CLUB",
                "rank": "QUEEN"
            },
            {
                "suit": "CLUB",
                "rank": "FOUR"
            },
            {
                "suit": "SPADE",
                "rank": "JACK"
            },
            {
                "suit": "SPADE",
                "rank": "SIX"
            },
            {
                "suit": "SPADE",
                "rank": "SEVEN"
            }
        ]
    }
}
````

Return 200 - Ok

#### Get Hand Card frmo Players - Get Method
````
localhost:8080/game/12345/player/12345


Json in the body Response
[
    {
        "suit": "DIAMOND",
        "rank": "FOUR"
    }
]

````

Return 200 - Ok




#### Get Suit Undealt Card to Players - Get Method
````
localhost:8080/game/12345/deck

JSON in the body Request



Json in the body Response
{
    "HEART": 13,
    "SPADE": 12,
    "DIAMOND": 12,
    "CLUB": 13
}

````

Return 200 - Ok


#### Get Remaining Cards - Get Method
````
localhost:8080/game/12345/deck/cards

JSON in the body Request



Json in the body Response
{
    "Card(suit=HEART, rank=KING)": 1,
    "Card(suit=SPADE, rank=KING)": 1,
    "Card(suit=CLUB, rank=KING)": 1,
    "Card(suit=DIAMOND, rank=KING)": 1,
    "Card(suit=HEART, rank=QUEEN)": 1,
    "Card(suit=SPADE, rank=QUEEN)": 1,
    "Card(suit=CLUB, rank=QUEEN)": 1,
    "Card(suit=DIAMOND, rank=QUEEN)": 1,
    "Card(suit=HEART, rank=JACK)": 1,
    "Card(suit=SPADE, rank=JACK)": 1,
    "Card(suit=CLUB, rank=JACK)": 1,
    "Card(suit=DIAMOND, rank=JACK)": 1,
    "Card(suit=HEART, rank=TEN)": 1,
    "Card(suit=CLUB, rank=TEN)": 1,
    "Card(suit=DIAMOND, rank=TEN)": 1,
    "Card(suit=HEART, rank=NINE)": 1,
    "Card(suit=SPADE, rank=NINE)": 1,
    "Card(suit=CLUB, rank=NINE)": 1,
    "Card(suit=DIAMOND, rank=NINE)": 1,
    "Card(suit=HEART, rank=EIGHT)": 1,
    "Card(suit=SPADE, rank=EIGHT)": 1,
    "Card(suit=CLUB, rank=EIGHT)": 1,
    "Card(suit=DIAMOND, rank=EIGHT)": 1,
    "Card(suit=HEART, rank=SEVEN)": 1,
    "Card(suit=SPADE, rank=SEVEN)": 1,
    "Card(suit=CLUB, rank=SEVEN)": 1,
    "Card(suit=DIAMOND, rank=SEVEN)": 1,
    "Card(suit=HEART, rank=SIX)": 1,
    "Card(suit=SPADE, rank=SIX)": 1,
    "Card(suit=CLUB, rank=SIX)": 1,
    "Card(suit=HEART, rank=FIVE)": 1,
    "Card(suit=SPADE, rank=FIVE)": 1,
    "Card(suit=CLUB, rank=FIVE)": 1,
    "Card(suit=DIAMOND, rank=FIVE)": 1,
    "Card(suit=HEART, rank=FOUR)": 1,
    "Card(suit=SPADE, rank=FOUR)": 1,
    "Card(suit=CLUB, rank=FOUR)": 1,
    "Card(suit=DIAMOND, rank=FOUR)": 1,
    "Card(suit=HEART, rank=THREE)": 1,
    "Card(suit=SPADE, rank=THREE)": 1,
    "Card(suit=CLUB, rank=THREE)": 1,
    "Card(suit=DIAMOND, rank=THREE)": 1,
    "Card(suit=HEART, rank=TWO)": 1,
    "Card(suit=SPADE, rank=TWO)": 1,
    "Card(suit=CLUB, rank=TWO)": 1,
    "Card(suit=DIAMOND, rank=TWO)": 1,
    "Card(suit=HEART, rank=ACE)": 1,
    "Card(suit=SPADE, rank=ACE)": 1,
    "Card(suit=CLUB, rank=ACE)": 1,
    "Card(suit=DIAMOND, rank=ACE)": 1
}
````

Return 200 - Ok