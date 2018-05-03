class Solution(object):
    def repeatedSubstringPattern(self, str):
        """
        :type str: str
        :rtype: bool
        """
        l = len(str)
        for i in range(l / 2, 0, -1):
            if l % i == 0:
                m = l / i
                if str[0: i] * m == str:
                    return True

        return False
