import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class EnumerateABSqrt {
    public static class ABSqrt2 implements Comparable<ABSqrt2> {
        public int a, b;
        public double val;

        public ABSqrt2(int a, int b) {
            this.a = a;
            this.b = b;
            val = a + b * Math.sqrt(2);
        }

        @Override
        public int compareTo(ABSqrt2 o) {
            return Double.compare(val, o.val);
        }
    }

    public static List<ABSqrt2> generateFirstKABSqrt2(int k) {
        SortedSet<ABSqrt2> candidates = new TreeSet<>();
        candidates.add(new ABSqrt2(0, 0));

        List<ABSqrt2> result = new ArrayList<>();
        while (result.size() < k) {
            ABSqrt2 nextSmallest = candidates.first();
            result.add(nextSmallest);

            candidates.add(new ABSqrt2(nextSmallest.a + 1, nextSmallest.b));
            candidates.add(new ABSqrt2(nextSmallest.a, nextSmallest.b + 1));
            candidates.remove(nextSmallest);
        }
        return result;
    }
}
