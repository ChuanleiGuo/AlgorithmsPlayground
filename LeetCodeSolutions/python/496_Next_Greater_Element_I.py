class Solution(object):
    def nextGreaterElement(self, findNums, nums):
        """
        :type findNums: List[int]
        :type nums: List[int]
        :rtype: List[int]
        """
        num_res_dict = {}
        stack = []
        for num in nums:
            while len(stack) != 0 and stack[-1] < num:
                num_res_dict[stack.pop(-1)] = num
            stack.append(num)
        for i in range(len(findNums)):
            findNums[i] = num_res_dict.get(findNums[i], -1)
        return findNums