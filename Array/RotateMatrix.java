import java.util.List;

public class RotateMatrix {
    public static void rotateMatrix(List<List<Integer>> matrix) {
        final int matrixSize = matrix.size() - 1;
        for (int i = 0; i < (matrix.size() / 2); i++) {
            for (int j = i; j < matrixSize - i; j++) {
                int temp1 = matrix.get(matrixSize - j).get(i);
                int temp2 = matrix.get(matrixSize - i).get(matrixSize - j);
                int temp3 = matrix.get(j).get(matrixSize - i);
                int temp4 = matrix.get(i).get(j);
                matrix.get(i).set(j, temp1);
                matrix.get(matrixSize - j).set(i, temp2);
                matrix.get(matrixSize - i).set(matrixSize - j, temp3);
                matrix.get(j).set(matrixSize - i, temp4);
            }
        }
    }
}
