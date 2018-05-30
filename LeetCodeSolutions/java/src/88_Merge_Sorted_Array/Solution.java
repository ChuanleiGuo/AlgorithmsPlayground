class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end = nums1.length - 1;
        int t1 = m - 1, t2 = n-1;
        while (end >= 0) {
            if (t1 < 0) {
                nums1[end--] = nums2[t2--];
            } else if (t2 < 0) {
                nums1[end--] = nums1[t1--];
            } else {
                if (nums1[t1] > nums2[t2]) {
                    nums1[end--] = nums1[t1--];
                } else {
                    nums1[end--] = nums2[t2--];
                }
            }
        }
    }
}
