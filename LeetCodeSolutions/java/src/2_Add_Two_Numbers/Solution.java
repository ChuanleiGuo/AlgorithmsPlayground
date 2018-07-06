public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0), rptr = result;
        ListNode ptr1 = l1, ptr2 = l2;
        int carry = 0;
        while (ptr1 != null && ptr2 != null) {
            int val = ptr1.val + ptr2.val + carry;
            ListNode node = new ListNode(val % 10);
            carry = val / 10;
            rptr.next = node;
            rptr = rptr.next;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        while (ptr1 != null) {
            int val = ptr1.val + carry;
            ListNode node = new ListNode(val % 10);
            carry = val / 10;
            rptr.next = node;
            rptr = rptr.next;
            ptr1 = ptr1.next;
        }

        while (ptr2 != null) {
            int val = ptr2.val + carry;
            ListNode node = new ListNode(val % 10);
            carry = val / 10;
            rptr.next = node;
            rptr = rptr.next;
            ptr2 = ptr2.next;
        }

        if (carry > 0) {
            ListNode node = new ListNode(carry);
            rptr.next = node;
        }

        return result.next;
    }
}
