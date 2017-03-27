class Interval(object):
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e


class Solution(object):
    def eraseOverlapIntervals(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: int
        """
        if len(intervals) == 0:
            return 0

        intervals.sort(key=lambda x: x.end)

        end = intervals[0].end
        count = 1

        for interval in intervals[1:]:
            if interval.start >= end:
                end = interval.end
                count += 1
        return len(intervals) - count
