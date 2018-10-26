class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0;

        int maxLength = 0;
        while (start < nums.length) {
            
            if (nums[start] != 1) {
                start ++;
                continue;
            }

            int end = start;
            while (end < nums.length && nums[end] == 1) {
                end++;
            }

            if (end - start > maxLength) {
                maxLength = (end - start);
            }

            start = end + 1;

        }

        return maxLength;
    }
}