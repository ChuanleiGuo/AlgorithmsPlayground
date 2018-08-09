import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            res.add(String.valueOf(root.val));
        }
        List<String> leftStrings = binaryTreePaths(root.left);
        for (String lString : leftStrings) {
            res.add(String.valueOf(root.val) + "->" +lString);
        }
        List<String> rightStrings = binaryTreePaths(root.right);
        for (String rString : rightStrings) {
            res.add(String.valueOf(root.val) + "->" + rString);
        }
        return res;
    }
}