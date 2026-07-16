import java.util.ArrayDeque;
import java.util.Deque;

public class Solution5 {
    public static class Node {
        int val;
        Node left, right;
    }

    public int kthSmallest(Node root, int k) {
        Deque<Node> stack = new ArrayDeque<>(); // [cite: 123]
        Node current = root; // [cite: 124]
        int count = 0; // [cite: 125]
        
        while (current != null || !stack.isEmpty()) { // [cite: 126]
            // Travel as far left as possible to locate the smallest items
            while (current != null) { // [cite: 127]
                stack.push(current); // [cite: 129]
                current = current.left; // [cite: 130, 131]
            }
            
            // Evaluate current smallest elements
            current = stack.pop(); // [cite: 132]
            count++; // [cite: 133]
            
            if (count == k) {
                return current.val; // [cite: 134]
            }
            
            // Move into right branch paths
            current = current.right; // [cite: 134, 135]
        }
        
        throw new IllegalArgumentException("k out of range"); // [cite: 136]
    }
}