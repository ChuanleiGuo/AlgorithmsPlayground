import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class NumberOfScoreCombinations {
    public static int numCombinationsForFinalScore(int finalScore, List<Integer> scores) {
        int[][] numCombinations = new int[scores.size()][finalScore + 1];
        for (int i = 0; i < scores.size(); i++) {
            numCombinations[i][0] = 0;
            for (int j = 1; j <= finalScore; j++) {
                int withoutThisScore = i - 1 >= 0 ? numCombinations[i - 1][j] : 0;
                int withThisScore = j >= scores.get(i) ? numCombinations[i][j - scores.get(i)] : 0;
                numCombinations[i][j] = withThisScore + withoutThisScore;
            }
        }
        return numCombinations[scores.size() - 1][finalScore];
    }

    private static void simpleTest() {
        List<Integer> individualPlayScores = Arrays.asList(2, 3, 7);
        assert (4 == numCombinationsForFinalScore(12, individualPlayScores));
        assert (1 == numCombinationsForFinalScore(5, individualPlayScores));
        assert (3 == numCombinationsForFinalScore(9, individualPlayScores));
    }

    private static int checkAnswer(int totalScore, List<Integer> scoreWays) {
        int[] combinations = new int[totalScore + 1];
        combinations[0] = 1; // One way to reach 0.
        for (int score : scoreWays) {
            for (int j = score; j <= totalScore; ++j) {
                combinations[j] += combinations[j - score];
            }
        }
        return combinations[totalScore];
    }

    public static void main(String[] args) {
        simpleTest();
        Random r = new Random();
        int k;
        Set<Integer> individualPlayScoresSet = new HashSet<>();
        if (args.length == 0) {
            k = r.nextInt(1000);
            int size = r.nextInt(50) + 1;
            for (int i = 0; i < size; ++i) {
                individualPlayScoresSet.add(r.nextInt(1000) + 1);
            }
        } else if (args.length == 2) {
            k = Integer.parseInt(args[0]);
            int size = Integer.parseInt(args[1]);
            for (int i = 0; i < size; ++i) {
                individualPlayScoresSet.add(r.nextInt(1000) + 1);
            }
        } else {
            k = Integer.parseInt(args[0]);
            for (int i = 2; i < args.length; ++i) {
                individualPlayScoresSet.add(Integer.parseInt(args[i]));
            }
        }
        List<Integer> individualPlayScores = new ArrayList<>(individualPlayScoresSet);
        System.out.println(numCombinationsForFinalScore(k, individualPlayScores));
        assert (numCombinationsForFinalScore(k, individualPlayScores) == checkAnswer(k, individualPlayScores));
    }
}
