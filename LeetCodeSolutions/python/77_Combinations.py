class Solution(object):
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        ans = []
        temp = []
        self.dfs(ans, temp, n, k, 1)
        return ans

    def dfs(self, ans, temp, n, k, start):
        if len(temp) == k:
            ans.append(list(temp))
            return

        for i in range(start, n + 1):
            temp.append(i)
            self.dfs(ans, temp, n, k, i + 1)
            temp.pop()
