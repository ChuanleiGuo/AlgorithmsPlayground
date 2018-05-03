class Solution(object):
    def checkRecord(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n < 2:
            return n * 3
        nums = [1]
        while len(nums) <= n + 1:
            nums.append(sum(nums[-3:]) % 1000000007)
        return sum(map(operator.mul, nums[:-1], nums[:0:-1])) % 1000000007
