public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;

        ListNode ptr1 = l1, ptr2 = l2;
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val < ptr2.val) {
                ListNode next = ptr1.next;
                tail.next = ptr1;
                ptr1 = next;
            } else {
                ListNode next = ptr2.next;
                tail.next = ptr2;
                ptr2 = next;
            }
            tail = tail.next;
            tail.next = null;
        }

        if (ptr1 != null) {
            tail.next = ptr1;
        }

        if (ptr2 != null) {
            tail.next = ptr2;
        }

        return dummyHead.next;
    }
}
