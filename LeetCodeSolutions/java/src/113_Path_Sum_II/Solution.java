import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                List<Integer> leaves = Arrays.asList(root.val);
                result.add(leaves);
            }
            return result;
        }

        List<List<Integer>> leftLeaves = pathSum(root.left, sum - root.val);
        List<List<Integer>> rightLeaves = pathSum(root.right, sum - root.val);
        
        leftLeaves.addAll(rightLeaves);

        for (List<Integer> leaves : leftLeaves) {
            List<Integer> nodes = new ArrayList<>();
            nodes.add(root.val);
            nodes.addAll(leaves);
            result.add(nodes);
        }

        return result;
    }
}