import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(k, n, 1, new ArrayList<>(), result);
        return result;
    }

    private void backTrack(int k, int remain, int start, List<Integer> tempList, List<List<Integer>> result) {
        if (tempList.size() > k) {
            return;
        }
        if (tempList.size() == k && remain == 0) {
            result.add(new ArrayList<Integer>(tempList));
            return;
        } else {
            for (int i = start; i <= 9; i++) {
                tempList.add(i);
                backTrack(k, remain - i, i + 1, tempList, result);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}