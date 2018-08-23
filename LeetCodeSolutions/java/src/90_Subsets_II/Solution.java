import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backTrack(int[] nums, int start, List<Integer> tempList, List<List<Integer>> result) {
        result.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) { continue; }
            tempList.add(nums[i]);
            backTrack(nums, i + 1, tempList, result);
            tempList.remove(tempList.size() - 1);
        }
    }
}