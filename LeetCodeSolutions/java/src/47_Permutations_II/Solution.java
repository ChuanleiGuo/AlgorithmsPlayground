import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);

        generatePerms(nums, 0, new ArrayList<Integer>(), used, res);

        return res;
    }

    private void generatePerms(int[] nums, int idx, List<Integer> p, boolean[] used, List<List<Integer>> res) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(p));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) { continue; }
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) { continue; }
            p.add(nums[i]);
            used[i] = true;
            generatePerms(nums, idx + 1, p, used, res);
            p.remove(p.size() - 1);
            used[i] = false;
        }
        return;
    }
}