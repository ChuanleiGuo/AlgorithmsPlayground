import java.util.ArrayList;
import java.util.List;

public class InorderTraversalWithParent {
    public static List<Integer> inorderTraversal(BinaryTreeNode<Integer> tree) {
        BinaryTreeNode<Integer> prev = null, curr = tree;
        List<Integer> result = new ArrayList<>();

        while (curr != null) {
            BinaryTreeNode<Node> next;
            if (curr.parent == prev) {
                if (curr.left != null) {
                    next = curr.left;
                } else {
                    result.add(curr.data);
                    next = (curr.right != null) ? curr.right : curr.parent;
                }
            } else if (curr.left == prev) {
                result.add(curr.data);
                next = (curr.right != null) ? curr.right : curr.parent;
            } else {
                next = curr.parent;
            }
            prev = cur;
            cur = next;
        }
        return result;
    }
}
