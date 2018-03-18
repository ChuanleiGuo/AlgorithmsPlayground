import java.util.Arrays;
import java.util.List;

class BSTNode<T> {
    public T data;
    public BSTNode<T> left, right;

    public BSTNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public BSTNode(T data, BSTNode<T> left, BSTNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

public class RebuildBSTFromPreorder {

    public static BSTNode<Integer> rebuildBSTFromPreorder(List<Integer> preorderSeq) {
        return helper(preorderSeq, 0, preorderSeq.size());
    }

    private static BSTNode<Integer> helper(List<Integer> preorderSeq, int start, int end) {
        if (start >= end) {
            return null;
        }
        int midPoint = start + 1;
        while (midPoint < end && preorderSeq.get(midPoint).compareTo(preorderSeq.get(start)) < 0) {
            midPoint++;
        }
        return new BSTNode<Integer>(preorderSeq.get(start), helper(preorderSeq, start + 1, midPoint),
                helper(preorderSeq, midPoint, end));
    }

    private static void checkAns(BSTNode<Integer> n, Integer pre) {
        if (n != null) {
            checkAns(n.left, pre);
            assert (Integer.compare(pre, n.data) <= 0);
            System.out.println(n.data);
            checkAns(n.right, n.data);
        }
    }

    public static void main(String[] args) {
        // 3
        // 2 5
        // 1 4 6
        // should output 1, 2, 3, 4, 5, 6
        // preorder [3, 2, 1, 5, 4, 6]
        List<Integer> preorder = Arrays.asList(3, 2, 1, 5, 4, 6);
        BSTNode<Integer> tree = rebuildBSTFromPreorder(preorder);
        checkAns(tree, Integer.MIN_VALUE);
        assert (3 == tree.data);
        assert (2 == tree.left.data);
        assert (1 == tree.left.left.data);
        assert (5 == tree.right.data);
        assert (4 == tree.right.left.data);
        assert (6 == tree.right.right.data);
    }
}
