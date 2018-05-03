class Solution:
    def findLongestChain(self, pairs):
        """
        :type pairs: List[List[int]]
        :rtype: int
        """
        pairs = sorted(pairs, key=lambda p: p[1])
        res = 0
        idx = 0
        while idx < len(pairs):
            res += 1
            cur_end = pairs[idx][1]
            while idx + 1 < len(pairs) and pairs[idx + 1][0] <= cur_end:
                idx += 1
            idx += 1
        return res
