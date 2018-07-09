
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode cur = dummyHead;
        while (cur.next != null) {
            ListNode next = cur.next;
            if (next.next != null && next.next.val == next.val) {
                ListNode dup = next.next;

                while (dup != null && dup.val == next.val) {
                    dup = dup.next;
                }
    
                cur.next = dup;
            } else {
                cur = cur.next;
            }
        }

        return dummyHead.next;
    }
}
