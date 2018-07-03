public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        int start = m, end = n;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left_p = dummy;
        for (int i = 0; i < m - 1; i++) {
            left_p = left_p.next;
            start--;
            end--;
        }
        ListNode cur = left_p.next;
        ListNode right_p = cur;
        ListNode pre = null;

        while (end > 0) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            end--;
        }
        right_p.next = cur;
        left_p.next = pre;

        return dummy.next;
    }
}
