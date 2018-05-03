class Solution(object):
    def findCircleNum(self, M):
        """
        :type M: List[List[int]]
        :rtype: int
        """

        def dfs(matrix, visited, start):
            for j in range(len(matrix)):
                if matrix[start][j] == 1 and not visited[j]:
                    visited[j] = 1
                    dfs(matrix, visited, j)
        
        visited = [False] * len(M)
        count = 0
        for i in range(len(M)):
            if not visited[i]:
                dfs(M, visited, i)
                count += 1
        
        return count
