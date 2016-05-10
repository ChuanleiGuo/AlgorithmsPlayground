class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: bool
        """
        if nums is None or len(nums) == 0:
            return False
        l, r = 0, len(nums) - 1
        while l <= r:
            m = l + (r - l) / 2
            if nums[m] == target:
                return True
            if nums[m] == nums[l]:
                l += 1
            elif nums[m] > nums[l]:
                if nums[l] <= target < nums[m]:
                    r = m - 1
                else:
                    l = m + 1
            else:
                if nums[m] < target <= nums[r]:
                    l = m + 1
                else:
                    r = m - 1
        return False
