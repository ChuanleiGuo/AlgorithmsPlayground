public class NumberOfWays {
    public static int numberOfWays(int m, int n) {
        return numberOfWaysCounter(m - 1, n - 1, new int[m][n]);
    }

    private static numberOfWaysCounter(int row, int col, int[][] record) {
        if (row == 0 || col == 0) {
            return 1;
        }
        if (record[row][col] == 0) {
            int waysUp = row == 0 ? 0 : numberOfWaysCounter(row - 1, col, record);
            int waysLeft = col == 0 ? 0 : numberOfWaysCounter(row, col - 1, record);
            record[row][col] = waysUp + waysLeft;
        }
        return record[row][col];
    }
}
