public class ReverseLinkedListIterative {
    public static ListNode<Integer> reverseLinkedList(ListNode<Integer> l) {
        if (l == null) {
            return null;
        }
        ListNode<Integer> dummyHead = new ListNode<Integer>(0, null);
        ListNode<Integer> iter = l;
        while (iter != null) {
            ListNode<Integer> cur = iter;
            iter = iter.next;
            cur.next = dummyHead.next;
            dummyHead.next = cur;
        }
        return dummyHead.next;
    }
}
