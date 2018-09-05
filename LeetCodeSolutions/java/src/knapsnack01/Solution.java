import java.util.Arrays;

import java.util.List;

public class Solution {

    int[][] memo;

    public int knapsnack01(int[] weights, int[] values, int c) {
        int n = weights.length;
        memo = new int[n][c + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return bestValue(weights, values, n - 1, c);
    }

    private int bestValue(int[] weights, int[] values, int index, int c) {
        if (index < 0 || c <= 0) {
            return 0;
        }

        if (memo[index][c] != -1) {
            return memo[index][c];
        }
        int res = bestValue(weights, values, index - 1, c);
        if (c >= weights[index]) {
            res = Math.max(res, values[index] + bestValue(weights, values, index - 1, c - w[index]));
        }
        memo[index][c] = res;
        return res;
    }
}
