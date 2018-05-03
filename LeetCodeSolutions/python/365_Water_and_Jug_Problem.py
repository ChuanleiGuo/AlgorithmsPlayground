class Solution(object):
    def canMeasureWater(self, x, y, z):
        """
        :type x: int
        :type y: int
        :type z: int
        :rtype: bool
        """
        def gcd(a, b):
            while b != 0:
                a, b = b, a % b
            return a

        if x + y < z:
            return False

        if x == z or y == z or x + y == z:
            return True

        return z % gcd(max(x, y), min(x, y)) == 0