// Program to find shortest, tallest, and mean height of football players

class FootballTeamHeight {

    // Method to generate random heights between 150 and 250 cm
    public static int[] generateHeights(int numberOfPlayers) {
        int[] heights = new int[numberOfPlayers];

        for (int i = 0; i < numberOfPlayers; i++) {
            heights[i] = (int) (Math.random() * 101) + 150;
        }

        return heights;
    }

    // Method to find sum of heights
    public static int findSum(int[] heights) {
        int sum = 0;

        for (int height : heights) {
            sum += height;
        }

        return sum;
    }

    // Method to calculate mean height
    public static double findMeanHeight(int[] heights) {
        int sum = findSum(heights);
        return (double) sum / heights.length;
    }

    // Method to find shortest height
    public static int findShortestHeight(int[] heights) {
        int shortest = heights[0];

        for (int height : heights) {
            if (height < shortest) {
                shortest = height;
            }
        }

        return shortest;
    }

    // Method to find tallest height
    public static int findTallestHeight(int[] heights) {
        int tallest = heights[0];

        for (int height : heights) {
            if (height > tallest) {
                tallest = height;
            }
        }

        return tallest;
    }

    // Method to display heights
    public static void displayHeights(int[] heights) {
        System.out.println("Player Heights (in cm):");

        for (int i = 0; i < heights.length; i++) {
            System.out.println("Player " + (i + 1) + ": " + heights[i] + " cm");
        }
    }

    public static void main(String[] args) {

        int numberOfPlayers = 11;

        // Generate random heights
        int[] heights = generateHeights(numberOfPlayers);

        // Display player heights
        displayHeights(heights);

        // Calculate results
        int shortestHeight = findShortestHeight(heights);
        int tallestHeight = findTallestHeight(heights);
        double meanHeight = findMeanHeight(heights);

        // Display results
        System.out.println("\nShortest Height: " + shortestHeight + " cm");
        System.out.println("Tallest Height: " + tallestHeight + " cm");
        System.out.printf("Mean Height: %.2f cm\n", meanHeight);
    }
}