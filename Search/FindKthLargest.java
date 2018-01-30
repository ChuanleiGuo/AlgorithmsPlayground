import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class FindKthLargest {
    private static class Compare {
        private static class GreaterThan implements Comparator<Integer> {
            public int compare(Integer a, Integer b) {
                return (a > b) ? -1 : (a.equals(b)) ? 0 : 1;
            }
        }
        public static final GreaterThan GREATER_THAN = new GreaterThan();
    }

    public static int findKthLargest(List<Integer> list, int k) {
        return findKth(list, k, Compare.GREATER_THAN);
    }

    public static int findKth(List<Integer> list, int k, Comparator<Integer> cmp) {
        int left = 0, right = list.size() - 1;
        Random random = new Random(0);
        while (left <= right) {
            int pivotIdx = random.nextInt(right - left + 1) + left;
            int newPivotIdx = partitionAroundPivot(left, right, pivotIdx, list, cmp);
            if (newPivotIdx == k - 1) {
                return list.get(newPivotIdx);
            } else if (newPivotIdx > k - 1) {
                right = newPivotIdx - 1;
            } else {
                left = newPivotIdx + 1;
            }
        }
        return right;
    }

    private static int partitionAroundPivot(int left, int right, int pivotIdx, List<Integer> list, Comparator<Integer> cmp) {
        int pivotValue = list.get(pivotIdx);
        int newPivotIdx = left;

        Collections.swap(list, pivotIdx, right);
        for (int i = left; i < right; i ++) {
            if (cmp.compare(list.get(i), pivotValue) < 0) {
                Collections.swap(list, i, newPivotIdx++);
            }
        }
        Collections.swap(list, right, newPivotIdx);
        return newPivotIdx;
    }
}
