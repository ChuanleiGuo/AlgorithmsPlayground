import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> disMap = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j == i) { continue; }

                int dis = squareDis(points[i], points[j]);
                disMap.put(dis, disMap.getOrDefault(dis, 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : disMap.entrySet()) {
                int value = entry.getValue();
                res += value * (value - 1);
            }
        }
        return res;
    }

    private int squareDis(int[] point1, int[] point2) {
        return (point1[0] - point2[0]) * (point1[0] - point2[0]) + 
        (point1[1] - point2[1]) * (point1[1] - point2[1]);
    }
}
