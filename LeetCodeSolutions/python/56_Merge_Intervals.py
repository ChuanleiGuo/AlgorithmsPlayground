class Interval(object):
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

    def __repr__(self):
        return "[%d, %d]" % (self.start, self.end)

class Solution(object):

    def merge(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[Interval]
        """
        result = []
        if len(intervals) < 1:
            return []

        sorted_intervals = sorted(intervals, key=lambda inter: inter.start)
        left = sorted_intervals[0].start
        right = sorted_intervals[0].end
        for interval in sorted_intervals:
            if interval.start <= right:
                right = max(right, interval.end)
            else:
                result.append(Interval(left, right))
                left = interval.start
                right = interval.end
        result.append(Interval(left, right))
        return result
