public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode insertionSortList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode curr = head;
        ListNode pre = dummyHead;

        while (curr != null) {
            ListNode next = curr.next;

            while (pre.next != null && pre.next.val < curr.val) {
                pre = pre.next;
            }

            curr.next = pre.next;
            pre.next = curr;
            curr = next;
            pre = dummyHead;
        }

        return dummyHead.next;
    }
}
