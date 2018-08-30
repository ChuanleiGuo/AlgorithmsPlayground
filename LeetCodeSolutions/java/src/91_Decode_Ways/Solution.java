class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int first = Integer.parseInt(s.substring(i - 1, i));
            int second = Integer.parseInt(s.substring(i - 2, i));
            if (1 <= first && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if (10 <= second && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}