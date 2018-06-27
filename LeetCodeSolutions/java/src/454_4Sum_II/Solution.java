import java.util.HashMap;
import java.util.Map;

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        for (int numC : C) {
            for (int numD : D) {
                sumMap.put(numC + numD, sumMap.getOrDefault(numC + numD, 0) + 1);
            }
        }

        int res = 0;
        for (int numA : A) {
            for (int numB : B) {
                if (sumMap.containsKey(0 - numA - numB)) {
                    res += sumMap.get(0 - numA - numB);
                }
            }
        }

        return res;
    }
}
