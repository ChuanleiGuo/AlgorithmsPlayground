public class TestOverlappingList {
    public static ListNode<Integer> overlapping(ListNode<Integer> l1, ListNode<Integer> l2) {
        int l1_len = length(l1), l2_len = length(l2);

        if (l1_len > l2_len) {
            l1 = advanceByK(l1_len - l2_len, l1);
        } else {
            l2 = advanceByK(l2_len - l1_len, l2);
        }

        while (l1 != null && l2 != null && l1 != l2) {
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1;
    }

    private static ListNode<Integer> advanceByK(int k, ListNode<Integer> l) {
        while (k-- > 0) {
            l = l.next;
        }
        return l;
    }

    private static int length(ListNode<Integer> l) {
        int len = 0;
        while (l != null) {
            len++;
            l = l.next;
        }
        return len;
    }

    public static void main(String[] args) {
        ListNode<Integer> L1 = null;
        ListNode<Integer> L2 = null;
        // L1: 1->2->3->null
        L1 = new ListNode<>(1, new ListNode<>(2, new ListNode<>(3, null)));
        L2 = L1.next.next;
        assert (overlapping(L1, L2).data == 3);
        // L2: 4->5->null
        L2 = new ListNode<>(4, new ListNode<>(5, null));
        assert (overlapping(L1, L2) == null);
    }
}
