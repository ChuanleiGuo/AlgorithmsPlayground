import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, target, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void backTrack(int[] candidates, int remain, int start, List<Integer> tempList, List<List<Integer>> result) {
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            result.add(new ArrayList<Integer>(tempList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                tempList.add(candidates[i]);
                backTrack(candidates, remain - candidates[i], i + 1, tempList, result);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}