class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        dic = dict()
        result = []
        for i in range(len(nums)):
            if not nums[i] in dic:
                dic[target - nums[i]] = i
            else:
                key = nums[i]
                result.append(dic[key] + 1)
                result.append(i + 1)
                break

        return result

nums = [2, 7, 11, 15]
target = 9

result = Solution().twoSum(nums, target)
print result
