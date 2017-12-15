public class RemoveLastKElement {
    public static ListNode<Integer> removeLastKElement(ListNode<Integer> l, int k) {
        ListNode<Integer> dummyHead = new ListNode(0, l);
        ListNode<Integer> first = dummyHead.next;

        while (k-- > 0) {
            first = first.next;
        }

        ListNode<Integer> second = dummyHead;
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode<Integer> L = new ListNode<>(1, new ListNode<>(2, new ListNode<>(3, null)));
        L = removeLastKElement(L, 2);
        assert (L.data == 1 && L.next.data == 3);
        L = removeLastKElement(L, 2);
        assert (L.data == 3 && L.next == null);
        L = removeLastKElement(L, 1);
        assert (L == null);
    }
}
