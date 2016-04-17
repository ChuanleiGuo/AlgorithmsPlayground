class Solution(object):

    def twoSum(self, nums, target):
        dic = dict()
        result = []
        for i in range(len(nums)):
            if not nums[i] in dic:
                dic[target - nums[i]] = i
            else:
                arr = [target - nums[i], nums[i]]
                result.append(arr)
        return result


    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = []
        length = len(nums)
        nums.sort()
        for i in range(length):
            two_nums = self.twoSum(nums[i + 1:], -nums[i])
            for two_num in two_nums:
                arr = [nums[i]] + two_num
                if arr not in result:
                    result.append(arr)

        return result

s = [-1, 0, 1, 2, -1, -4]
print Solution().threeSum(s)