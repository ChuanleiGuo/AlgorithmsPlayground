class Solution(object):
    def wiggleMaxLength(self, nums):
        if len(nums) == 0 or len(nums) == 1:
            return len(nums)

        k = 0
        while k < len(nums) - 1 and nums[k] == nums[k + 1]:
            k += 1

        if k == len(nums) - 1:
            return 1

        result = 2
        small_req = (nums[k] < nums[k + 1])
        for i in range(k + 1, len(nums) - 1):
            if small_req and nums[i + 1] < nums[i]:
                nums[result] = nums[i + 1]
                result += 1
                small_req = not small_req
            elif not small_req and nums[i + 1] > nums[i]:
                nums[result] = nums[i + 1]
                result += 1
                small_req = not small_req

        return result
