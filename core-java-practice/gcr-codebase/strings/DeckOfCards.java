import java.util.Scanner;

public class DeckOfCards {

    // Suits and Ranks
    static String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    static String[] ranks = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King", "Ace"
    };

    // Method to initialize deck
    public static String[] initializeDeck() {

        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];

        int index = 0;
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index++] = ranks[j] + " of " + suits[i];
            }
        }

        return deck;
    }

    // Method to shuffle deck
    public static String[] shuffleDeck(String[] deck) {

        int n = deck.length;

        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int) (Math.random() * (n - i));

            // swap cards
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }

        return deck;
    }

    // Method to distribute cards to players
    public static String[][] distributeCards(String[] deck, int players, int cardsPerPlayer) {

        if (players * cardsPerPlayer > deck.length) {
            return null; // distribution not possible
        }

        String[][] result = new String[players][cardsPerPlayer];

        int cardIndex = 0;
        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                result[i][j] = deck[cardIndex++];
            }
        }

        return result;
    }

    // Method to print players and their cards
    public static void printPlayers(String[][] players) {

        for (int i = 0; i < players.length; i++) {
            System.out.println("\nPlayer " + (i + 1) + " cards:");
            for (int j = 0; j < players[i].length; j++) {
                System.out.println(players[i][j]);
            }
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Number of players daalo: ");
        int players = input.nextInt();

        System.out.print("Cards per player daalo: ");
        int cardsPerPlayer = input.nextInt();

        String[] deck = initializeDeck();
        deck = shuffleDeck(deck);

        String[][] distributed = distributeCards(deck, players, cardsPerPlayer);

        if (distributed == null) {
            System.out.println("Itne cards players me distribute nahi ho sakte");
        } else {
            printPlayers(distributed);
        }

        input.close();
    }
}
