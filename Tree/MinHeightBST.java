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

public class MinHeightBST {
    public static BSTNode<Integer> buildMinHeightBSTFromSortedArray(List<Integer> arr) {
        return helper(arr, 0, arr.size());
    }

    private static BSTNode<Integer> helper(List<Integer> arr, int start, int end) {
        if (start >= end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        return new BSTNode<Integer>(
            arr.get(mid),
            helper(arr, start, mid),
            helper(arr, mid + 1, end));
    }
}
