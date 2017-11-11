import java.util.List;

public class BuyAndSellStock {
    public static double butAndSellStock(List<Integer> prices) {
        double minPrice = Double.MAX_VALUE, maxProfit = 0;
        for (double price: prices) {
            maxProfit = Math.max(maxProfit, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return maxProfit;
    }
}
