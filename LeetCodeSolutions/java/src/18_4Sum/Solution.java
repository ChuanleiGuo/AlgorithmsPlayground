import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);

        int maxValue = nums[nums.length - 1];
        if (nums[0] * 4 > target || maxValue * 4 < target) {
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            if (i > 0 && v == nums[i - 1]) {
                continue;
            }
            if (v + 3 * maxValue < target) {
                continue;
            }
            if (v * 4 > target) {
                break;
            }
            if (v * 4 == target) {
                if (i + 3 < nums.length && nums[i + 3] == v) {
                    res.add(Arrays.asList(v, v, v, v));
                }
                break;
            }

            threeSumForFourSum(nums, target - v, i + 1, nums.length - 1, res, v);
        }

        return res;
    }

    private void threeSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList, int v) {

        if (low + 1 >= high) {
            return;
        }

        int maxValue = nums[high];
        if (3 * nums[low] > target || 3 * maxValue < target) {
            return;
        }

        for (int i = low; i < high - 1; i++) {
            int v1 = nums[i];
            if (i > low && v1 == nums[i - 1]) {
                continue;
            }
            if (v1 + 2 * maxValue < target) {
                continue;
            }
            if (3 * v1 > target) {
                break;
            }
            if (3 * v1 == target) {
                if (i + 1 < high && nums[i + 2] == v1) {
                    fourSumList.add(Arrays.asList(v, v1, v1, v1));
                }
                break;
            }

            twoSumForThreeSum(nums, target - v1, i + 1, high, fourSumList, v, v1);
        }
    }

    private void twoSumForThreeSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList, int v, int v1) {
        if (low >= high) {
            return;
        }

        if (nums[low] * 2 > target || nums[high] * 2 < target) {
            return;
        }

        int i = low, j = high;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                fourSumList.add(Arrays.asList(v, v1, nums[i], nums[j]));

                int tmp = nums[i];
                while (++i < j && tmp == nums[i]) { ; }
                tmp = nums[j];
                while (i < --j && tmp == nums[j]) { ; }
            }
            if (sum < target) { i++; }
            if (sum > target) { j--; }
        }
        return;
    }
}
