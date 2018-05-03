class Solution(object):
    def grayCode(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        l = [0]
        if n == 0:
            return l
        if n == 1:
            l.append(1)
            return l
        prefix = 1 << (n - 1)
        l = self.grayCode(n - 1)
        for i in range(len(l) - 1, -1, -1):
            l.append(prefix + l[i])
        return l
