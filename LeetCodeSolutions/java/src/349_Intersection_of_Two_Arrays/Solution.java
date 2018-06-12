import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> s = new HashSet<Integer>();
        for(int n : nums1) {
            s.add(n);
        } 
        int i = 0;
        for(int n : nums2) {
            if(s.remove(n)) {
                nums2[i++] = n;
            }
        }
        return Arrays.copyOfRange(nums2, 0, i);
    }
}
