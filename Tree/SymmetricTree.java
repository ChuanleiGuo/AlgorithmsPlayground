public class SymmetricTree {
    public static boolean isSymmetric(BinaryTreeNode<Integer> tree) {
        return checkSymmetric(tree.left, tree.right);
    }

    private static boolean checkSymmetric(BinaryTreeNode<Integer> left, BinaryTreeNode<Integer> right) {
        if (left == null && right == null) {
            return true;
        } else if (left != null && right != null) {
            return left.data == right.data && checkSymmetric(left.left, left.right)
                    && checkSymmetric(right.left, right.right);
        }
        return false;
    }

    private static void simpleTest() {
        BinaryTreeNode<Integer> symmTree = new BinaryTreeNode<>();
        assert (isSymmetric(symmTree));
        symmTree.left = new BinaryTreeNode<Integer>();
        assert (!isSymmetric(symmTree));
        symmTree.right = new BinaryTreeNode<Integer>();
        assert (isSymmetric(symmTree));
        symmTree.right.right = new BinaryTreeNode<Integer>();
        assert (!isSymmetric(symmTree));
    }

    public static void main(String[] args) {
        simpleTest();
        // Non symmetric tree test
        //    x
        //  x   x
        // x   x x
        BinaryTreeNode<Integer> nonSymmTree = new BinaryTreeNode<>();
        nonSymmTree.left = new BinaryTreeNode<Integer>();
        nonSymmTree.left.left = new BinaryTreeNode<Integer>();
        nonSymmTree.right = new BinaryTreeNode<Integer>();
        nonSymmTree.right.left = new BinaryTreeNode<Integer>();
        nonSymmTree.right.right = new BinaryTreeNode<Integer>();
        assert (!isSymmetric(nonSymmTree));
        System.out.println(isSymmetric(nonSymmTree));
        // Symmetric tree test
        BinaryTreeNode<Integer> symmTree = new BinaryTreeNode<>();
        symmTree.left = new BinaryTreeNode<Integer>();
        symmTree.right = new BinaryTreeNode<Integer>();
        assert (isSymmetric(symmTree));
        System.out.println(isSymmetric(symmTree));
    }
}
