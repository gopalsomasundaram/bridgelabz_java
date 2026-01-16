package String.Level3;

import java.util.Scanner;
public class DeckOfCards {
    public String[] initializeDeck(String[] suits, String[] ranks) {
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];

        int count = 0;
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
            int randomCardNumber = i + (int) (Math.random() * (n - i));

            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }

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
