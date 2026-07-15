import java.util.Scanner;

public class CardDistributionSystem {

    public static String[] generateStandardDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        
        int totalCards = suits.length * ranks.length;
        String[] deck = new String[totalCards];
        
        int insertionIndex = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[insertionIndex++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    public static String[] shuffleDeck(String[] deck) {
        int deckSize = deck.length;
        for (int i = 0; i < deckSize; i++) {
            int targetSwapIndex = i + (int) (Math.random() * (deckSize - i));
            
            String temporaryCard = deck[i];
            deck[i] = deck[targetSwapIndex];
            deck[targetSwapIndex] = temporaryCard;
        }
        return deck;
    }

    public static String[][] distributeHandPacks(String[] deck, int playerUnits, int cardsPerHand) {
        if ((playerUnits * cardsPerHand) > deck.length) {
            System.out.println("[Error Boundary Alert] Inventory allocation lacks card capacity requested.");
            return null;
        }

        String[][] strategicHandsMatrix = new String[playerUnits][cardsPerHand];
        int sourceDeckPointer = 0;

        for (int handRound = 0; handRound < cardsPerHand; handRound++) {
            for (int playerIndex = 0; playerIndex < playerUnits; playerIndex++) {
                strategicHandsMatrix[playerIndex][handRound] = deck[sourceDeckPointer++];
            }
        }
        return strategicHandsMatrix;
    }

    public static void displayDistributedHands(String[][] dealingMatrix) {
        if (dealingMatrix == null) return;
        System.out.println("\n================= GAME TABLE RECORD =================");
        for (int i = 0; i < dealingMatrix.length; i++) {
            System.out.print("Player " + (i + 1) + " Hand -> [ ");
            for (int j = 0; j < dealingMatrix[i].length; j++) {
                System.out.print(dealingMatrix[i][j] + (j == dealingMatrix[i].length - 1 ? "" : " | "));
            }
            System.out.println(" ]");
        }
        System.out.println("=====================================================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total number of participating players: ");
        int playerCount = sc.nextInt();
        System.out.print("Enter structural cards count to deal per hand: ");
        int cardsPerPerson = sc.nextInt();

        String[] freshDeck = generateStandardDeck();
        String[] shuffledDeck = shuffleDeck(freshDeck);

        String[][] distributionMatrix = distributeHandPacks(shuffledDeck, playerCount, cardsPerPerson);
        displayDistributedHands(distributionMatrix);
        
        sc.close();
    }
}