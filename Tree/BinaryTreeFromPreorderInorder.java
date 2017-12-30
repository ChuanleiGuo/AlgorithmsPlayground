import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeFromPreorderInorder {
    public static BinaryTreeNode<Integer> binaryTreeFromPreorderInorder(List<Integer> preorder, List<Integer> inorder) {
        Map<Integer, Integer> nodeToInorderIdx = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.size(); i++) {
            nodeToInorderIdx.put(inorder.get(i), i);
        }
        return helper(preorder, 0, preorder.size(), 0, inorder.size(), nodeToInorderIdx);
    }

    private static BinaryTreeNode<Integer> helper(List<Integer> preorder, int preorderStart, int preorderEnd,
        int inorderStart, int inorderEnd, Map<Integer, Integer> nodeToInorderIdx) {


        if (preorderEnd <= preorderStart || inorderEnd <= inorderStart) {
            return null;
        }
        int rootInorderIdx = nodeToInorderIdx.get(preorder.get(preorderStart));
        int leftSubTreeSize = rootInorderIdx - inorderStart;

        return new BinaryTreeNode<Integer>(
            preorder.get(preorderStart),
            helper(preorder, preorderStart + 1, preorderStart + 1 + leftSubTreeSize,
                inorderStart, rootlnorderldx, nodeToInorderldx),
            helper(preorder, preorderStart + 1 + leftSubTreeSize, preorderEnd,
                rootInorderIdx + 1, inorderEnd, nodeToInorderIdx));
    }
}
