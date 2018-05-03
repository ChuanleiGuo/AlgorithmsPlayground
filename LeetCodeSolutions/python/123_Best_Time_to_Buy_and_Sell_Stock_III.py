class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        n = len(prices)
        if n < 2:
            return 0
        pre_profit = [0] * n
        post_profit = [0] * n

        cur_min = prices[0]
        for i in range(1, n):
            cur_min = min(cur_min, prices[i])
            pre_profit[i] = max(pre_profit[i - 1], prices[i] - cur_min)

        cur_max = prices[n - 1]
        for i in range(n - 2, -1, -1):
            cur_max = max(cur_max, prices[i])
            post_profit[i] = max(post_profit[i + 1], cur_max - prices[i])

        max_profit = 0
        for i in range(n):
            max_profit = max(max_profit, pre_profit[i] + post_profit[i])
        return max_profit
