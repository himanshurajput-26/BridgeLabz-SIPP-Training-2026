import java.util.Scanner;

public class RockPaperScissorsSystem {

    // Method to randomly generate the computer's move
    public static String getComputerChoice() {
        int choiceNum = (int) (Math.random() * 3); // Generates 0, 1, or 2
        if (choiceNum == 0) return "rock";
        if (choiceNum == 1) return "paper";
        return "scissors";
    }

    // Resolves round results using standard game mechanics
    public static String determineWinner(String player, String computer) {
        player = player.toLowerCase();
        if (player.equals(computer)) return "Draw";
        
        if ((player.equals("rock") && computer.equals("scissors")) ||
            (player.equals("paper") && computer.equals("rock")) ||
            (player.equals("scissors") && computer.equals("paper"))) {
            return "Player";
        }
        return "Computer";
    }

    // Calculates percentages and formats data into a 2D matrix summary layout
    public static String[][] aggregateMatchPerformance(int pWins, int cWins, int draws, int rounds) {
        String[][] stats = new String[2][3];
        
        double playerPct = (rounds == 0) ? 0.0 : ((double) pWins / rounds) * 100;
        double computerPct = (rounds == 0) ? 0.0 : ((double) cWins / rounds) * 100;

        stats[0][0] = "Player";
        stats[0][1] = String.valueOf(pWins);
        // CORRECTED: Multiplied by 100, rounded via Math.round, then divided by 100.0 double primitive
        stats[0][2] = (Math.round(playerPct * 100) / 100.0) + "%";

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(cWins);
        // CORRECTED: Multiplied by 100, rounded via Math.round, then divided by 100.0 double primitive
        stats[1][2] = (Math.round(computerPct * 100) / 100.0) + "%";

        return stats;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total number of game iterations to execute: ");
        int totalRounds = sc.nextInt();

        int playerWins = 0, computerWins = 0, draws = 0;

        for (int i = 1; i <= totalRounds; i++) {
            System.out.print("\nRound " + i + " -> Enter choice (rock, paper, scissors): ");
            String pChoice = sc.next();
            String cChoice = getComputerChoice();
            
            System.out.println("Computer pick outcome: " + cChoice);
            String result = determineWinner(pChoice, cChoice);
            
            if (result.equals("Player")) {
                System.out.println("Round Result: Player wins the point.");
                playerWins++;
            } else if (result.equals("Computer")) {
                System.out.println("Round Result: Computer wins the point.");
                computerWins++;
            } else {
                System.out.println("Round Result: Standoff deadlock draw match.");
                draws++;
            }
        }

        String[][] scoreSheet = aggregateMatchPerformance(playerWins, computerWins, draws, totalRounds);

        System.out.println("\n============== TOURNAMENT STATS ==============");
        System.out.printf("%-10s | %-10s | %-15s\n", "Entity", "Win Count", "Winning Percentage");
        System.out.println("----------------------------------------------");
        for (String[] record : scoreSheet) {
            System.out.printf("%-10s | %-10s | %-15s\n", record[0], record[1], record[2]);
        }
        System.out.println("==============================================");
        System.out.println("Total Draws: " + draws);
        
        sc.close();
    }
}