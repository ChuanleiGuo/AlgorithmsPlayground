import java.util.LinkedList;
import java.util.List;

public class ExteriorOfABinaryTree {
    public static List<BinaryTreeNode<Integer>> exteriorBinaryTree(BinaryTreeNode<Integer> tree) {
        List<BinaryTreeNode<Integer>> exterior = new LinkedList<>();
        if (tree != null) {
            exterior.add(tree);
            exterior.addAll(leftBoundaryAndLeaves(tree.left, true));
            exterior.addAll(rightBoundaryAndLeaves(tree.right, true));
        }
        return exterior;
    }

    private static List<BinaryTreeNode<Integer>> leftBoundaryAndLeaves(BinaryTreeNode<Integer> subtreeRoot, boolean isBoundary) {
        List<BinaryTreeNode<Integer>> result = new LinkedList<>();
        if (subtreeRoot != null) {
            if (isBoundary || isLeaf(subtreeRoot)) {
                result.add(subtreeRoot);
            }
            result.addAll(leftBoundaryAndLeaves(subtreeRoot.left, isBoundary));
            result.addAll(leftBoundaryAndLeaves(subtreeRoot.right, isBoundary && subtreeRoot.left == null));
        }
        return result;
    }

    private static List<BinaryTreeNode<Integer>> rightBoundaryAndLeaves(BinaryTreeNode<Integer> subtreeRoot, boolean isBoundary) {
        List<BinaryTreeNode<Integer>> result = new LinkedList<>();
        if (subtreeRoot != null) {
            result.addAll(rightBoundaryAndLeaves(subtreeRoot.left, isBoundary && subtreeRoot.right == null));
            result.addAll(rightBoundaryAndLeaves(subtreeRoot.right, isBoundary));
            if (isBoundary || isLeaf(subtreeRoot)) {
                result.add(subtreeRoot);
            }
        }
        return result;
    }

    private static boolean isLeaf(BinaryTreeNode<Integer> node) {
        return node.left == null && node.right == null;
    }
}
