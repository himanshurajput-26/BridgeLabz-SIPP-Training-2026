public class TreeDiameter {
    private int diameter;

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

    public int longestCommunicationPath(TreeNode root) {
        diameter = 0;
        heightAndUpdateDiameter(root);
        return diameter;
    }

    private int heightAndUpdateDiameter(TreeNode node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = heightAndUpdateDiameter(node.left);
        int rightHeight = heightAndUpdateDiameter(node.right);
        diameter = Math.max(diameter, leftHeight + rightHeight + 2);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
