import java.util.ArrayList;
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

public class RangeLookup {
    private static class Interval {
        public int left, right;

        public Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static List<Integer> rangeLookupInBST(BSTNode<Integer> tree, Interval interval) {
        List<Integer> result = new ArrayList<>();
        helper(tree, interval, result);
        return result;
    }

    private static void helper(BSTNode<Integer> tree, Interval interval, List<Integer> result) {
        if (tree == null) {
            return;
        }
        if (interval.left < tree.data && tree.data < interval.right) {
            helper(tree.left, interval, result);
            result.add(tree.data);
            helper(tree.right, interval, result);
        } else if (interval.left > tree.data) {
            helper(tree.right, interval, result);
        } else {
            helper(tree.left, interval, result);
        }
    }
}
