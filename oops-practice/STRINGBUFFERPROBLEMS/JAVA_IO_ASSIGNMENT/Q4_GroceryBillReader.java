import java.io.*;

public class Q4_GroceryBillReader {
    public static void main(String[] args) {

        try {
            BufferedReader br =
                    new BufferedReader(
                            new FileReader("bill.txt"));

            String line;
            int count = 0;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                count++;
            }

            System.out.println("Total Lines = " + count);

            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}