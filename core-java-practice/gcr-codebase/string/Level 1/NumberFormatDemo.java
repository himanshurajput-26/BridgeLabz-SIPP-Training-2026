import java.util.Scanner;

public class NumberFormatDemo {

    public static void generateException(String text) {
        System.out.println("Attempting integer parse evaluation on textual string inputs...");
        int number = Integer.parseInt(text); 
    }

    public static void handleException(String text) {
        try {
            int number = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            System.out.println("Caught expected invalid data type format exception: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught Runtime Exception: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter non-numeric alpha text characters (e.g., 'abc'): ");
        String text = sc.next();

        handleException(text);
        System.out.println("-----------------------------------------");
        generateException(text);
        
        sc.close();
    }
}