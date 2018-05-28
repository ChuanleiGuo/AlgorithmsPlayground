class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) { return 0; }
        int limit = 2;

        int pivot = 0;
        for (int i = 0; i < nums.length; i++) {
            if (pivot < limit || nums[i] > nums[pivot - limit]) {
                nums[pivot++] = nums[i];
            }
        }

        return pivot;
    }
}