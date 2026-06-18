public class Problem8 {
    public static void method1() {
        // Unchecked exception generated here
        int result = 10 / 0; 
    }

    public static void method2() {
        // Propagates implicitly up to stack line
        method1(); 
    }

    public static void main(String[] args) {
        try {
            method2();
        } catch (ArithmeticException e) {
            // Intercepted and handled here
            System.out.println("Handled exception in main");
        }
    }
}