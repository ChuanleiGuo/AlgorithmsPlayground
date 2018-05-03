class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        if not nums:
            return []
        counter1, counter2, candidate1, candidate2 = 0, 0, 0, 1
        for num in nums:
            if num == candidate1:
                counter1 += 1
            elif num == candidate2:
                counter2 += 1
            elif counter1 == 0:
                candidate1, counter1 = num, 1
            elif counter2 == 0:
                candidate2, counter2 = num, 1
            else:
                counter1, counter2 = counter1 - 1, counter2 - 1
        return [n for n in (candidate1, candidate2)
                if nums.count(n) > len(nums) // 3]
