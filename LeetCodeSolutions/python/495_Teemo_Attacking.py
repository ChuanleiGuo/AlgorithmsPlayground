class Solution(object):
    def findPoisonedDuration(self, timeSeries, duration):
        """
        :type timeSeries: List[int]
        :type duration: int
        :rtype: int
        """
        res = duration * len(timeSeries)
        for i in range(1, len(timeSeries)):
            res -= max(0, duration - (timeSeries[i] - timeSeries[i - 1]))
        return res
