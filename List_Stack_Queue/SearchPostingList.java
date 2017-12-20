import java.util.Deque;
import java.util.LinkedList;

public class SearchPostingList {
    public static void setJumpOrderIterative(PostingListNode<Integer> l) {
        setJumpOrderHelper(l, 0);
    }

    private static int setJumpOrderHelper(PostingListNode<Integer> l, int order) {
        if (l != null && l.order == -1) {
            l.order = order++;
            order = setJumpOrderHelper(l.jump, order);
            order = setJumpOrderHelper(l.next, order);
        }
        return order;
    }

    public static void setJumpOrderRecursive(PostingListNode<Integer> l) {
        Deque<PostingListNode> s = new LinkedList<>();
        int order = 0;
        s.addFirst(l);
        while (!s.isEmpty()) {
            PostingListNode<Integer> node = s.removeFirst();
            if (node != null && node.order == -1) {
                node.order = order++;
                s.addFirst(node.next);
                s.addFirst(node.jump);
            }
        }
    }

    private static PostingListNode<Integer> makeList() {
        PostingListNode<Integer> L = null, curr = null;
        // Build a linked list L->1->2->3->4->5->nullptr.
        for (int i = 0; i < 5; ++i) {
            PostingListNode<Integer> temp = new PostingListNode(-1, null, null);
            if (curr != null) {
                curr.next = temp;
                curr = temp;
            } else {
                curr = L = temp;
            }
        }

        L.jump = null; // no jump from 1
        L.next.jump = L.next.next.next; // 2's jump points to
        // 4
        L.next.next.jump = L; // 3's jump points to 1
        L.next.next.next.jump = null; // no jump from 4
        L.next.next.next.next.jump = L.next.next.next.next; // 5's jump points
        // to 5
        return L;
    }

    public static void main(String[] args) {

        PostingListNode<Integer> temp = makeList();
        setJumpOrderIterative(temp);
        // output the jump-first order, it should be 0, 1, 4, 2, 3
        assert (temp.order == 0);
        temp = temp.next;
        assert (temp.order == 1);
        temp = temp.next;
        assert (temp.order == 4);
        temp = temp.next;
        assert (temp.order == 2);
        temp = temp.next;
        assert (temp.order == 3);

        temp = makeList();
        setJumpOrderRecursive(temp);
        assert (temp.order == 0);
        temp = temp.next;
        assert (temp.order == 1);
        temp = temp.next;
        assert (temp.order == 4);
        temp = temp.next;
        assert (temp.order == 2);
        temp = temp.next;
        assert (temp.order == 3);
    }
}
