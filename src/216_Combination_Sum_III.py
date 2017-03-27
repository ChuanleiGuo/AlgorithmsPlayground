class Solution(object):
    def combinationSum3(self, k, n):
        """
        :type k: int
        :type n: int
        :rtype: List[List[int]]
        """
        ans = []
        self.__combine(ans, [], k, 1, n)
        return ans

    def __combine(self, ans, comb, k, start, n):
        if len(comb) == k and n == 0:
            li = list(comb)
            ans.append(li)
            return
        for i in range(start, 10):
            comb.append(i)
            self.__combine(ans, comb, k, i + 1, n - i)
            comb.pop(-1)
