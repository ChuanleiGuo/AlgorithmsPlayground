import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Deque<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return res;
        }

        queue.add(root);
        boolean isOdd = true;
        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            Integer length = queue.size();
            
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.pollFirst();
                level.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            
            if (!isOdd) {
                Collections.reverse(level);
            }

            isOdd = !isOdd;
            res.add(level);
        }

        return res;
    }
}