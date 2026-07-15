import java.util.Scanner;

public class HandshakeCalculator {

    public static int calculateHandshakes(int numberOfStudents) { // [cite: 85]
        return (numberOfStudents * (numberOfStudents - 1)) / 2; // [cite: 84]
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of students: "); // [cite: 83]
        int numberOfStudents = input.nextInt(); // [cite: 83]

        int maxHandshakes = calculateHandshakes(numberOfStudents);
        System.out.println("The maximum number of possible handshakes is: " + maxHandshakes); // [cite: 86]
        input.close();
    }
}