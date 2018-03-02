import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubarrayWithDistinctEntries {
    public static int longestSubarrayWithDistinctEntries(List<String> l) {
        Map<String, Integer> mostRecentOccurrence = new HashMap<String, Integer>();
        int longestStartIdx = 0, result = 0;
        for (int i = 0; i < l.size(); i++) {
            Integer dupIdx = mostRecentOccurrence.put(l.get(i), i);
            if (dupIdx != null) {
                if (dupIdx >= longestStartIdx) {
                    result = Math.max(result, i - longestStartIdx);
                    longestStartIdx = dupIdx + 1;
                }
            }
        }
        result = Math.max(result, l.size() - longestStartIdx);
        return result;
    }
}
