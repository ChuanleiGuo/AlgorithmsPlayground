import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestContainedRange {
    public static int longestContainedRanged(List<Integer> l) {
        Set<Integer> unprocessedEntries = new HashSet<>(l);

        int maxInterval = 0;
        while (!unprocessedEntries.isEmpty()) {
            int a = unprocessedEntries.iterator().next();
            unprocessedEntries.remove(a);

            int lowerBound = a - 1;
            while (unprocessedEntries.contains(lowerBound)) {
                unprocessedEntries.remove(lowerBound);
                lowerBound --;
            }

            int upperBound = a + 1;
            while (unprocessedEntries.contains(upperBound)) {
                unprocessedEntries.remove(upperBound);
                upperBound ++;
            }
            maxInterval = Math.max(maxInterval, upperBound - lowerBound - 1);
        }
        return maxInterval;
    }
}
