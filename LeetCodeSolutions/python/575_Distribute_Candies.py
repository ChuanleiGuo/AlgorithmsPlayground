class Solution(object):
    def distributeCandies(self, candies):
        """
        :type candies: List[int]
        :rtype: int
        """
        s = set(candies)
        return len(s) if len(s) < len(candies) / 2 else len(candies) / 2