from collections import deque


class Solution(object):
    def licenseKeyFormatting(self, S, K):
        """
        :type S: str
        :type K: int
        :rtype: str
        """
        s = S.upper()
        s = filter(lambda c: c != '-', s)
        s = deque(s)
        res = deque()

        counter = 0
        while len(s):
            res.appendleft(s.pop())
            if counter == K - 1 and len(s) != 0:
                res.appendleft('-')
            counter += 1
            counter %= K
        return "".join(res)
