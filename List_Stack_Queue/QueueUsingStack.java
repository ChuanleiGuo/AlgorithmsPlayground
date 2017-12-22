import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class QueueUsingStack {
    public static class Queue {
        Deque<Integer> enq = new LinkedList<>();
        Deque<Integer> deq = new LinkedList<>();

        public void enqueue(Integer x) {
            enq.add(x);
        }

        public Integer dequeue() {
            if (deq.isEmpty()) {
                while (!enq.isEmpty()) {
                    deq.addFirst(enq.removeFirst());
                }
            }
            if (!deq.isEmpty()) {
                return deq.removeFirst();
            }
            throw new NoSuchElementException("call dequeue on an empty queue");
        }
    }

    private static void assertDequeue(Queue q, Integer t) {
        Integer dequeue = q.dequeue();
        assert (t.equals(dequeue));
    }

    public static void main(String[] args) {
        Queue Q = new Queue();
        Q.enqueue(1);
        Q.enqueue(2);
        assertDequeue(Q, 1);
        assertDequeue(Q, 2);
        Q.enqueue(3);
        assertDequeue(Q, 3);
        try {
            Q.dequeue();
            assert (false);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        Q.enqueue(-1);
        Q.enqueue(123);
        Q.enqueue(Integer.MAX_VALUE);
        Q.enqueue(Integer.MIN_VALUE);
        Q.enqueue(0);
        assertDequeue(Q, -1);
        Q.enqueue(0);
        assertDequeue(Q, 123);
        assertDequeue(Q, Integer.MAX_VALUE);
        assertDequeue(Q, Integer.MIN_VALUE);
        assertDequeue(Q, 0);
        assertDequeue(Q, 0);
        try {
            Q.dequeue();
            assert (false);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
