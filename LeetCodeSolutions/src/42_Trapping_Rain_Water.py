class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        area = 0
        sec_height = 0
        left, right = 0, len(height) - 1
        while left < right:
            if height[left] < height[right]:
                sec_height = max(height[left], sec_height)
                area += sec_height - height[left]
                left += 1
            else:
                sec_height = max(height[right], sec_height)
                area += sec_height - height[right]
                right -= 1
        return area

height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
print Solution().trap(height)
