class Solution(object):
    def fourSumCount(self, A, B, C, D):
        """
        :type A: List[int]
        :type B: List[int]
        :type C: List[int]
        :type D: List[int]
        :rtype: int
        """

        sum_dict = {}

        for c in C:
            for d in D:
                sum_dict[c + d] = sum_dict.get(c + d, 0) + 1

        res = 0
        for a in A:
            for b in B:
                res += sum_dict.get(-(a + b), 0)

        return res
