import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class SampleOnline {
    public static List<Integer> sampleOnline(Iterator<Integer> numbers, int k) {
        List<Integer> runningSmaple = new ArrayList<>(k);
        for (int i = 0; numbers.hasNext() && i < k; i++) {
            runningSmaple.set(i, numbers.next());
        }

        int numSeenSoFar = k;
        Random randIdx = new Random();
        while (numbers.hasNext()) {
            Integer x = numbers.next();
            numSeenSoFar++;
            final int nextIdx = randIdx.nextInt(numSeenSoFar);
            if (nextIdx < k) {
                runningSmaple.set(nextIdx, x);
            }
        }
        return runningSmaple;
    }
}
