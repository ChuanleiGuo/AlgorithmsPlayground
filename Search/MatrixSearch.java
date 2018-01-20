import java.util.List;

public class MatrixSearch {
    public static boolean matrixSearch(List<List<Integer>> matrix, int x) {
        int row = 0, col = matrix.get(0).size() - 1;
        while (row < matrix.size() && col >= 0) {
            if (matrix.get(row).get(col) == x) {
                return true;
            } else if (matrix.get(row).get(col) < x) {
                row += 1;
            } else if (matrix.get(row).get(col) > x) {
                col -= 1;
            }
        }
        return false;
    }
}
