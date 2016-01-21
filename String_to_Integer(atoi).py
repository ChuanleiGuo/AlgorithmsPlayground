class Solution(object):
    def myAtoi(self, string):
        """
        :type string: str
        :rtype: int
        """
        if len(string) == 0:
            return 0
        sign = 1
        start = 0
        s = string.strip()
        if s[0] == '+':
            sign = 1
            start += 1
        elif s[0] == '-':
            sign = -1
            start += 1

        res = 0
        for i in range(start, len(s)):
            if s[i].isdigit():
                res = res * 10 + int(s[i])
            else:
                return res * sign
            if res > 2 ** 31 - 1:
                if sign == 1:
                    return 2 ** 31 - 1
                else:
                    return - (2 ** 31)
        return res * sign

s = "-1"
print  Solution().myAtoi(s)