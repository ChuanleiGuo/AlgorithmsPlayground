class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if len(prices) == 0:
            return 0
        low = prices[0]
        ans = 0
        for price in prices[1:]:
            if price < low:
                low = price
            else:
                ans = max(ans, price - low)
        return ans