import java.util.LinkedList;
import java.util.List;

public class LinkLeaves {
    public static List<BinaryTreeNode<Integer>> createListOfLeaves(BinaryTreeNode<Integer> tree) {
        List<BinaryTreeNode<Integer>> result = new LinkedList<>();
        addLeavesLeftToRight(tree, result);
        return result;
    }

    private static void addLeavesLeftToRight(BinaryTreeNode<Integer> node, List<BinaryTreeNode<Integer>> res) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                res.add(node);
            } else {
                addLeavesLeftToRight(node.left, res);
                addLeavesLeftToRight(node.right, res);
            }
        }
    }
}
