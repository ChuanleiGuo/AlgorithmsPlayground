
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;

        ListNode cur1 = l1, cur2 = l2;
        while (cur1 != null & cur2 != null) {
            if (cur1.val < cur2.val) {
                tail.next = cur1;
                cur1 = cur1.next;
            } else {
                tail.next = cur2;
                cur2 = cur2.next;
            }
            tail = tail.next;
        }

        if (cur1 != null) {
            tail.next = cur1;
        }

        if (cur2 != null) {
            tail.next = cur2;
        }

        return dummyHead.next;
    }
}
