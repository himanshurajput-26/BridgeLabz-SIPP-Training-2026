public class Problem9 {
    public static void towerOfHanoi(int n, char source, char helper, char destination) {
        // Base case: only 1 disk left to move
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }

        // Step 1: Move top n-1 disks from source to helper using destination as a buffer
        towerOfHanoi(n - 1, source, destination, helper);

        // Step 2: Move the nth disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);

        // Step 3: Move the n-1 disks from helper to destination using source as a buffer
        towerOfHanoi(n - 1, helper, source, destination);
    }

    public static void main(String[] args) {
        int N = 3;
        towerOfHanoi(N, 'A', 'B', 'C');
    }
}