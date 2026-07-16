public class Solution3 {
    public static class Node {
        int val;
        Node left, right;
        public Node(int val) { this.val = val; }
    }

    public Node delete(Node node, int sku) {
        if (node == null) return null; // [cite: 71]
        
        // 1. Traverse the tree to locate the target SKU node
        if (sku < node.val) { // [cite: 71]
            node.left = delete(node.left, sku); // [cite: 72]
        } else if (sku > node.val) { // [cite: 73]
            node.right = delete(node.right, sku); // [cite: 74]
        } else { 
            // Target node found! Handle deletion cases:
            
            // Case A: Leaf node (no children)
            if (node.left == null && node.right == null) return null; // [cite: 76, 84]
            
            // Case B: Single child configurations
            if (node.left == null) return node.right; // [cite: 77, 85]
            if (node.right == null) return node.left; // [cite: 78, 86]
            
            // Case C: Two children nodes
            // Find the Inorder Successor (smallest value in right subtree)
            Node successor = node.right; // [cite: 79, 87]
            while (successor.left != null) { // [cite: 80]
                successor = successor.left; // [cite: 80]
            }
            
            // Copy the successor value over to this node
            node.val = successor.val; // [cite: 81, 82]
            
            // Delete the successor node recursively from the right subtree
            node.right = delete(node.right, successor.val); // [cite: 83]
        }
        return node; // [cite: 89]
    }
}