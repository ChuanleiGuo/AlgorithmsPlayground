import java.util.Random;


public class UniformRandomNumberGeneration {
    static int zeroOneRandom() {
        Random gen = new Random();
        return gen.nextInt(2);
    }

    public static int uniformRandom(int lowerBound, int upperBound) {
        int numOfOutcomes = upperBound - lowerBound + 1, result;
        do {
            result = 0;
            for (i = 0; (1 << i) < numOfOutcomes; i++) {
                result = (result << 1) | zeroOneRandom();
            }
        } while (result >= numOfOutcomes);
        return result + lowerBound;
    }
}
