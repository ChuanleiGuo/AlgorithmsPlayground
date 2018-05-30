class Solution {
    public void sortColors(int[] nums) {
        int left = -1, right = nums.length;

        int i = 0;
        while (i < right) {
            if (nums[i] == 1) {
                i ++;
            } else if (nums[i] == 0) {
                swap(nums, ++left, i++);
            } else {
                swap(nums, --right, i);
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}