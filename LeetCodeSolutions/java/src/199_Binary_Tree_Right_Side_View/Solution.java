import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        rightView(root, res, 0);
        return res;
    }

    private void rightView(TreeNode node, List<Integer> list, int depth) {
        if (node == null) {
            return;
        }

        if (depth == list.size()) {
            list.add(node.val);
        }

        rightView(node.right, list, depth + 1);
        rightView(node.left, list, depth + 1);
    }
}