import java.util.LinkedList;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode res = new ListNode(0);
        while (stack1.size() > 0 || stack2.size() > 0) {
            if (stack1.size() > 0) {
                carry += stack1.pop();
            }
            if (stack2.size() > 0) {
                carry += stack2.pop();
            }

            res.val = carry % 10;
            ListNode head = new ListNode(carry / 10);
            head.next = res;
            res = head;
            carry /= 10;
        }

        return res.val == 0 ? res.next : res;
    }
}
