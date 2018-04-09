public class BinomialCoefficients {

  public static int computeBinomialCoefficient(int n, int k) {
    return chooseXY(n, k, new int[n + 1][k + 1]);
  }

  private static int chooseXY(int x, int y, int[][] record) {
    if (y == 0 || x == y) {
      return 1;
    }
    if (record[x][y] == 0) {
      int withoutY = chooseXY(x - 1, y, record);
      int withY = chooseXY(x - 1, y - 1, record);
      record[x][y] = withY + withoutY;
    }
    return record[x][y];
  }

}
