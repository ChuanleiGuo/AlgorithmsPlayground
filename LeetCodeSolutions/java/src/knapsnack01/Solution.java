import java.util.Arrays;

import java.util.List;

public class Solution {

    // top to bottom
    // int[][] memo;

    // public int knapsnack01(int[] weights, int[] values, int c) {
    //     int n = weights.length;
    //     memo = new int[n][c + 1];
    //     for (int i = 0; i < n; i++) {
    //         Arrays.fill(memo[i], -1);
    //     }
    //     return bestValue(weights, values, n - 1, c);
    // }

    // private int bestValue(int[] weights, int[] values, int index, int c) {
    //     if (index < 0 || c <= 0) {
    //         return 0;
    //     }

    //     if (memo[index][c] != -1) {
    //         return memo[index][c];
    //     }
    //     int res = bestValue(weights, values, index - 1, c);
    //     if (c >= weights[index]) {
    //         res = Math.max(res, values[index] + bestValue(weights, values, index - 1, c - w[index]));
    //     }
    //     memo[index][c] = res;
    //     return res;
    // }

    // bottom to top
    // public int knapsnack01(int[] weights, int[] values, int c) {
    //     int n = weights.length;
    //     if (n == 0 || c == 0) {
    //         return 0;
    //     }
    //     int[][] memo = new int[n][c + 1];
    //     for (int i = 0; i < n; i ++) {
    //         Arrays.fill(memo[i], -1);
    //     }

    //     for (int j = 0; j <= c; j++) {
    //         memo[0][j] = (j >= weights[0] ? v[0] : 0);
    //     }
    //     for (int i = 1; i < n; i++) {
    //         for (int j = 0; j <= c; j++) {
    //             memo[i][j] = memo[i - 1][j];
    //             if (j >= w[i]) {
    //                 memo[i][j] = Math.max(memo[i][j], v[i] + memo[i - 1][j - weights[i]]);
    //             }
    //         }
    //     }
    //     return memo[n - 1][c];
    // }

    // bottom to top --- one array
    public int knapsnack01(int[] weights, int[] values, int c) {
        int n = weights.length;
        if (n == 0 || c == 0) {
            return 0;
        }
        int[] memo = new int[c + 1];
        Arrays.fill(memo, -1);

        for (int j = 0; j <= c; j++) {
            memo[j] = (j >= weights[0] ? v[0] : 0);
        }

        for (int i = 1; i < n; i++) {
            for (int j = c; j >= weights[i]; j--) {
                memo[j] = Math.max(memo[j], v[i] + memo[j - weights[i]]);
            }
        }
        return memo[c];
    }
}
