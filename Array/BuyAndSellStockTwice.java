import java.util.ArrayList;
import java.util.List;

public class BuyAndSellStockTwice {
    public static double buyAndSellStockTwice(List<Double> prices) {
        double maxTotalProfit = 0.0;
        List<Double> firstBuySellProfits = new ArrayList<Double>();
        double minPriceSoFar = Double.MAX_VALUE;
        for (double price: prices) {
            minPriceSoFar = Math.min(minPriceSoFar, price);
            maxTotalProfit = Math.max(maxTotalProfit, price - minPriceSoFar);
            firstBuySellProfits.add(maxTotalProfit);
        }

        double maxPriceSoFar = Double.MIN_VALUE;
        for (int i = prices.size() - 1; i > 0; i--) {
            maxPriceSoFar = Math.max(maxPriceSoFar, prices.get(i));
            maxTotalProfit = Math.max(maxTotalProfit,
                maxTotalProfit - prices.get(i) + firstBuySellProfits.get(i - 1));
        }
        return maxTotalProfit;
    }
}
