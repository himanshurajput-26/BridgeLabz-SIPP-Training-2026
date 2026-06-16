import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {

    public static void generateException(String text) {
        System.out.println("Attempting to access an index beyond string length...");
        // This causes the error
        char ch = text.charAt(text.length() + 5); 
    }

    public static void handleException(String text) {
        try {
            char ch = text.charAt(text.length() + 5);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught String Index Exception: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught Generic Runtime Exception: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.next();

        handleException(text);
        System.out.println("-----------------------------------------");
        generateException(text);
        
        sc.close();
    }
}