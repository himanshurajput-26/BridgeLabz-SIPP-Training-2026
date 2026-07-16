public class Solution6 {
    public static class Node {
        int val;
        Node left, right;
    }

    public Node lowestCommonAncestor(Node root, int p, int q) {
        Node current = root; // [cite: 154]
        
        while (current != null) { // [cite: 155]
            // Case 1: Both keys belong to the left subtree
            if (p < current.val && q < current.val) { // [cite: 156]
                current = current.left; // [cite: 156]
            } 
            // Case 2: Both keys belong to the right subtree
            else if (p > current.val && q > current.val) { // [cite: 157]
                current = current.right; // [cite: 158]
            } 
            // Case 3: Split point found! One is left, one is right (or one is the current node)
            else { // [cite: 159]
                return current; // [cite: 160]
            }
        }
        return null; // [cite: 163]
    }
}