class Solution(object):
    def convertToBase7(self, num):
        """
        :type num: int
        :rtype: str
        """
        if num == 0: return '0'
        sign = (num >= 0)
        num = abs(num) 
        res = []
        while num:
            res.append(num % 7)
            num /= 7
        res = "".join(reversed(map(str, res)))
        return res if sign else '-'+res
