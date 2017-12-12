public class ReverseSublist {
    public static ListNode<Integer> reverseSublist(ListNode<Integer> l, int start, int end) {
        if (start == end) {
            return l;
        }

        ListNode<Integer> dummyHead = new ListNode<>(0, l);
        ListNode<Integer> sublistHead = dummyHead;

        int k = 1;
        while (k++ < start) {
            sublistHead = sublistHead.next;
        }

        ListNode<Integer> sublistIter = sublistHead.next;
        while (k++ < end) {
            ListNode<Integer> temp = sublistIter.next;
            sublistIter.next = temp.next;
            temp.next = sublistIter;
            sublistHead.next = temp;
        }
        return dummyHead.next;
    }

    private static void simpleTest() {
        ListNode<Integer> L = null;
        ListNode<Integer> result = reverseSublist(L, 0, 0);
        assert (result == null);

        L = new ListNode<>(1, null);
        result = reverseSublist(L, 0, 0);
        assert (result == L && result.next == null);

        L = new ListNode<>(1, new ListNode<>(2, new ListNode<>(3, null)));
        result = reverseSublist(L, 0, 1);
        assert (result.data == 2 && result.next.data == 1 && result.next.next.data == 3
                && result.next.next.next == null);

        L = new ListNode<>(1, new ListNode<>(2, new ListNode<>(3, null)));
        result = reverseSublist(L, 0, 2);
        assert (result.data == 3 && result.next.data == 2 && result.next.next.data == 1
                && result.next.next.next == null);
    }

    public static void main(String[] args) {
        simpleTest();
        ListNode<Integer> L;
        L = new ListNode<>(1, new ListNode<>(2, new ListNode<>(3, null)));
        ListNode<Integer> result = reverseSublist(L, 3, 3);
        assert (result.data.equals(1) && result.next.data.equals(2) && result.next.next.data.equals(3)
                && result.next.next.next == null);
        while (result != null) {
            System.out.println(result.data);
            result = result.next;
        }

        result = reverseSublist(L, 2, 3);
        assert (result.data.equals(1) && result.next.data.equals(3) && result.next.next.data.equals(2)
                && result.next.next.next == null);
        while (result != null) {
            System.out.println(result.data);
            result = result.next;
        }
    }
}
