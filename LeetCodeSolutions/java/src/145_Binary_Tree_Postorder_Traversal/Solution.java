import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    int val;
    reeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


class Solution {

    class Command {
        String cmdString;
        TreeNode node;
        Command(String cmdString, TreeNode node) { this.cmdString = cmdString; this.node = node; }
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        if (root == null) {
            return res;
        }

        Deque<Command> stack = new LinkedList<>();
        stack.push(new Command("go", root));
        while (!stack.isEmpty()) {
            Command cmd = stack.pop();

            if (cmd.cmdString == "print") {
                res.add(cmd.node.val);
            } else {
                stack.push(new Command("print", cmd.node));
                if (cmd.node.right != null) {
                    stack.push(new Command("go", cmd.node.right));
                }
                if (cmd.node.left != null) {
                    stack.push(new Command("go", cmd.node.left));
                }
            }
        }

        return res;
    }
}
