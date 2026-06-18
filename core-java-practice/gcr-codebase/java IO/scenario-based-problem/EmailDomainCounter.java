import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class EmailDomainCounter {
    public static void countDomains(String filepath) {
        // Using a Map to elegantly dynamically scale domain counts
        Map<String, Integer> domainMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String email;
            while ((email = br.readLine()) != null) {
                email = email.trim();
                if (email.contains("@")) {
                    // Extract domain substring using String split mechanics
                    String domain = email.substring(email.indexOf("@") + 1);
                    domainMap.put(domain, domainMap.getOrDefault(domain, 0) + 1);
                }
            }

            System.out.println("=== Domain Counter Summary ===");
            for (Map.Entry<String, Integer> entry : domainMap.entrySet()) {
                System.out.println(entry.getKey() + " users count: " + entry.getValue());
            }

        } catch (IOException e) {
            System.out.println("Error processing domain matching files: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        countDomains("emails.txt");
    }
}