class Solution {
    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int[] up = new int[length];
        int[] down = new int[length];

        up[0] = 1;
        down[0] = 1;

        for (int i = 1; i < length; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }

        return Math.max(up[length - 1], down[length - 1]);
    }
}