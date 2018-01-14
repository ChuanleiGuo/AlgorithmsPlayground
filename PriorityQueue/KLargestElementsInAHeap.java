import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Arrays;

public class KLargestElementsInAHeap {
    private static class HeapEntry {
        public Integer index;
        public Integer value;

        public HeapEntry(Integer index, Integer value) {
            this.index = index;
            this.value = value;
        }
    }

    private static class Compare implements Comparator<HeapEntry> {
        @Override
        public int compare(HeapEntry o1, HeapEntry o2) {
            return Integer.compare(o2.value, o1.value);
        }

        public static final Compare COMPARE_HEAP_ENTRIES = new Compare();
    }

    private static final int DEFAULT_CAPACITY = 16;

    public static List<Integer> kLargestInBinaryHeap(List<Integer> heap, int k) {
        if (k <= 0) {
            return Collections.EMPTY_LIST;
        }

        PriorityQueue<HeapEntry> candidateMaxHeap = new PriorityQueue<>(DEFAULT_CAPACITY, Compare.COMPARE_HEAP_ENTRIES);
        candidateMaxHeap.add(new HeapEntry(0, heap.get(0)));
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            Integer canIdx = candidateMaxHeap.peek().index;
            result.add(candidateMaxHeap.remove().value);

            Integer leftIdx = canIdx * 2 + 1;
            if (leftIdx < heap.size()) {
                candidateMaxHeap.add(new HeapEntry(leftIdx, heap.get(leftIdx)));
            }

            Integer rightIdx = canIdx * 2 + 2;
            if (rightIdx < heap.size()) {
                candidateMaxHeap.add(new HeapEntry(rightIdx, heap.get(rightIdx)));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> maxHeap = Arrays.asList(10, 2, 9, 2, 2, 8, 8, 2, 2, 2, 2, 7, 7, 7, 7);
        List<Integer> result = kLargestInBinaryHeap(maxHeap, 3);
        List<Integer> expectedResult = Arrays.asList(10, 9, 8);
        assert (result.equals(expectedResult));
        result = kLargestInBinaryHeap(maxHeap, 5);
        expectedResult = Arrays.asList(10, 9, 8, 8, 7);
        assert (result.equals(expectedResult));

        maxHeap = Arrays.asList(97, 84, 93, 83, 81, 90, 79, 83, 55, 42, 21, 73);
        result = kLargestInBinaryHeap(maxHeap, 3);
        expectedResult = Arrays.asList(97, 93, 90);
        assert (result.equals(expectedResult));

        maxHeap = Arrays.asList(100, 1, 5, 0, 0);
        result = kLargestInBinaryHeap(maxHeap, 1);
        expectedResult = Arrays.asList(100);
        assert (result.equals(expectedResult));
        result = kLargestInBinaryHeap(maxHeap, 2);
        assert (result.equals(Arrays.asList(100, 5)));
        result = kLargestInBinaryHeap(maxHeap, 3);
        assert (result.equals(Arrays.asList(100, 5, 1)));
    }
}
