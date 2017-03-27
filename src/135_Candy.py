class Solution(object):
    def candy(self, ratings):
        """
        :type ratings: List[int]
        :rtype: int
        """
        if len(ratings) == 0:
            return -1
        if len(ratings) == 1:
            return 1

        length = len(ratings)
        candies = [0] * length

        candies[0] = 1
        for i in range(1, length):
            if ratings[i] > ratings[i - 1]:
                candies[i] = candies[i - 1] + 1
            else:
                candies[i] = 1

        for i in range(length - 2, -1, -1):
            if ratings[i] > ratings[i + 1] and candies[i] <= candies[i + 1]:
                candies[i] = candies[i + 1] + 1

        return sum(candies)
