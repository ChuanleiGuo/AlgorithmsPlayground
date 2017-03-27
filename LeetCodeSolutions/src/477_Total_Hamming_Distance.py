class Solution(object):
    def totalHammingDistance(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        total, l = 0, len(nums)

        for i in range(0, 32):
            bit_count = 0
            for num in nums:
                bit_count += (num >> i) & 1
            total += bit_count * (l - bit_count)
        return total
