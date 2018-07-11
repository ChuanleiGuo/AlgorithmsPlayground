public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
   public ListNode swapPairs(ListNode head) {
       ListNode dummyNode = new ListNode(0);
       dummyNode.next = head;

       ListNode pre = dummyNode;
       while (pre.next != null && pre.next.next != null) {
           ListNode node1 = pre.next;
           ListNode node2 = node1.next;

           node1.next = node2.next;
           node2.next = node1;
           pre.next = node2;

           pre = node1;
       }

       return dummyNode.next;
   }
}
