import java.util.*;

public class Q7_SimplifyPath {
    public static void main(String[] args) {

        String path = "/home//foo/";

        Stack<String> st = new Stack<>();

        String[] arr = path.split("/");

        for (String s : arr) {

            if (s.equals("") || s.equals(".")) {
                continue;
            }

            if (s.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(s);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (String s : st) {
            sb.append("/").append(s);
        }

        System.out.println(sb.length() == 0 ? "/" : sb.toString());
    }
}