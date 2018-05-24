class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                if (i != k) {
                    int temp = nums[k];
                    nums[k] = nums[i];
                    nums[i] = temp;
                }
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        System.out.println(s.removeElement(nums, val));

        int[] nums1 = {0,1,2,2,3,0,4,2};
        val = 2;
        System.out.println(s.removeElement(nums1, val));
    }
}