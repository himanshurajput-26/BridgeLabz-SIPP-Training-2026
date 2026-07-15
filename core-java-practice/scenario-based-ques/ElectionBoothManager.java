import java.util.Scanner;

public class ElectionBoothManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Tracking metrics for candidates
        int candidate1Votes = 0;
        int candidate2Votes = 0;
        int candidate3Votes = 0;
        
        // System termination override sequence
        final int ADMIN_SHUTDOWN_CODE = 999; 
        
        System.out.println("=== Election Booth Management System ===");
        
        while (true) { // Loop dynamically for multiple voters
            System.out.print("\nTo vote, enter your age (or enter '" + ADMIN_SHUTDOWN_CODE + "' to close poll): ");
            int inputAge = scanner.nextInt();
            
            // Validation filter to gracefully close operations
            if (inputAge == ADMIN_SHUTDOWN_CODE) {
                System.out.println("Admin shutdown token accepted. Finalizing counting metrics...");
                break; // Break control flow to exit loop
            }
            
            // Conditional logic tracking state legality
            if (inputAge >= 18) { // Age condition
                System.out.println("Status: Eligible to Vote.");
                System.out.println("Candidates List:\n 1. Candidate A\n 2. Candidate B\n 3. Candidate C");
                System.out.print("Cast your choice (1-3): ");
                int explicitVoteSelection = scanner.nextInt();
                
                // Track vote increment safely
                switch (explicitVoteSelection) {
                    case 1:
                        candidate1Votes++;
                        System.out.println("Vote recorded successfully for Candidate A.");
                        break;
                    case 2:
                        candidate2Votes++;
                        System.out.println("Vote recorded successfully for Candidate B.");
                        break;
                    case 3:
                        candidate3Votes++;
                        System.out.println("Vote recorded successfully for Candidate C.");
                        break;
                    default:
                        System.out.println("Invalid selection made. Ballot wasted.");
                        break;
                }
            } else {
                System.out.println("Status: Denied. You must be at least 18 years old to vote.");
            }
        }
        
        // Print comprehensive operational logs at cycle closure
        System.out.println("\n========================");
        System.out.println("     FINAL TALLY RESULTS ");
        System.out.println("========================");
        System.out.println("Candidate A: " + candidate1Votes + " votes");
        System.out.println("Candidate B: " + candidate2Votes + " votes");
        System.out.println("Candidate C: " + candidate3Votes + " votes");
        System.out.println("========================");
        
        scanner.close();
    }
}