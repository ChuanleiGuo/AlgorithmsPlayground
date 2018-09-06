class Solution {

    // top to bottom

    // private int[] memo;
    // public int rob(int[] nums) {
    //     memo = new int[nums.length];
    //     Arrays.fill(memo, -1);
    //     return tryRob(nums, 0);
    // }

    // private int tryRob(int[] nums, int index) {
    //     if (index >= nums.length) { return 0; }

    //     if (memo[index] != -1) { return memo[index]; } 
    //     int res = 0;
    //     for (int i = index; i < nums.length; i++) {
    //         res = Math.max(res, nums[i] + tryRob(nums, i + 2));
    //     }
    //     memo[index] = res;
    //     return res;
    // }

    // bottom to top

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) { return 0; }
        int[] memo = new int[n];
        memo[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                memo[i] = Math.max(memo[i], nums[j] + (j + 2 < n ? memo[j + 2] : 0));
            }
        }
        return memo[0];
    }
}