public class LCAWithParent {
    public static BinaryTreeNode<Integer> LCA(BinaryTreeNode<Integer> node0, BinaryTreeNode<Integer> node1) {
        int depth0 = getDepth(node0), depth1 = getDepth(node1);
        if (depth1 > depth0) {
            BinaryTreeNode<Integer> temp = node0;
            node0 = node1;
            node1 = temp;
        }

        int diff = Math.abs(depth0 - depth1);
        while (diff-- > 0) {
            node0 = node0.parent;
        }

        while (node0 != node1) {
            node0 = node0.parent;
            node1 = node1.parent;
        }

        return node0;
    }

    private static int getDepth(BinaryTreeNode<Integer> node) {
        int depth = 0;
        while (node.parent != null) {
            depth++;
            node = node.parent;
        }
        return depth;
    }

    public static void main(String[] args) {
        // 3
        // 2 5
        // 1 4 6
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(3, null, null, null);
        root.left = new BinaryTreeNode<Integer>(2, null, null, root);
        root.left.left = new BinaryTreeNode<Integer>(1, null, null, root.left);
        root.right = new BinaryTreeNode<Integer>(5, null, null, root);
        root.right.left = new BinaryTreeNode<Integer>(4, null, null, root.right);
        root.right.right = new BinaryTreeNode<Integer>(6, null, null, root.right);

        // should output 3
        assert (LCA(root.left, root.right).data.equals(3));
        System.out.println(LCA(root.left, root.right).data);
        // should output 5
        assert (LCA(root.right.left, root.right.right).data.equals(5));
        System.out.println(LCA(root.right.left, root.right.right).data);
        // should output 3
        assert (LCA(root.left, root.right.left).data.equals(3));
        System.out.println(LCA(root.left, root.right.left).data);
        // should output 2
        assert (LCA(root.left, root.left.left).data.equals(2));
        System.out.println(LCA(root.left, root.left.left).data);
    }
}
