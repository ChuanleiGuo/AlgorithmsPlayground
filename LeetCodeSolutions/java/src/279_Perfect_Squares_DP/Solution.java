import java.util.Arrays;

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);

        if (n <= 0) { 
            return 0;
        }
        for (int i = 1; i <= n; i++) {
            int cnt = Integer.MAX_VALUE;
            for (int v = 1; v * v <= i; v++) {
                cnt = Math.min(cnt, dp[i - v * v] + 1);
            }
            dp[i] = cnt;
        }
        return dp[n];
    }
}