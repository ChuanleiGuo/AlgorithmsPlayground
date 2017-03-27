class Solution(object):
    def __init__(self, nums):
        """
        :type nums: List[int]
        :type size: int
        """
        self.__nums = nums

    def reset(self):
        """
        Resets the array to its original configuration and return it.
        :rtype: List[int]
        """
        return self.__nums

    def shuffle(self):
        """
        Returns a random shuffling of the array.
        :rtype: List[int]
        """
        from random import shuffle
        res = list(self.__nums)
        shuffle(res)
        return res
