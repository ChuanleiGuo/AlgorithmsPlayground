class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if len(prices) <= 1:
            return 0
        s0 = [0] * len(prices)
        s1 = [0] * len(prices)
        s2 = [0] * len(prices)
        s0[0] = 0
        s1[0] = - prices[0]
        s2[0] = - (2 ** 31 - 1)

        for i in range(1, len(prices)):
            s0[i] = max(s0[i - 1], s2[i - 1])
            s1[i] = max(s1[i - 1], s0[i - 1] - prices[i])
            s2[i] = s1[i - 1] + prices[i]

        return max(s0[-1], s2[-1])
