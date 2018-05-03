class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        threshold = len(nums) / 2
        dictionary = {}
        for num in nums:
            dictionary[num] = dictionary.get(num, 0) + 1
            if dictionary[num] > threshold:
                return num
