public class Solution1 {
    public static class Node {
        int val;
        Node left, right;
        public Node(int val) { this.val = val; }
    }

    public boolean search(Node root, int target) {
        Node current = root; // [cite: 26]
        while (current != null) { // [cite: 27]
            if (target == current.val) {
                return true; // [cite: 28]
            }
            // If target is smaller, move left; otherwise, move right
            current = (target < current.val) ? current.left : current.right; // [cite: 29]
        }
        return false; // [cite: 31]
    }
}