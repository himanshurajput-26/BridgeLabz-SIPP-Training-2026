import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {

    public static void generateException(String[] names) {
        System.out.println("Attempting element access way past the array dimensions length...");
        String name = names[names.length + 10]; 
    }

    public static void handleException(String[] names) {
        try {
            String name = names[names.length + 10];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught expected array sequence indexing fault: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught Runtime Exception: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many names do you want to input? ");
        int size = sc.nextInt();
        String[] names = new String[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = sc.next();
        }

        handleException(names);
        System.out.println("-----------------------------------------");
        generateException(names);
        
        sc.close();
    }
}