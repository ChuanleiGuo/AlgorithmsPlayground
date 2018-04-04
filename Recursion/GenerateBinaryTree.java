import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class BinaryTreeNode<T> {
    T val;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T val, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class GenerateBinaryTree {
    public static List<BinaryTreeNode<Integer>> generateAllBinaryTrees(int num) {
        List<BinaryTreeNode<Integer>> result = new ArrayList<>();
        if (num == 0) {
            result.add(null);
        }

        for (int numOfLeft = 0; numOfLeft < num; numOfLeft++) {
            int numOfRight = num - 1 - numOfLeft;
            List<BinaryTreeNode<Integer>> leftSubtrees = generateAllBinaryTrees(numOfLeft);
            List<BinaryTreeNode<Integer>> rightSubtrees = generateAllBinaryTrees(numOfRight);

            for (BinaryTreeNode<Integer> leftSubtree : leftSubtrees) {
                for (BinaryTreeNode<Integer> rightSubtree : rightSubtrees) {
                    result.add(new BinaryTreeNode<Integer>(0, leftSubtree, rightSubtree));
                }
            }
        }
        return result;
    }

    private static void smallTest() {
        assert generateAllBinaryTrees(1).size() == 1;
        assert generateAllBinaryTrees(2).size() == 2;
        assert generateAllBinaryTrees(3).size() == 5;
        assert generateAllBinaryTrees(4).size() == 14;
        assert generateAllBinaryTrees(5).size() == 42;
        assert generateAllBinaryTrees(10).size() == 16796;
    }

    public static void main(String[] args) {
        smallTest();
        Random r = new Random();
        int n;
        if (args.length == 1) {
            n = Integer.parseInt(args[0]);
        } else {
            n = r.nextInt(10) + 1;
        }
        System.out.println("n = " + n);
        generateAllBinaryTrees(n);
    }
}
