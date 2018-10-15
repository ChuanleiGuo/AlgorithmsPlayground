import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] idxMatrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                idxMatrix[i][j] = i + j;
            }
        }

        Map<Integer, List<Integer>> idxMap = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = idxMatrix[i][j];
                if (!idxMap.containsKey(idx)) {
                    idxMap.put(idx, new ArrayList());
                }
                idxMap.get(idx).add(matrix[i][j]);
            }
        }

        int idx = 0;
        int[] res = new int[m * n];
        for (Map.Entry<Integer, List<Integer>> entry : idxMap.entrySet()) {
            int key = entry.getKey();
            List<Integer> value = entry.getValue();

            if (key % 2 == 0) {
                Collections.reverse(value);
            }

            for (int i = 0; i < value.size(); i++) {
                res[idx++] = value.get(i);
            }
        }

        return res;
    }
}