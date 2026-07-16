public class Solution4 {
    public static class Node {
        int val;
        Node left, right;
    }

    public boolean isValidBST(Node root) {
        // Evaluate tree values using long min/max values to prevent integer overflow edge cases
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE); // [cite: 104]
    }

    private boolean validate(Node node, long min, long max) {
        if (node == null) return true; // [cite: 108]
        
        // Check if value falls completely out of allowed path bounds
        if (node.val <= min || node.val >= max) { // [cite: 108, 109]
            return false;
        }
        
        // Left sub-tree must remain < node.val; Right sub-tree must remain > node.val
        return validate(node.left, min, node.val) && validate(node.right, node.val, max); // [cite: 110]
    }
}