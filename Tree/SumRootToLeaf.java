public class SumRootToLeaf {
    public static int sumRootToLeaf(BinaryTreeNode<Integer> tree) {
        return sumRootToLeafHelper(tree, 0);
    }

    private static int sumRootToLeafHelper(BinaryTreeNode<Integer> node, int partialSum) {
        if (node == null) {
            return 0;
        }

        partialSum = partialSum * 2 + node.data;
        if (node.left == null && node.right == null) {
            return partialSum;
        }

        return sumRootToLeafHelper(node.left, partialSum)
            + sumRootToLeafHelper(node.right, partialSum);
    }

    public static void main(String[] args) {
        // 1
        // 1 0
        // 0 1 0
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1);
        int result = sumRootToLeaf(root);
        assert (result == 1);
        root.left = new BinaryTreeNode<Integer>(1);
        result = sumRootToLeaf(root);
        assert (result == 3);
        root.left.left = new BinaryTreeNode<Integer>(0);
        result = sumRootToLeaf(root);
        assert (result == 6);
        root.right = new BinaryTreeNode<Integer>(0);
        result = sumRootToLeaf(root);
        assert (result == 8);
        root.right.left = new BinaryTreeNode<Integer>(1);
        result = sumRootToLeaf(root);
        assert (result == 11);
        root.right.right = new BinaryTreeNode<Integer>(0);
        result = sumRootToLeaf(root);
        assert (result == 15);
    }
}
