public class NullPointerDemo {

    public static void generateException() {
        System.out.println("Attempting to call a method on a null string reference...");
        String text = null;
        // This will generate a NullPointerException
        int length = text.length(); 
    }

    public static void handleException() {
        System.out.println("Running safe handling method...");
        try {
            String text = null;
            int length = text.length();
        } catch (NullPointerException e) {
            System.out.println("Caught Expected Exception: " + e);
        }
    }

    public static void main(String[] args) {
        // Run handling method first to keep application running smoothly
        handleException();
        
        System.out.println("\n-----------------------------------------");
        // Unleash unhandled exception (will break the program deliberately)
        generateException();
    }
}