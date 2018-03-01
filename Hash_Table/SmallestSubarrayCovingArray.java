import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SmallestSubarrayCovingArray {
    private static class Subarray {
        public Integer start;
        public Integer end;

        public SubAaray(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }
    }

    public static Subarray findSmallestSubarrayCoveringSet(List<String> paragraph, Set<String> keywords) {
        Map<String, Integer> keywordsToCover = new HashMap<String, Integer>();
        for (String word : keywords) {
            if (keywordsToCover.contains(word)) {
                keywordsToCover.put(word, keywordsToCover.get(word) + 1);
            } else {
                keywordsToCover.put(word, 1);
            }
        }
        Subarray result = new Subarray(-1, -1);
        int remainingToCover = keywords.size();
        for (int left, right = 0; right < paragraph.size(); right++) {
            Integer keywordCount = keywordsToCover.get(paragraph.get(right));
            if (keywordCount != null) {
                keywordsToCover.put(paragraph.get(right), --keywordCount);
                if (keywordCount >= 0) {
                    --remainingToCover;
                }
            }

            while (remainingToCover == 0) {
                if ((result.start == -1 && result.end == -1)
                    || right - left < result.end - result.start) {

                    result.start = left;
                    result.end = right;
                }
                keywordCount = keywordsToCover.get(paragraph.get(left));
                if (keywordCount != null) {
                    keywordsToCover.put(paragraph.get(left), ++keywordCount);
                    if (keywordCount > 0) {
                        remainingToCover++;
                    }
                }
                ++left;
            }
        }
        return result;
    }
}
