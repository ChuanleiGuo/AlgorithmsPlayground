class Solution(object):
    def removeBoxes(self, boxes):
        """
        :type boxes: List[int]
        :rtype: int
        """

        def dfs(array, memo, l, r, k):
            if l > r:
                return 0
            if memo[l][r][k] != 0:
                return memo[l][r][k]
            
            while r > l and array[r] == array[r - 1]:
                r -= 1
                k += 1
            memo[l][r][k] = dfs(array, memo, l, r - 1, 0) + (k + 1) ** 2
            for i in range(l, r):
                if array[i] == array[r]:
                    memo[l][r][k] = max(memo[l][r][k], \
                        dfs(array, memo, l, i, k + 1) + \
                        dfs(array, memo, i + 1, r - 1, 0))
            return memo[l][r][k]
        
        n = len(boxes)
        memo = [[[0] * 100 for _ in range(100)] for _ in range(100)]
        return dfs(boxes, memo, 0, n - 1, 0)
