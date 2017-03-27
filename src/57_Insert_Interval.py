class Interval(object):
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

    def __repr__(self):
        return "[%d, %d]" % (self.start, self.end)


class Solution(object):
    def insert(self, intervals, newInterval):
        """
        :type intervals: List[Interval]
        :type newInterval: Interval
        :rtype: List[Interval]
        """
        intervals.append(newInterval)

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

inters = [[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]]


def make_intervals(intervals):
    result = []
    for l in intervals:
        inter = Interval(l[0], l[1])
        result.append(inter)
    return result

intervals = make_intervals(inters)
print Solution().insert(intervals, Interval(4, 9))
