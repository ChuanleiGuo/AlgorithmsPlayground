class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = -1;
        int sum = 0;
        int minLen = nums.length + 1;
        while (left < nums.length) {
            if (right + 1 < nums.length && sum < s) {
                sum += nums[++right];
            } else {
                sum -= nums[left++];
            }
            if (sum >= s) {
                minLen = Math.min(minLen, right - left + 1);
            }
        }

        return minLen == nums.length + 1 ? 0 : minLen;
    }
}
