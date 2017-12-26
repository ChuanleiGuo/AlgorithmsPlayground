public class TreePathSum {
    public static boolean hasPathSum(BinaryTreeNode<Integer> tree, int targetSum) {
        return treePathSumHelper(tree, 0, targetSum);
    }

    private static boolean treePathSumHelper(BinaryTreeNode<Integer> tree, int partialSum, int targetSum) {
        if (tree == null) {
            return false;
        }
        partialSum = partialSum + tree.data;
        if (tree.left == null && tree.right == null) {
            return partialSum == targetSum;
        }

        return treePathSumHelper(tree.left, partialSum, targetSum)
            || treePathSumHelper(tree.right, partialSum, targetSum);
    }

    public static void main(String[] args) {
        // 3
        // 2 5
        // 1 4 6
        BinaryTreeNode<Integer> tree = new BinaryTreeNode<Integer>(3);
        assert (hasPathSum(tree, 3));
        tree.left = new BinaryTreeNode<Integer>(2);
        assert (hasPathSum(tree, 5));
        tree.left.left = new BinaryTreeNode<Integer>(1);
        assert (hasPathSum(tree, 6));
        tree.right = new BinaryTreeNode<Integer>(5);
        assert (hasPathSum(tree, 8));
        assert (!hasPathSum(tree, 7));
        tree.right.left = new BinaryTreeNode<Integer>(4);
        assert (hasPathSum(tree, 12));
        assert (!hasPathSum(tree, 1));
        assert (!hasPathSum(tree, 3));
        assert (!hasPathSum(tree, 5));
        tree.right.right = new BinaryTreeNode<Integer>(6);
        assert (hasPathSum(tree, 6));
        assert (!hasPathSum(tree, 7));
        assert (hasPathSum(tree, 14));
        assert (!hasPathSum(tree, -1));
        assert (!hasPathSum(tree, Integer.MAX_VALUE));
        assert (!hasPathSum(tree, Integer.MIN_VALUE));
    }
}
