import java.util.List;

public class SortList {
    public static class ListNode<T> {
        public T data;
        public ListNode<T> next;

        public ListNode(T data, ListNode<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    public static ListNode<Integer> insertionSort(final ListNode<Integer> L) {
        ListNode<Integer> dummyHead = new ListNode<>(0, L);
        ListNode<Integer> iter = L;

        while (iter != null && iter.next != null) {
            if (iter.data > iter.next.data) {
                ListNode<Integer> target = iter.next, pre = dummyHead;
                while (pre.next.data < target.data) {
                    pre = pre.next;
                }
                ListNode<Integer> temp = pre.next;
                pre.next = target;
                iter.next = target.next;
                target.next = temp;
            } else {
                iter = iter.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode<Integer> L;
        L = new ListNode<>(1, new ListNode<>(4, new ListNode<>(3, new ListNode<>(2, new ListNode<>(5, null)))));
        ListNode<Integer> result = insertionSort(L);
        ListNode<Integer> pre = null;
        while (result != null) {
            assert (pre == null || pre.data <= result.data);
            pre = result;
            System.out.println(result.data);
            result = result.next;
        }
    }
}
