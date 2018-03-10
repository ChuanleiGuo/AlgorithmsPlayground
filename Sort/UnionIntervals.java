import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class UnionIntervals {
    public static class Interval implements Comparable<Interval> {

        private static class Endpoint {
            public boolean isClosed;
            public int val;
        }

        public Endpoint left = new Endpoint();
        public Endpoint right = new Endpoint();

        @Override
        public int compareTo(Interval i) {
            if (Integer.compare(left.val, i.left.val) != 0) {
                return left.val - i.left.val;
            }
            if (left.isClosed && !i.left.isClosed) {
                return -1;
            }
            if (!left.isClosed && i.left.isClosed) {
                return 1;
            }
            return 0;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof Interval)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            Interval that = (Interval)obj;
            return left.val == that.left.val && left.isClosed == that.left.isClosed;
        }

        @Override
        public int hashCode() {
            return Objects.hash(left.val, left.isClosed);
        }
    }

    public static List<Interval> unionOfIntervals(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        Collections.sort(intervals);
        Interval curr = intervals.get(0);
        List<Interval> result = new ArrayList<>();

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).left.val < curr.right.val
                || (intervals.get(i).left.val == curr.right.val
                    && (intervals.get(i).left.isClosed || curr.right.isClosed))) {

                if (intervals.get(i).right.val > curr.right.val
                    || (intervals.get(i).right.val == curr.right.val
                        && intervals.get(i).right.isClosed)) {

                    curr.right = intervals.get(i).right;
                }
            } else {
                result.add(curr);
                curr = intervals.get(i);
            }
        }
        result.add(curr);
        return result;
    }
}
