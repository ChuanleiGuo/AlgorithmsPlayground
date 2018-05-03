class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if len(height) < 2:
            return 0
        low, high = 0, len(height) - 1
        max_s = 0
        while low < high:
            low_max, high_max = height[low], height[high]
            size = (high - low) * (low_max if low_max < high_max else high_max)
            max_s = (size if size > max_s else max_s)
            if height[low] < height[high]:
                while (low < len(height) - 1) and height[low] <= low_max:
                    low += 1
            else:
                while (high > 0) and height[high] <= high_max:
                    high -= 1
        return max_s


height = [0, 1, 2, 3, 4, 5]
print Solution().maxArea(height)