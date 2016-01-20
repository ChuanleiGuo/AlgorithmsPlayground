class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if numRows <= 1 or numRows >= len(s): return s
        strs = [''] * numRows
        row, step = 0, 1
        for i in range(len(s)):
            strs[row] += s[i]
            if row == 0:
                step = 1
            if row == numRows - 1:
                step = -1
            row += step
        res = ''
        for str in strs:
            res += str
        return res

str = 'ABC'
print Solution().convert(str, 1)