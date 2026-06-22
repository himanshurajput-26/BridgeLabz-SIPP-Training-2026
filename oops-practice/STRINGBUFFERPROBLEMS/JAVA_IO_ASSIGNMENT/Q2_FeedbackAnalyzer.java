import java.io.*;

public class Q2_FeedbackAnalyzer {
    public static void main(String[] args) throws IOException {

        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(System.in));

        int count = 0;

        System.out.println("Enter 5 feedback messages:");

        for (int i = 0; i < 5; i++) {
            String msg = br.readLine().toLowerCase();

            if (msg.contains("good")) {
                count++;
            }
        }

        System.out.println("Good Feedback Count = " + count);
    }
}