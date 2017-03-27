from heapq import *


class MedianFinder:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.queues = [], []

    def addNum(self, num):
        """
        Adds a num into the data structure.
        :type num: int
        :rtype: void
        """
        small, large = self.queues
        heappush(large, num)
        heappush(small, - heappop(large))
        if len(large) < len(small):
            heappush(large, - heappop(small))


    def findMedian(self):
        """
        Returns the median of current data stream
        :rtype: float
        """
        small, large = self.queues
        if len(large) > len(small):
            return float(large[0])
        else:
            return (large[0] - small[0]) / 2.0
