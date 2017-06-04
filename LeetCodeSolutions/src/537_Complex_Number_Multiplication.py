import re


class Solution(object):
    def complexNumberMultiply(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        a, ai, b, bi = map(int, re.findall("-?\d+", a+b))
        return "%d+%di" % ((a * b - ai * bi), (a * bi + ai * b))
