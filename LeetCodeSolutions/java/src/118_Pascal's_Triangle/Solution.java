import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i ++) {
            List<Integer> level = new ArrayList<>(i + 1);
            if (i == 0) {
                level.add(1);
                result.add(level);
            } else {
                for (int j = 0; j < i + 1; j++) {
                    if (j == 0 || j == i) {
                        level.add(1);
                    } else {
                        int value = result.get(i - 1).get(j - 1) 
                            + result.get(i - 1).get(j);
                        level.add(value);
                    }
                }
                result.add(level);
            }
        }
        return result;
    }
}