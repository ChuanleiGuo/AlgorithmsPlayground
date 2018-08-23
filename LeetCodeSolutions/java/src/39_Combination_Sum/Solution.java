import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, target, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void backTrack(int[] candidates, int target, int start, List<Integer> tempList, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<Integer>(tempList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                tempList.add(candidates[i]);
                backTrack(candidates, target - candidates[i], i, tempList, result);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}