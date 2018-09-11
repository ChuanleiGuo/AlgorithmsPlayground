import java.util.Arrays;

class Solution {

    // top to bottom
    // private int[][] memo;
    // public int rob(int[] nums) {
    //     memo = new int[nums.length][nums.length];
    //     for (int[] m : memo) {
    //         Arrays.fill(m, -1);
    //     }
    //     if (nums.length == 0) {
    //         return 0;
    //     }
    //     if (nums.length == 1) {
    //         return nums[0];
    //     }
    //     return Math.max(tryRob(nums, 0, nums.length - 2), 
    //         tryRob(nums, 1, nums.length - 1));
    // }

    // private int tryRob(int[] nums, int start, int end) {
    //     if (start > end) {
    //         return 0;
    //     }
    //     if (memo[start][end] != -1) {
    //         return memo[start][end];
    //     }
    //     int res = 0;
    //     for (int i = start; i <= end; i++) {
    //         res = Math.max(res, nums[i] + tryRob(nums, i + 2, end));
    //     }
    //     memo[start][end] = res;
    //     return res;
    // }

    public int rob(int[] nums) {
        // int n = nums.length;
        // if (n == 0) { return 0; }
        // int[] memo = new int[n];
        // memo[n - 1] = nums[n - 1];
        // for (int i = n - 2; i >= 0; i--) {
        //     for (int j = i; j < n; j++) {
        //         memo[i] = Math.max(memo[i], nums[j] + (j + 2 < n ? memo[j + 2] : 0));
        //     }
        // }
        // return memo[0];
        
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[][] memo = new int[n][n];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        memo[n - 2][n - 2] = nums[n - 2];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j <= n - 2; j++) {
                memo[i][n-2] = Math.max(memo[i][n - 2], nums[j] + (j + 2 <= n - 2 ? memo[j + 2][n - 2] : 0));
            }
        }

        memo[n - 1][n - 1] = nums[n - 1];
        for (int i = n - 1; i >= 1; i --) {
            for (int j = i; j <= n - 1; j++) {
                memo[i][n-1] = Math.max(memo[i][n - 1], nums[j] + (j + 2 <= n - 1 ? memo[j + 2][n - 1] : 0));
            }
        }

        return Math.max(memo[0][n - 2], memo[1][n - 1]);
        
    }
}