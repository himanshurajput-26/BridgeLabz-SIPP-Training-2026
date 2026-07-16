import java.util.ArrayList;
import java.util.List;

public class PostorderDeletion {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> postorderDeletionOrder(TreeNode root) {
        List<Integer> order = new ArrayList<>();
        postorderCollect(root, order);
        return order;
    }

    private void postorderCollect(TreeNode node, List<Integer> order) {
        if (node == null) {
            return;
        }
        postorderCollect(node.left, order);
        postorderCollect(node.right, order);
        order.add(node.val);
    }
}
