public class BalancedBinaryTree {
    private static class BalanceStatusWithHeight {
        public boolean isBalanced;
        public int height;

        public BalanceStatusWithHeight(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static boolean isBalanced(BinaryTreeNode<Integer> tree) {
        return checkBalanced(tree).isBalanced;
    }

    private static BalanceStatusWithHeight checkBalanced(BinaryTreeNode<Integer> tree) {
        if (tree == null) {
            return new BalanceStatusWithHeight(true, -1);
        }

        BalanceStatusWithHeight leftStatus = checkBalanced(tree.left);
        if (!leftStatus.isBalanced) {
            return leftStatus;
        }
        BalanceStatusWithHeight rightStatus = checkBalanced(tree.right);
        if (!rightStatus.isBalanced) {
            return rightStatus;
        }

        boolean isBalanced = Math.abs(leftStatus.height - rightStatus.height) <= 1;
        int height = Math.max(leftStatus.height, rightStatus.height) + 1;
        return new BalanceStatusWithHeight(isBalanced, height);
    }

    public static void main(String[] args) {
        // balanced binary tree test
        // 3
        // 2 5
        // 1 4 6
        BinaryTreeNode<Integer> tree = new BinaryTreeNode<>();
        tree.left = new BinaryTreeNode<Integer>();
        tree.left.left = new BinaryTreeNode<Integer>();
        tree.right = new BinaryTreeNode<Integer>();
        tree.right.left = new BinaryTreeNode<Integer>();
        tree.right.right = new BinaryTreeNode<Integer>();
        if (!isBalanced(tree)) {
            System.err.println("Incorrect result on balanced tree " + tree);
            System.exit(-1);
        }
        tree = new BinaryTreeNode<>();
        tree.left = new BinaryTreeNode<Integer>();
        tree.left.left = new BinaryTreeNode<Integer>();
        if (isBalanced(tree)) {
            System.err.println("Incorrect result on unbalanced tree: " + tree);
            System.exit(-1);
        }
    }
}
