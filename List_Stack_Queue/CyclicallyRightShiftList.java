public class CyclicallyRightShiftList {
    public static ListNode<Integer> cyclicallyRightShiftList(ListNode<Integer> l, int k) {
        if (l == null) {
            return null;
        }
        ListNode<Integer> tail = l;
        int n = 1;
        while (tail.next != null) {
            n++;
            tail = tail.next;
        }
        k %= n;
        if (k == 0) {
            return l;
        }
        tail.next = l;
        int stepToHead = n - k;
        ListNode<Integer> newTail = tail;
        while (stepToHead-- > 0) {
            newTail = newTail.next;
        }
        ListNode<Integer> newHead = newTail.next;
        newTail.next = null;
        return newTail;
    }

    private static void simpleTest() {
        ListNode<Integer> L;
        L = new ListNode<>(1, null);
        ListNode<Integer> result = cyclicallyRightShiftList(L, 2);
        assert (result == L);
        L.next = new ListNode<>(2, null);
        result = cyclicallyRightShiftList(L, 2);
        assert (result == L);
        result = cyclicallyRightShiftList(L, 3);
        assert (result.next == L);
    }

    public static void main(String[] args) {
        simpleTest();
        ListNode<Integer> L;
        L = new ListNode<>(1, new ListNode<>(2, new ListNode<>(3, null)));
        ListNode<Integer> result = cyclicallyRightShiftList(L, 2);
        assert (result.data.equals(2) && result.next.data.equals(3) && result.next.next.data.equals(1)
                && result.next.next.next == null);
    }
}
