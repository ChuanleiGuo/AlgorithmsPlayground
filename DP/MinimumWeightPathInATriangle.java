import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumWeightPathInATriangle {

    public static int minimumPathTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) {
            return 0;
        }
        List<Integer> prevRow = new ArrayList<>(triangle.get(0));
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> currRow = new ArrayList<>(triangle.get(i));

            currRow.set(0, currRow.get(0) + prevRow.get(0));
            for (int j = 1; j < currRow.size() - 1; j++) {
                currRow.set(j, currRow.get(j) + Math.min(prevRow.get(j - 1), prevRow.get(j)));
            }
            currRow.set(currRow.size() - 1, currRow.get(currRow.size() - 1) + prevRow.get(prevRow.size() - 1));
            prevRow = currRow;
        }
        return Collections.min(prevRow);
    }
}
