class Interval(object):
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e


class SummaryRanges(object):
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.__intervals = []

    def addNum(self, val):
        """
        :type val: int
        :rtype: void
        """
        cur_interval = Interval(val, val)
        res = []
        pos = 0
        for inv in self.__intervals:
            if cur_interval.end + 1 < inv.start:
                res.append(inv)
            elif cur_interval.start > inv.end + 1:
                res.append(inv)
                pos += 1
            elif cur_interval.start - 1 == inv.end:
                cur_interval.start = inv.start
            elif cur_interval.end + 1 == inv.start:
                cur_interval.end = inv.end
            else:
                cur_interval.start = min(cur_interval.start, inv.start)
                cur_interval.end = max(cur_interval.end, inv.end)

        res.insert(pos, cur_interval)
        self.__intervals = res

    def getIntervals(self):
        """
        :rtype: List[Interval]
        """
        return self.__intervals
