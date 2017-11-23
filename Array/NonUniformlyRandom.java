import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class NonUniformlyRandom {
    public static int nonUniformlyRandom(List<Integer> values, List<Double> probilities) {
        List<Double> probilityies = new ArrayList<>();
        probilities.add(0.0);

        for (int i = 1; i < probilityies.size(); i++) {
            probilities.add(probilities.get(i) + probilities.get(i - 1));
        }

        Random random = new Random();
        double randomDouble = random.nextDouble();
        int idx = Collections.binarySearch(probilities, randomDouble);

        if (idx < 0) {
            return values.get(Math.abs(idx - 1) - 1);
        } else {
            return values.get(idx);
        }
    }
}
