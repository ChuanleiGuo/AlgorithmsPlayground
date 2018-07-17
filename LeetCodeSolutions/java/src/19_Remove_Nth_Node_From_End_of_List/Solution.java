public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n < 0) { return head; }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        ListNode q = dummyHead;

        for (int i = 0; i < n + 1; i++) {
            q = q.next;
        }

        while (q != null) {
            p = p.next;
            q = q.next;
        }

        ListNode delNode = p.next;
        p.next = delNode.next;

        return dummyHead.next;
    }
}
