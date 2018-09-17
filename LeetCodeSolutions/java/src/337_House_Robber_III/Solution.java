import java.util.HashMap;
import java.util.Map;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    // top to bottom
    // public int rob(TreeNode root) {
    //     Map<TreeNode, Integer> valueMap = new HashMap<>();
    //     return robSub(root, valueMap);
    // }

    // private int robSub(TreeNode node, Map<TreeNode, Integer> valueMap) {
    //     if (node == null) {
    //         return 0;
    //     }
    //     if (valueMap.containsKey(node)) {
    //         return valueMap.get(node);
    //     }
    //     int value = 0;
    //     if (node.left != null) {
    //         value += robSub(node.left.left, valueMap) + robSub(node.left.right, valueMap);
    //     }
    //     if (node.right != null) {
    //         value += robSub(node.right.left, valueMap) + robSub(node.right.right, valueMap);
    //     }
        
    //     value = Math.max(value + node.val, robSub(node.left, valueMap) + robSub(node.right, valueMap));
    //     valueMap.put(node, value);
    //     return value;
    // }

    // dp on tree
    public int rob(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSub(TreeNode node) {
        if (node == null) {
            return new int[2];
        }
        int[] left = robSub(node.left);
        int[] right = robSub(node.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = node.val + left[0] + right[0];
        return res;
    }
}