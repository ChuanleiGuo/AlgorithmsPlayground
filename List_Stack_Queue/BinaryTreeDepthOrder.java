import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Arrays;

public class BinaryTreeDepthOrder {
    public static List<List<Integer>> binaryTreeDepthOrder(BinaryTreeNode<Integer> tree) {
        Queue<BinaryTreeNode<Integer>> currDepthNodes = new LinkedList<>();
        currDepthNodes.add(tree);
        List<List<Integer>> result = new ArrayList<>();

        while (!currDepthNodes.isEmpty()) {
            Queue<BinaryTreeNode<Integer>> nextDepthNodes = new LinkedList<>();
            List<Integer> thisLevel = new ArrayList<>();
            while (!currDepthNodes.isEmpty()) {
                BinaryTreeNode<Integer> cur = currDepthNodes.poll();
                if (cur != null) {
                    thisLevel.add(cur.data);
                    nextDepthNodes.add(cur.left);
                    nextDepthNodes.add(cur.right);
                }
            }
            if (!thisLevel.isEmpty()) {
                result.add(thisLevel);
            }
            currDepthNodes = nextDepthNodes;
        }
        return result;
    }

    public static void main(String[] args) {
        //      3
        //    2   5
        //  1    4 6
        // 10
        // 13
        BinaryTreeNode<Integer> tree = new BinaryTreeNode<Integer>(3);
        tree.left = new BinaryTreeNode<Integer>(2);
        tree.left.left = new BinaryTreeNode<Integer>(1);
        tree.left.left.left = new BinaryTreeNode<Integer>(10);
        tree.left.left.left.right = new BinaryTreeNode<Integer>(13);
        tree.right = new BinaryTreeNode<Integer>(5);
        tree.right.left = new BinaryTreeNode<Integer>(4);
        tree.right.right = new BinaryTreeNode<Integer>(6);
        List<List<Integer>> result = binaryTreeDepthOrder(tree);
        List<List<Integer>> goldenRes = Arrays.asList(Arrays.asList(3), Arrays.asList(2, 5), Arrays.asList(1, 4, 6),
                Arrays.asList(10), Arrays.asList(13));
        if (!goldenRes.equals(result)) {
            System.err.println("Failed on input " + tree);
            System.err.println("Expected " + goldenRes);
            System.err.println("Your code produced " + result);
            System.exit(-1);
        } else {
            System.out.println("You passed all tests.");
        }
    }
}
