import java.util.PriorityQueue;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }

        if (minHeap.isEmpty()) {
            return null;
        }

        ListNode head = minHeap.peek();

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            if (node.next != null) {
                minHeap.add(node.next);
            }
            if (minHeap.peek() != null) {
                node.next = minHeap.peek();
            }
        }

        return head;
    }
}