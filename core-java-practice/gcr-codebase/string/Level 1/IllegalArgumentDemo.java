import java.util.Scanner;

public class IllegalArgumentDemo {

    public static void generateException(String text) {
        System.out.println("Attempting substring extraction where start > end indices...");
        // Triggers Index / Argument parameters violation runtime errors
        String errorSub = text.substring(5, 2); 
    }

    public static void handleException(String text) {
        try {
            if (text.length() < 5) {
                text = "SampleTextFallback"; 
            }
            String errorSub = text.substring(5, 2);
        } catch (IllegalArgumentException | StringIndexOutOfBoundsException e) {
            System.out.println("Exception caught structural to argument limits: " + e);
        } catch (RuntimeException e) {
            System.out.println("Generic Runtime Catch: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text (at least 6 characters long): ");
        String text = sc.next();

        handleException(text);
        System.out.println("-----------------------------------------");
        generateException(text);
        
        sc.close();
    }
}