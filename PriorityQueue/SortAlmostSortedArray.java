import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class SortAlmostSortedArray {
    public static void sortApproximatelySortedData(Iterator<Integer> sequence, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int i = 0; i < k && sequence.hasNext(); i ++) {
            minHeap.add(sequence.next());
        }
        while (sequence.hasNext()) {
            minHeap.add(sequence.next());
            Integer smallest = minHeap.remove();
            System.out.println(smallest);
        }
        while (!minHeap.isEmpty()) {
            Integer smallest = minHeap.remove();
            System.out.println(smallest);
        }
    }
}
