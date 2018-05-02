import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestNondecreasingSubsequence {

    public static int longestNondecreasingSubsequenceLength(List<Integer> A) {
        Integer[] maxLength = new Integer[A.size()];
        Arrays.fill(maxLength, 1);
        for (int i = 1; i < A.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (A.get(i) >= A.get(j)) {
                    maxLength[i] = Math.max(maxLength[i], maxLength[j] + 1);
                }
            }
        }
        return Collections.max(Arrays.asList(maxLength));
    }
}
