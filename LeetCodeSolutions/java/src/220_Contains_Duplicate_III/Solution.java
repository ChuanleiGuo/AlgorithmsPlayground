import java.util.Set;
import java.util.TreeSet;

import sun.reflect.generics.tree.Tree;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (treeSet.ceiling((long)nums[i] - t) != null && treeSet.ceiling((long)nums[i] - t) <= (long)nums[i] + t) {
                return true;
            }

            treeSet.add((long)nums[i]);

            if (treeSet.size() == k + 1) {
                treeSet.remove((long)nums[i - k]);
            }
        }

        return false;
    }
}
