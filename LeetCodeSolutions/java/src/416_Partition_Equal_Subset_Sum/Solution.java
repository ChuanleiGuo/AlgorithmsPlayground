import java.util.Arrays;

public class Solution {

    // top to bottom
    // private int[][] memo;

    // public boolean canPartition(int[] nums) {
    //     int sum = 0;
    //     for (int num : nums) {
    //         sum += num;
    //     }
    //     if (sum % 2 != 0) { return false; }

    //     memo = new int[nums.length][sum / 2 + 1];
    //     for (int[] m : memo) {
    //         Arrays.fill(m, -1);
    //     }
    //     return tryPartition(nums, nums.length - 1, sum / 2);
    // }

    // private boolean tryPartition(int[] nums, int index, int target) {
    //     if (target == 0) {
    //         return true;
    //     }

    //     if (target < 0 || index < 0) {
    //         return false;
    //     }

    //     if (memo[index][target] != -1) {
    //         return memo[index][target] == 1;
    //     }

    //     memo[index][target] = (tryPartition(nums, index - 1, target) || 
    //             tryPartition(nums, index - 1, target - nums[index])) == true ? 1 : 0;

    //     return memo[index][target] == 1;
    // }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) { return false; }

        
    }
}