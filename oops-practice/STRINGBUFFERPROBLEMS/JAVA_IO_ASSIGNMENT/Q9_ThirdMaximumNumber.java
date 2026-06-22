import java.util.*;

public class Q9_ThirdMaximumNumber {
    public static void main(String[] args) {

        int[] nums = {3, 2, 1};

        TreeSet<Integer> set = new TreeSet<>();

        for (int num : nums) {
            set.add(num);

            if (set.size() > 3) {
                set.pollFirst();
            }
        }

        if (set.size() < 3) {
            System.out.println(set.last());
        } else {
            System.out.println(set.first());
        }
    }
}