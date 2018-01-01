import java.util.List;

public class ReconstructPreorder {
    public static Integer subtreeIdx = 0;

    public static BinaryTreeNode<Integer> reconstructPreorder(List<Integer> preorder) {
        subtreeIdx = 0;
        return helper(preorder);
    }

    public static BinaryTreeNode<Integer> helper(List<Integer> preorder) {
        Integer subKey = preorder.get(subtreeIdx);
        subtreeIdx++;
        if (subKey == null) {
            return null;
        }
        BinaryTreeNode<Integer> left = helper(preorder);
        BinaryTreeNode<Integer> right = helper(preorder);
        return new BinaryTreeNode<Integer>(subKey, left, right);
    }
}
