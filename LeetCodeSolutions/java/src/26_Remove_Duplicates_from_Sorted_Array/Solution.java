class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) { return 0; } 
        int pivot = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[pivot]) {
                nums[++pivot] = nums[i];
            }
        }
        return pivot + 1;
    }
}