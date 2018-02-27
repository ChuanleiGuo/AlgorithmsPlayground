import java.util.HashSet;
import java.util.Set;

public class LCAOfTreeNodes {
    public static BinaryTree<Integer> LCA(BinaryTree<Integer> node0, BinaryTree node1) {
        Set<BinaryTree<Integer>> hash = new HashSet<>();
        while (node0 != null || node1 != null) {
            if (node0 != null) {
                if (!hash.add(node0)) {
                    return node0;
                }
                node0 = node0.parent;
            }
            if (node1 != null) {
                if (!hash.add(node1)) {
                    return node1;
                }
                node1 = node1.parent;
            }
        }
        throw new IllegalArgumentException("node0 and node1 are not in the same tree");
    }
}
