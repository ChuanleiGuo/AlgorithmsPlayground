import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SampleOffline {
    public static List<Integer> randomSampling(int k, List<Integer> numbers) {
        Random random = new Random();
        for (int i = 0; i < k; i++) {
            Collections.swap(numbers, i, i + random.nextInt(numbers.size() - i));
        }
        return numbers;
    }
}
