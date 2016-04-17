class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        L = len(nums)
        end = L

        start = 0

        # put all negative number at the end of the list

        while start < end:
            if nums[start] <= 0:
                temp = nums[start]
                nums[start] = nums[end-1]
                nums[end-1] = temp
                end = end - 1
            else:
                start = start + 1

        if end <= 0:
            return 1


        # put the number to its corresponding index by swap;
        # for duplicated number, set to 0;
        # for number longer than the lengh of 'positive' list, set to 0

        current = 0

        while current < end:
            if nums[current] == current+1 or nums[current] == 0:
                current += 1
            elif nums[current] >= end+1:
                nums[current] = 0
                current += 1

            else:
                temp = nums[current]
                if nums[temp-1] == temp:
                    nums[current] = 0
                else:
                    nums[current] = nums[temp-1]
                    nums[temp-1] = temp

        # find the first 0, which is the missing number; if not, the missing number is in the end

        for current in range(end):
            if nums[current] == 0:
                return current+1

        return end+1


arr = [1, 2, 0]
print Solution().firstMissingPositive(arr)
arr = [3, 4, -1, 1]
print Solution().firstMissingPositive(arr)
