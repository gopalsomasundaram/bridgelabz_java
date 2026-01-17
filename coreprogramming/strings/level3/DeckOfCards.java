package strings.level3;

import java.util.Scanner;
/*
 * This class simulates a standard 52-card deck system.
 * It handles deck creation, randomized shuffling, and dealing to multiple players.
 */
public class DeckOfCards {
    //Initialize the deck using a Cartesian Product of Suits and Ranks
    public String[] initializeDeck(String[] suits, String[] ranks) {
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];

        int count = 0;
        // Nested loop ensures every rank is paired with every suit
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[count++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    public String[] shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            // Pick a random index from the remaining "unshuffled" portion
            int randomCardNumber = i + (int) (Math.random() * (n - i));

            // Swap the current card with the randomly selected card
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }
    //Distribute cards into a 2D Array
    public String[][] distributeCards(String[] deck, int numPlayers, int cardsPerPlayer) {
        if (numPlayers * cardsPerPlayer > deck.length) {
            System.out.println("Error: Not enough cards to distribute!");
            return null;
        }

        String[][] players = new String[numPlayers][cardsPerPlayer];
        int cardIdx = 0;

        for (int i = 0; i < cardsPerPlayer; i++) {
            for (int j = 0; j < numPlayers; j++) {
                players[j][i] = deck[cardIdx++];
            }
        }
        return players;
    }
    //Display the hands
    public void printPlayerCards(String[][] players) {
        if (players == null) return;

        for (int i = 0; i < players.length; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            for (int j = 0; j < players[i].length; j++) {
                System.out.print("[" + players[i][j] + "] ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DeckOfCards game = new DeckOfCards();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] deck = game.initializeDeck(suits, ranks);
        System.out.println("Deck initialized with " + deck.length + " cards.");
        deck = game.shuffleDeck(deck);
        System.out.println("Deck shuffled.");
        System.out.print("\nEnter number of players: ");
        int x = sc.nextInt();
        System.out.print("Enter number of cards per player: ");
        int n = sc.nextInt();
        String[][] playerHands = game.distributeCards(deck, x, n);
        game.printPlayerCards(playerHands);
        sc.close();
    }
}
