public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int counter = 0;
        while (curr != null && counter < k) {
            curr = curr.next;
            counter++;
        }

        if (counter == k) {
            curr = reverseKGroup(curr, k);

            while (counter-- > 0) {
                ListNode tmp = head.next;
                head.next = curr;
                curr = head;
                head = tmp;
            }

            head = curr;
        }

        return head;
    }
}
