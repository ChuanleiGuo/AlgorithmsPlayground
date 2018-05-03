class Solution(object):
    def matrixReshape(self, nums, r, c):
        """
        :type nums: List[List[int]]
        :type r: int
        :type c: int
        :rtype: List[List[int]]
        """
        row, col = len(nums), len(nums[0])
        if row * col != r * c:
            return nums
        
        nums = [nums[i][j] for i in range(row) for j in range(col)]
        mat = [[0] * c for _ in range(r)]
        for i in range(r * c):
            mat[i / c][i % c] = nums[i]
        return mat
