public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
 
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = new ListNode(0), leftTail = leftHead;
        ListNode rightHead = new ListNode(0), rightTail = rightHead;

        while (head != null) {
            if (head.val < x) {
                leftTail.next = head;
                leftTail = leftTail.next;
            } else {
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;
        }
        leftTail.next = rightHead.next;
        rightTail.next = null;
        return leftHead.next;
    }
}
