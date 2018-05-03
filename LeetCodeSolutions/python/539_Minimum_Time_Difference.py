class Solution(object):
    def findMinDifference(self, timePoints):
        """
        :type timePoints: List[str]
        :rtype: int
        """
        time_table = [False] * (24 * 60)
        for time in timePoints:
            components = time.split(':')
            hours, minutes = int(components[0]), int(components[1])
            t = hours * 60 + minutes
            if time_table[t]:
                return 0
            else:
                time_table[t] = True
        
        prev = 0
        min_interval = 2**31 - 1
        first, last = 2**31 - 1, -1
        for i in range(24 * 60):
            if time_table[i]:
                if first != 2 ** 31 - 1:
                    min_interval = min(min_interval, i - prev)
                first = min(first, i)
                last = max(last, i)
                prev = i

        min_interval = min(min_interval, (24 * 60 - last + first))

        return min_interval