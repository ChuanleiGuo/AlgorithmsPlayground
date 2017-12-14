public class DeleteNode {
    public static void deleteNode(ListNode<Integer> p) {
        p.data = p.next.data;
        p.next = p.next.next;
    }
}
