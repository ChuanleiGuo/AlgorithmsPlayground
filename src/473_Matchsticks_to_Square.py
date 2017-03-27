class Solution(object):
    def makesquare(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if not nums or len(nums) < 4:
            return False
        if sum(nums) % 4 != 0:
            return False
        nums.sort()
        nums.reverse()

        return self.__dfs(nums, [0] * 4, 0, sum(nums) / 4)

    def __dfs(self, nums, sums, index, target):
        if index == len(nums):
            if sums[0] == target and sums[1] == target and sums[2] == target:
                return True
            return False

        for i in range(4):
            if sums[i] + nums[index] > target:
                continue
            sums[i] += nums[index]
            if self.__dfs(nums, sums, index + 1, target):
                return True
            sums[i] -= nums[index]
        return False
