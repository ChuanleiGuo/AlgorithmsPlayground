class Interval(object):
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e


class Solution(object):
    def findRightInterval(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[int]
        """
        from bisect import bisect_left
        l = sorted([(interval.start, i) for i, interval in enumerate(intervals)])
        res = []
        for interval in intervals:
            r = bisect_left(l, (interval.end,))
            res.append(l[r][0] if r < len(l) else -1)
        return res
