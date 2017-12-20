public class PostingListNode<T> {
    public T order;
    public PostingListNode<T> jump;
    public PostingListNode<T> next;

    public PostingListNode(T order, PostingListNode<T> jump, PostingListNode next) {
        this.order = order;
        this.jump = jump;
        this.next = next;
    }
}
