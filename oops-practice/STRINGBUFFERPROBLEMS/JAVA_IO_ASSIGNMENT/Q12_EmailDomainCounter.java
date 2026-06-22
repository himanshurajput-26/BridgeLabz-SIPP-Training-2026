import java.io.*;
import java.util.*;

public class Q12_EmailDomainCounter {
    public static void main(String[] args)
            throws Exception {

        BufferedReader br =
                new BufferedReader(
                        new FileReader("emails.txt"));

        HashMap<String, Integer> map =
                new HashMap<>();

        String email;

        while ((email = br.readLine()) != null) {

            String domain =
                    email.substring(
                            email.indexOf("@") + 1);

            map.put(domain,
                    map.getOrDefault(domain, 0) + 1);
        }

        System.out.println(map);

        br.close();
    }
}