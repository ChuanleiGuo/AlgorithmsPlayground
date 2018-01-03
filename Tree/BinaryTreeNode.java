public class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> parent;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
    BinaryTreeNode<T> next;

    public BinaryTreeNode() {
        BinaryTreeNode(null, null, null, null, null);
    }

    public BinaryTreeNode(T data) {
        BinaryTreeNode(data, null, null, null, null);
    }

    public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        BinaryTreeNode(data, left, right, null, null);
    }

    public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right, BinaryTreeNode<T> parent) {
        BinaryTreeNode(data, left, right, parent, null);
    }

    public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right, BinaryTreeNode<T> parent, BinaryTreeNode<T> next) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.next = next;
    }
}
