import re
from math import gcd

class Solution:
    def fractionAddition(self, expression):
        """
        :type expression: str
        :rtype: str
        """
        ints = map(int, re.findall("[+-]?\d+", expression))
        A, B = 0, 1
        for a in ints:
            b = next(ints)
            A = A * b + a * B
            B *= b
            g = gcd(A, B)
            A //= g
            B //= g
        return "%d/%d" % (A, B)
