import java.util.Deque;
import java.util.LinkedList;

public class StackWithMaxImproved {

    private static class MaxWithCount {
        public Integer max;
        public Integer count;

        public MaxWithCount(Integer max, Integer count) {
            this.max = max;
            this.count = count;
        }
    }

    public static class Stack {
        private Deque<Integer> elements = new LinkedList<>();
        private Deque<MaxWithCount> cachedMaxWithCounts = new LinkedList<>();

        public Stack() {}

        public boolean isEmpty() {
            return elements.isEmpty();
        }

        public Integer max() {
            if (isEmpty()) {
                throw new IllegalStateException("max(): empty stack");
            }
            return cachedMaxWithCounts.peekFirst().max;
        }

        public Integer pop() {
            if (isEmpty()) {
                throw new IllegalStateException("pop(): empty stack");
            }
            Integer popElement = elements.removeFirst();
            if (popElement.equals(cachedMaxWithCounts.peekFirst().max)) {
                cachedMaxWithCounts.peekFirst().count =
                    cachedMaxWithCounts.peekFirst().count -  1;
            }
            if (cachedMaxWithCounts.peekFirst().count.equals(0)) {
                cachedMaxWithCounts.removeFirst();
            }
            return popElement;
        }

        public void push(Integer x) {
            elements.addFirst(x);
            if (!cachedMaxWithCounts.isEmpty()) {
                if (Integer.compare(x, cachedMaxWithCounts.peekFirst().max) == 0) {
                    cachedMaxWithCounts.peekFirst().count += 1;
                } else if (Integer.compare(x, cachedMaxWithCounts.peekFirst().max) > 0) {
                    cachedMaxWithCounts.add(new MaxWithCount(x, 1));
                }
            } else {
                cachedMaxWithCounts.add(new MaxWithCount(x, 1));
            }
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        assert (s.max() == 2);
        System.out.println(s.max()); // 2
        System.out.println(s.pop()); // 2
        assert (s.max() == 1);
        System.out.println(s.max()); // 1
        s.push(3);
        s.push(2);
        assert (s.max() == 3);
        System.out.println(s.max()); // 3
        s.pop();
        assert (s.max() == 3);
        System.out.println(s.max()); // 3
        s.pop();
        assert (s.max() == 1);
        System.out.println(s.max()); // 1
        s.pop();
        try {
            s.max();
            s.pop();
            s.pop();
            s.pop();
            s.pop();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
