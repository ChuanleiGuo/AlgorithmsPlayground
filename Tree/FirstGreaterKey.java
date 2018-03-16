public class FirstGreaterKey {
    public static class BSTNode<T> {
        public T data;
        public BSTNode<T> left, right;

        public BSTNode(T data) {
            this.data = data;
        }
    }

    public static BSTNode<Integer> findFirstGreaterThanK(BSTNode<Integer> tree, Integer k) {
        BSTNode<Integer> substree = tree, firstSoFar = null;
        while (substree != null) {
            if (substree.data > k) {
                firstSoFar = substree;
                substree = substree.left;
            } else {
                substree = substree.right;
            }
        }
        return firstSoFar;
    }

    public static void main(String[] args) {
        // 3
        // 2 5
        // 1 4 7
        BSTNode<Integer> tree = new BSTNode<>(3);
        assert (findFirstGreaterThanK(tree, 1) == tree);
        assert (findFirstGreaterThanK(tree, 7) == null);
        tree.left = new BSTNode<>(2);
        tree.left.left = new BSTNode<>(1);
        tree.right = new BSTNode<>(5);
        tree.right.left = new BSTNode<>(4);
        tree.right.right = new BSTNode<>(7);
        assert (findFirstGreaterThanK(tree, 1) == tree.left);
        assert (findFirstGreaterThanK(tree, 5) == tree.right.right);
        assert (findFirstGreaterThanK(tree, 6) == tree.right.right);
        assert (findFirstGreaterThanK(tree, 7) == null);
    }
}
