class Solution(object):
    def isSelfCrossing(self, x):
        """
        :type x: List[int]
        :rtype: bool
        """
        length = len(x)
        if length <= 3:
            return False

        for i in range(3, length):
            if x[i] >= x[i - 2] and x[i - 1] <= x[i - 3]:
                return True
            if i >= 4:
                if x[i - 1] == x[i - 3] and x[i] + x[i - 4] >= x[i - 2]:
                    return True
            if i >= 5:
                if 0 <= x[i - 2] - x[i - 4] <= x[i] and \
                        x[i - 3] - x[i - 5] <= x[i - 1] <= x[i - 3]:

                    return True

        return False
