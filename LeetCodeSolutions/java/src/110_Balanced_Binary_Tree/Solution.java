public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    // public boolean isBalanced(TreeNode root) {
    //     if (root == null) {
    //         return true;
    //     }
    //     int left = depth(root.left);
    //     int right = depth(root.right);
    //     return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    // }

    // private int depth(TreeNode node) {
    //     if (node == null) {
    //         return 0;
    //     }
    //     return Math.max(depth(node.left), depth(node.right)) + 1;
    // }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {  
            return true;
        }
        return dfsHeight(root) != -1;
    }

    private int dfsHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = dfsHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = dfsHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}