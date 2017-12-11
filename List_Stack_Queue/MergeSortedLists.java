class ListNode<T> {
    public T data;
    public ListNode<T> next;
}

public class MergeSortedLists {
    public static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> dummyHead = new ListNode(0, null);
        ListNode<Integer> current = dummyHead;
        ListNode<Integer> p1 = l1, p2 = l2;

        while (p1 != null && p2 != null) {
            if (p1.data < p2.data) {
                current.next = p1;
                p1 = p1.next;
            } else {
                current.next = p2;
                p2 = p2.next;
            }
            current = current.next;
        }

        current.next = p1 != null ? p1 : p2;
        return dummyHead.next;
    }
}
