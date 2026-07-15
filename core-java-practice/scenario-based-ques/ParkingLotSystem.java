import java.util.Scanner;

public class ParkingLotSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Define maximum slots capacity
        final int MAX_CAPACITY = 5;
        int occupiedSlots = 0;
        
        System.out.println("=== Smart Parking Lot Gate System ===");
        System.out.println("Total Parking Slots Available: " + MAX_CAPACITY);
        
        // Loop runs until parking lot is full or user manually exits
        while (occupiedSlots <= MAX_CAPACITY) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Park a Car");
            System.out.println("2. Exit a Car");
            System.out.println("3. Show Occupancy");
            System.out.println("4. Shut Down System");
            System.out.print("Choose an option (1-4): ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1: // Park option
                    if (occupiedSlots < MAX_CAPACITY) {
                        occupiedSlots++;
                        System.out.println("Success: Gate Opened! Car parked safely.");
                        System.out.println("Available Free Slots: " + (MAX_CAPACITY - occupiedSlots));
                    } else {
                        System.out.println("Denied: Parking Lot is FULL! Cannot accept more cars.");
                    }
                    break;
                    
                case 2: // Exit option
                    if (occupiedSlots > 0) {
                        occupiedSlots--;
                        System.out.println("Success: Gate Opened! Car exited safely.");
                        System.out.println("Available Free Slots: " + (MAX_CAPACITY - occupiedSlots));
                    } else {
                        System.out.println("Alert: Parking lot is already empty. No cars to exit.");
                    }
                    break;
                    
                case 3: // Show occupancy status
                    System.out.println("--- Current Occupancy Report ---");
                    System.out.println("Total Capacity : " + MAX_CAPACITY);
                    System.out.println("Occupied Slots : " + occupiedSlots);
                    System.out.println("Free Slots     : " + (MAX_CAPACITY - occupiedSlots));
                    break;
                    
                case 4: // System shutdown
                    System.out.println("Shutting down Gate System. Have a nice day!");
                    scanner.close();
                    return; // Terminates the main method directly
                    
                default:
                    System.out.println("Invalid option selected. Please choose between 1 and 4.");
                    break;
            }
            
            // Automated trigger if parking gets full during runtime
            if (occupiedSlots == MAX_CAPACITY) {
                System.out.println("\n[SYSTEM NOTICE]: Parking lot is now completely full!");
            }
        }
    }
}