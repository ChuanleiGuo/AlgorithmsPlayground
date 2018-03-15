import java.util.LinkedList;
import java.util.Queue;

public class IsBinaryTreeBST {
    public static boolean isBinaryTreeBST(BinaryTreeNode<Integer> tree) {
        return areKeysInRange(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean areKeysInRange(BinaryTreeNode<Integer> tree, Integer low, Integer high) {
        if (tree == null) {
            return true;
        } else if (tree.data < low || tree.data > high) {
            return false;
        } else {
            return areKeysInRange(tree.left, low, tree.data) && areKeysInRange(tree.right, tree.data, high);
        }
    }

    private static class QueueEntry {
        public BinaryTreeNode<Integer> node;
        public Integer lowerBound, upperBound;

        public QueueEntry(BinaryTreeNode<Integer> node, Integer lowerBound, Integer upperBound) {
            this.node = node;
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        }
    }

    public static boolean isBinaryTreeBSTAlter(BinaryTreeNode<Integer> tree) {
        Queue<QueueEntry> queue = new LinkedList<>();
        queue.add(new QueueEntry(tree, Integer.MIN_VALUE, Integer.MAX_VALUE));

        QueueEntry headEntry;
        while ((headEntry = queue.poll()) != null) {
            if (headEntry.node != null) {
                if (headEntry.node.data < headEntry.lowerBound || headEntry.node.data > headEntry.upperBound) {
                    return false;
                }

                queue.add(new QueueEntry(headEntry.node.left, headEntry.lowerBound, headEntry.node.data));
                queue.add(new QueueEntry(headEntry.node.right, headEntry.node.data, headEntry.upperBound));
            }
        }
        return true;
    }
}
