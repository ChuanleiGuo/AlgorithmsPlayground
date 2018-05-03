class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        flatten_matrix = reduce(lambda x, y: x + y, matrix)

        low, high = 0, len(flatten_matrix) - 1
        while low <= high:
            mid = low + (high - low) / 2
            if flatten_matrix[mid] == target:
                return True
            elif flatten_matrix[mid] < target:
                low = mid + 1
            else:
                high = mid - 1

        return False
