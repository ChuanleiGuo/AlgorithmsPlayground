public class AddTwoNumber {
    public static ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> dummyHead = new ListNode<Integer>(0, null);
        ListNode<Integer> placeIter = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }
            placeIter.next = new ListNode<Integer>(sum % 10, null);
            carry = sum / 10;
            placeIter = placeIter.next;
        }
        if (carry > 0) {
            placeIter.next = new ListNode<Integer>(carry, null);
        }
        return dummyHead.next;
    }

    private static void simpleTest() {
        ListNode<Integer> L;
        L = new ListNode<>(2, new ListNode<>(4, new ListNode<>(3, null)));
        ListNode<Integer> R;
        R = new ListNode<>(0, null);
        ListNode<Integer> S = addTwoNumbers(L, R);
        assert (S.data.equals(2) && S.next.data.equals(4) && S.next.next.data.equals(3));

        L = new ListNode<>(3, new ListNode<>(4, new ListNode<>(2, null)));
        R = new ListNode<>(7, new ListNode<>(5, new ListNode<>(7, null)));
        S = addTwoNumbers(L, R);
        assert (S.data.equals(0) && S.next.data.equals(0) && S.next.next.data.equals(0)
                && S.next.next.next.data.equals(1));

        L = new ListNode<>(1, null);
        R = new ListNode<>(1, null);
        S = addTwoNumbers(L, R);
        assert (S.data.equals(2) && S.next == null);

        L = new ListNode<>(5, null);
        R = new ListNode<>(5, null);
        S = addTwoNumbers(L, R);
        assert (S.data.equals(0) && S.next.data == 1 && S.next.next == null);

        L = new ListNode<>(2, new ListNode<>(4, new ListNode<>(3, null)));
        R = new ListNode<>(5, new ListNode<>(6, new ListNode<>(7, null)));
        S = addTwoNumbers(L, R);
        assert (S.data.equals(7) && S.next.data.equals(0) && S.next.next.data.equals(1)
                && S.next.next.next.data.equals(1));
        L = new ListNode<>(9, new ListNode<>(9, null));
        R = new ListNode<>(9, null);
        S = addTwoNumbers(L, R);
        assert (S.data.equals(8) && S.next.data.equals(0) && S.next.next.data.equals(1));
    }

    public static void main(String[] args) {
        simpleTest();
    }
}
