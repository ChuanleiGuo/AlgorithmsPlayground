import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreorderIteratively {
    public static List<Integer> preorderTraversal(BinaryTreeNode<Integer> tree) {
        Deque<BinaryTreeNode<Integer>> nodes = new LinkedList<>();
        nodes.add(tree);
        List<Integer> res = new ArrayList<>();
        while (!nodes.isEmpty()) {
            BinaryTreeNode<Integer> cur = nodes.removeFirst();
            if (cur != null) {
                res.add(cur.data);
                nodes.add(cur.right);
                nodes.add(cur.left);
            }
        }
        return res;
    }
}
