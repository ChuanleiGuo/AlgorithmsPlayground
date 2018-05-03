class Solution(object):
    def maximalRectangle(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if matrix is None or len(matrix) == 0:
            return 0
        res = 0
        heights = [0] * len(matrix[0])
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == "0":
                    heights[j] = 0
                else:
                    heights[j] += 1
            res = max(res, self.largestRectangleArea(heights))
        return res

    def largestRectangleArea(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """
        if len(heights) == 0:
            return 0
        max_area = self.get_max(heights, 0, len(heights) - 1)
        return max_area

    def get_max(self, heights, start, end):
        if start > end:
            return 0
        if start == end:
            return heights[start]

        min_area = heights[start]
        min_idx = start
        is_sorted = is_reverse_sorted = True
        for i in range(start + 1, end + 1):
            if heights[i] < min_area:
                min_area = heights[i]
                min_idx = i

            if heights[i] < heights[i - 1]:
                is_sorted = False

            if heights[i - 1] < heights[i]:
                is_reverse_sorted = False

        if is_sorted:
            max_area = 0
            for i in range(start, end + 1):
                temp = heights[i] * (end - i + 1)
                max_area = max(max_area, temp)
            return max_area

        if is_reverse_sorted:
            max_area = 0
            for i in range(start, end + 1):
                temp = heights[i] * (i - start + 1)
                max_area = max(max_area, temp)
            return max_area

        max_area = min_area * (end - start + 1)
        left_area = self.get_max(heights, start, min_idx - 1)
        right_area = self.get_max(heights, min_idx + 1, end)

        return max(max_area, left_area, right_area)
