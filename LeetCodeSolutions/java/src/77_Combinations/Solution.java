import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0 || k <= 0 || k > n) {
            return result;
        }
        generateCombinations(n, k, 1, new ArrayList<Integer>(), result);
        return result;
    }

    private void generateCombinations(int n, int k, int start, List<Integer> p, List<List<Integer>> result) {
        if (p.size() == k) {
            result.add(new ArrayList<Integer>(p));
            return;
        }

        for (int i = start; i <= n - (k - p.size()) + 1; i++) {
            p.add(i);
            generateCombinations(n, k, i + 1, p, result);
            p.remove(p.size() - 1);
        }
        return;
    }
}