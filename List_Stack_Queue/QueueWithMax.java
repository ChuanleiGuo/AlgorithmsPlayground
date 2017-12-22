import java.util.NoSuchElementException;

public class QueueWithMax {
    private StackWithMaxImproved.Stack enq = new StackWithMaxImproved.Stack();
    private StackWithMaxImproved.Stack deq = new StackWithMaxImproved.Stack();

    public void enqueue(Integer x) {
        enq.push(x);
    }

    public Integer dequeue() {
        if (deq.isEmpty()) {
            while (!enq.isEmpty()) {
                deq.push(enq.pop());
            }
        }
        if (!deq.isEmpty()) {
            return deq.pop();
        }
        throw new NoSuchElementException("call dequeue on an empty queue");
    }

    public Integer max() {
        if (!enq.isEmpty()) {
            return deq.isEmpty() ? enq.max() : Math.max(deq.max(), enq.max());
        }
        if (!deq.isEmpty()) {
            return deq.max();
        }
        throw new NoSuchElementException("call max on am empty queue");
    }

    private static void assertDequeue(QueueWithMax q, Integer t) {
        Integer dequeue = q.dequeue();
        assert (t.equals(dequeue));
    }

    private static void simpleTest() {
        QueueWithMax Q = new QueueWithMax();
        Q.enqueue(11);
        Q.enqueue(2);
        assert (11 == Q.max());
        assertDequeue(Q, 11);
        assert (2 == Q.max());
        assertDequeue(Q, 2);
        Q.enqueue(3);
        assert (3 == Q.max());
        assertDequeue(Q, 3);
        Q.enqueue(Integer.MAX_VALUE - 1);
        Q.enqueue(Integer.MAX_VALUE);
        Q.enqueue(-2);
        Q.enqueue(-1);
        Q.enqueue(-1);
        Q.enqueue(Integer.MIN_VALUE);
        assert (Integer.MAX_VALUE == Q.max());
        assertDequeue(Q, Integer.MAX_VALUE - 1);
        assert (Integer.MAX_VALUE == Q.max());
        assertDequeue(Q, Integer.MAX_VALUE);
        assert (-1 == Q.max());
        assertDequeue(Q, -2);
        assert (-1 == Q.max());
        assertDequeue(Q, -1);
        assertDequeue(Q, -1);
        assert (Integer.MIN_VALUE == Q.max());
        assertDequeue(Q, Integer.MIN_VALUE);
        try {
            System.out.println("Q is empty, max() call should except = " + Q.max());
            assert (false);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        simpleTest();
        QueueWithMax Q = new QueueWithMax();
        Q.enqueue(1);
        Q.enqueue(2);
        assert (2 == Q.max());
        assertDequeue(Q, 1);
        assert (2 == Q.max());
        assertDequeue(Q, 2);
        Q.enqueue(3);
        assert (3 == Q.max());
        assertDequeue(Q, 3);
        try {
            Q.max();
            assert (false);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            Q.dequeue();
            assert (false);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
