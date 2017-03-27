class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        dp = [0] + [2 ** 31 - 1] * amount
        for i in xrange(1, amount + 1):
            for coin in coins:
                if i >= coin and dp[i - coin] != (2 ** 31 - 1):
                    dp[i] = min(dp[i], dp[i - coin] + 1)

        return dp[amount] if dp[amount] != (2 ** 31 - 1) else -1
