import java.util.Scanner;

public class CodingGuildWelcome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input from user
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Rank: ");
        int rank = sc.nextInt();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        System.out.print("Enter Membership Fee: ");
        float membershipFee = sc.nextFloat();

        // Calculating annual bonus (12% of salary)
        double bonus = salary * 0.12;

        // Casting bonus to int
        int annualBonus = (int) bonus;

        // Printing formatted welcome card
        System.out.println("\n==============================");
        System.out.println("      WELCOME TO CODING GUILD");
        System.out.println("==============================");
        System.out.println("Name            : " + name);
        System.out.println("Age             : " + age);
        System.out.println("Rank            : " + rank);
        System.out.println("Salary          : " + salary);
        System.out.println("Membership Fee  : " + membershipFee);
        System.out.println("Annual Bonus    : " + annualBonus);
        System.out.println("==============================");
        System.out.println("Welcome, " + name + "!");
        
        sc.close();
    }
}