from math import sqrt


class Solution(object):
    def constructRectangle(self, area):
        """
        :type area: int
        :rtype: List[int]
        """
        if area == 0:
            return 0, 0
        w = int(sqrt(area))
        while area % w:
            w -= 1
        return area / w, w