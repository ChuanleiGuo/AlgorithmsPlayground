import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static List<List<Integer>> generatePascalTriangle(int n) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> curRow = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j > 0 && j < i) {
                    curRow.add(pascalTriangle.get(i - 1).get(j - 1) +
                        pascalTriangle.get(i - 1).get(j));
                } else {
                    curRow.add(1);
                }
            }
            pascalTriangle.add(curRow);
        }
        return pascalTriangle;
    }
}
