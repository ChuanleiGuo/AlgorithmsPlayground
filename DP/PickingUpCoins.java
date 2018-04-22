import java.util.List;

public class PickingUpCoins {

    public static int pickUpCoins(List<Integer> coins) {
        return computeMaximumRevenueForRange(coins, 0, coins.size() - 1, new int[coins.size()][coins.size()]);
    }

    private static int computeMaximumRevenueForRange(List<Integer> coins, int a, int b, int[][] maxRevenue) {
        if (a > b) {
            return 0;
        }

        if (maxRevenue[a][b] == 0) {
            int maxRevenueA = coins.get(a) + Math.min(computeMaximumRevenueForRange(coins, a + 2, b, maxRevenue),
                    computeMaximumRevenueForRange(coins, a + 1, b - 1, maxRevenue));
            int maxRevenueB = coins.get(b) + Math.min(computeMaximumRevenueForRange(coins, a + 1, b - 1, maxRevenue),
                    computeMaximumRevenueForRange(coins, a, b - 2, maxRevenue));
            maxRevenue[a][b] = Math.max(maxRevenueA, maxRevenueB);
        }

        return maxRevenue[a][b];
    }

}
