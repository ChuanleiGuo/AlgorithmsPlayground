import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Combinations {
    public static List<List<Integer>> combinations(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        helper(n, k, 1, new ArrayList<Integer>(), result);
        return result;
    }

    private static void helper(int n, int k, int offset, List<Integer> particalCombination,
            List<List<Integer>> result) {
        final int numRemaining = k - particalCombination.size();
        for (int i = offset; i <= n && numRemaining < n - i + 1; i++) {
            particalCombination.add(i);
            helper(n, k, i + 1, particalCombination, result);
            particalCombination.remove(particalCombination.size() - 1);
        }
    }

    private static void smallTest() {
        List<List<Integer>> result = combinations(4, 2);
        List<List<Integer>> goldenResult = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(1, 3), Arrays.asList(1, 4),
                Arrays.asList(2, 3), Arrays.asList(2, 4), Arrays.asList(3, 4));
        assert (result.equals(goldenResult));
    }

    public static void main(String[] args) {
        smallTest();
        Random r = new Random();
        int n, k;
        if (args.length == 2) {
            n = Integer.parseInt(args[0]);
            k = Integer.parseInt(args[1]);
        } else {
            n = r.nextInt(10) + 1;
            k = r.nextInt(n + 1);
        }
        List<List<Integer>> res = combinations(n, k);
        System.out.println("n = " + n + ", k = " + k);
        System.out.println(res);
    }
}
