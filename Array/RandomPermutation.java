import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomPermutation {
    private static List<Integer> sampleOffline(List<Integer> numbers, int k) {
        Random random = new Random();
        for (int i = 0; i < k; i ++) {
            Collections.swap(numbers, i, i + random.nextInt(numbers.size() - i));
        }
        return numbers;
    }

    public static List<Integer> randomPermutation(int n) {
        List<Integer> result = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            result.add(i);
        }
        result = sampleOffline(result, n);
        return result;
    }
}
