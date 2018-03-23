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

public class PairSearchMid {
    public static boolean pairIncludesAncestorAndDescendantOfM(BSTNode<Integer> node0, BSTNode<Integer> node1,
            BSTNode<Integer> mid) {
        BSTNode<Integer> search0 = node0, search1 = node1;

        while (search0 != node1 && search0 != mid && search1 != node0 && search1 != mid
                && (search0 != null || search1 != null)) {
            if (search0 != null) {
                search0 = search0.data > mid.data ? search0.left : search0.right;
            }

            if (search1 != null) {
                search1 = search1.data > mid.data ? search1.left : search1.right;
            }
        }

        if (search0 == node1 || search1 == node0 || (search0 != mid && search1 != mid)) {
            return false;
        }

        return search0 == mid ? searchTarget(mid, node1) : searchTarget(mid, node0);
    }

    private static boolean searchTarget(BSTNode<Integer> from, BSTNode<Integer> target) {
        while (from != null && from != target) {
            from = from.data > target.data ? from.left : from.right;
        }

        return from == target;
    }

    private static void smallTest() {
        BSTNode<Integer> root = new BSTNode<>(5);
        assert (!pairIncludesAncestorAndDescendantOfM(root, root, root));
        root.left = new BSTNode<>(2);
        root.left.right = new BSTNode<>(4);
        assert (!pairIncludesAncestorAndDescendantOfM(root.left, root, root.left.right));
        assert (pairIncludesAncestorAndDescendantOfM(root, root.left.right, root.left));

        // Example of the first figure of BST chapter.
        root = new BSTNode<>(19);
        root.left = new BSTNode<>(7);
        root.left.left = new BSTNode<>(3);
        root.left.left.left = new BSTNode<>(2);
        root.left.left.right = new BSTNode<>(5);
        root.left.right = new BSTNode<>(11);
        root.left.right.right = new BSTNode<>(17);
        root.left.right.right.left = new BSTNode<>(13);
        root.right = new BSTNode<>(43);
        root.right.left = new BSTNode<>(23);
        root.right.left.right = new BSTNode<>(37);
        root.right.left.right.left = new BSTNode<>(29);
        root.right.left.right.left.right = new BSTNode<>(31);
        root.right.left.right.right = new BSTNode<>(41);
        root.right.right = new BSTNode<>(47);
        root.right.right.right = new BSTNode<>(53);
        assert (!pairIncludesAncestorAndDescendantOfM(root.right, root.left, root.right.left));
        assert (pairIncludesAncestorAndDescendantOfM(root, root.right.left.right.left.right, root.right.left));
    }

    public static void main(String[] args) {
        smallTest();
        //    3
        //  2   5
        // 1   4 6
        BSTNode<Integer> root = new BSTNode<>(3);
        root.left = new BSTNode<>(2);
        root.left.left = new BSTNode<>(1);
        root.right = new BSTNode<>(5);
        root.right.left = new BSTNode<>(4);
        root.right.right = new BSTNode<>(6);
        assert (pairIncludesAncestorAndDescendantOfM(root, root.right.right, root.right));
        assert (pairIncludesAncestorAndDescendantOfM(root.right.right, root, root.right));
        assert (!pairIncludesAncestorAndDescendantOfM(root, root.right, root.right.right));
        assert (!pairIncludesAncestorAndDescendantOfM(root.right, root, root.right.right));
        assert (!pairIncludesAncestorAndDescendantOfM(root.right.left, root.right.right, root.right));
        assert (!pairIncludesAncestorAndDescendantOfM(root.right.left, root.left.left, root.right));
    }
}
