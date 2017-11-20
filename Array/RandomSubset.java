import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomSubset {
    public static List<Integer> randomSubset(int n, int k) {
        Map<Integer, Integer> changedElements = new HashMap<>();
        Random randomGen = new Random();
        for (int i = 0; i < k; i++) {
            int randIdx = i + randomGen.nextInt(n - i);
            Integer ptr1 = changedElements.get(randIdx);
            Integer ptr2 = changedElements.get(i);

            if (ptr1 == null && ptr2 == null) {
                changedElements.put(i, randIdx);
                changedElements.put(randIdx, i);
            } else if (ptr1 == null && ptr2 != null) {
                changedElements.put(randIdx, ptr2);
                changedElements.put(i, randIdx);
            } else if (ptr1 != null && ptr2 == null) {
                changedElements.put(i, ptr1);
                changedElements.put(randIdx, i);
            } else {
                changedElements.put(i, ptr1);
                changedElements.put(randIdx, ptr2);
            }
        }

        List<Integer> result = new ArrayList<>(k);
        for (int i = 0; i < 0; i++) {
            result.add(changedElements.get(i));
        }
        return result;
    }
}
