public class ConstructRightSibling {
    public static void constructRightSibling(BinaryTreeNode<Integer> tree) {
        BinaryTreeNode<Integer> leftStart = tree;
        while (leftStart != null && leftStart.left != null) {
            populateLowerNextField(leftStart);
            leftStart = leftStart.left;
        }
    }

    private static void populateLowerNextField(BinaryTreeNode<Integer> startNode) {
        BinaryTreeNode<Integer> iter = startNode;
        while (iter != null) {
            iter.left.next = iter.right;

            if (iter.next != null) {
                iter.right.next = iter.next.left;
            }
            iter = iter.next;
        }
    }
}
