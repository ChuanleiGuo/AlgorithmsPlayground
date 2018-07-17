public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }

        if (node.next == null) {
            node = null;
            return;
        }

        node.val = node.next.val;
        ListNode deleteNode = node.next;
        node.next = deleteNode.next;

        return;
    }
}
