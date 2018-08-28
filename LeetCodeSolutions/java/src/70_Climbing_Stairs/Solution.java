import java.util.Arrays;

class Solution {
    public int climbStairs(int n) {
        int[] stairs = new int[n + 1];
        Arrays.fill(stairs, -1);
        stairs[0] = 1;
        stairs[1] = 1;
        for (int i = 2; i <= n; i++) {
            stairs[i] = stairs[i - 1] + stairs[i - 2];
        }
        return stairs[n];       
    }
}