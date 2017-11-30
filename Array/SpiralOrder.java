import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public static List<Integer> matrixSpiralOrder(List<List<Integer>> matrix) {
        final int[][] SHIFT = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0, x = 0, y = 0;
        List<Integer> spiralOrding = new ArrayList<>();

        for (int i = 0; i < matrix.size() * matrix.size(); i++) {
            spiralOrding.add(matrix.get(x).get(y));
            matrix.get(x).set(y, 0);
            int nextX = x + SHIFT[dir][0], nextY = y + SHIFT[dir][1];
            if (nextX < 0 || nextX >= matrix.size() ||
                nextY < 0 || nextY >= matrix.size() ||
                matrix.get(x).get(y) == 0) {

                dir = (dir + 1) % 4;
                nextX = x + SHIFT[dir][0];
                nextY = y + SHIFT[dir][1];
            }
            x = nextX;
            y = nextY;
        }

        return spiralOrding;
    }
}
