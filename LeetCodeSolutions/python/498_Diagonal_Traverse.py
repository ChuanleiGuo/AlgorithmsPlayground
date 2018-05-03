class Solution(object):
    def findDiagonalOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        if not matrix or len(matrix[0]) == 0:
            return []
        m, n = len(matrix), len(matrix[0])
        index_addtion_matrix = [[0] * n for _ in range(m)]

        for i in range(m):
            for j in range(n):
                index_addtion_matrix[i][j] = i + j
        
        travel_rows = {}

        for i in range(m):
            for j in range(n):
                idx = index_addtion_matrix[i][j]
                if idx not in travel_rows:
                    travel_rows[idx] = []
                travel_rows[idx].append(matrix[i][j])

        res = []
        for key, val in travel_rows.items():
            if key % 2 == 0:
                res += reversed(travel_rows[key])
            else:
                res += travel_rows[key]
        return res
