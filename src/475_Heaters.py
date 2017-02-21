class Solution(object):
    def findRadius(self, houses, heaters):
        """
        :type houses: List[int]
        :type heaters: List[int]
        :rtype: int
        """
        houses.sort()
        heaters.sort()

        i, res = 0, 0
        for house in houses:
            while i < len(heaters) - 1 and heaters[i] + heaters[i + 1] <= house * 2:
                i += 1
            res = max(res, abs(heaters[i] - house))
        return res
