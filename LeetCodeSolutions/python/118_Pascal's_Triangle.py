class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        res = []
        for i in range(numRows):
            s = [0] * (i + 1)
            if i == 0:
                s = [1]
                res.append(s)
            else:
                for j in range(i + 1):
                    if j == 0 or j == i:
                        s[j] = 1
                    else:
                        s[j] = res[i - 1][j - 1] + res[i - 1][j]
                res.append(s)
        return res
