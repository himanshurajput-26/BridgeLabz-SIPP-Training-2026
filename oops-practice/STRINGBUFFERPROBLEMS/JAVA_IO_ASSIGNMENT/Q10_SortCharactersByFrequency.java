import java.util.*;

public class Q10_SortCharactersByFrequency {
    public static void main(String[] args) {

        String s = "tree";

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        List<Character> list =
                new ArrayList<>(map.keySet());

        list.sort((a, b) ->
                map.get(b) - map.get(a));

        StringBuilder sb = new StringBuilder();

        for (char ch : list) {
            for (int i = 0; i < map.get(ch); i++) {
                sb.append(ch);
            }
        }

        System.out.println(sb);
    }
}