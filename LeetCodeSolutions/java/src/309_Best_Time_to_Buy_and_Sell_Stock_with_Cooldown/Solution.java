class Solution {
    public int maxProfit(int[] prices) {
        int sell = 0, pre_sell = 0, buy = Integer.MIN_VALUE, pre_buy = 0;
        for (int price : prices) {
            pre_buy = buy;
            buy = Math.max(pre_sell - price, pre_buy);
            pre_sell = sell;
            sell = Math.max(pre_buy + price, pre_sell);
        }
        return sell;
    }
}