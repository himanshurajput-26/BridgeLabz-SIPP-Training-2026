public class Solution2 {
    public static class Node {
        int val;
        Node left, right;
        public Node(int val) { this.val = val; }
    }

    public Node insert(Node node, int id) {
        // Base case: position found, attach new node here
        if (node == null) { // [cite: 46]
            return new Node(id); // [cite: 48]
        }
        
        // Recurse down the correct subtree based on comparison
        if (id < node.val) { // [cite: 49]
            node.left = insert(node.left, id); // [cite: 50]
        } else if (id > node.val) { // [cite: 51]
            node.right = insert(node.right, id); // [cite: 52]
        }
        
        return node; // [cite: 54]
    }
}