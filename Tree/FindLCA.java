class BSTNode<T> {
    public T data;
    public BSTNode<T> left, right;

    public BSTNode(T data) {
        this.data = data;
    }
}

public class FindLCA {
    public static BSTNode<Integer> findLCA(BSTNode<Integer> tree, BSTNode<Integer> s, BSTNode<Integer> b) {
        BSTNode<Integer> p = tree;
        while (p.data < s.data || p.data > b.data) {
            if (p.data < s.data) {
                p = p.right;
            }
            while (p.data > b.data) {
                p = p.left;
            }
        }
        return p;
    }
}
