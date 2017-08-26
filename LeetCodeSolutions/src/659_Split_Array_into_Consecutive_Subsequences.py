from collections import Counter

class Solution:
    def isPossible(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        freq = Counter(nums)
        append_freq = dict()
        for num in nums:
            if freq[num] == 0:
                continue
            elif append_freq.get(num, 0) > 0:
                append_freq[num] -= 1
                append_freq[num + 1] = append_freq.get(num + 1, 0) + 1
            elif freq.get(num + 1, 0) > 0 and freq.get(num + 2, 0) > 0:
                freq[num + 1] -= 1
                freq[num + 2] -= 1
                append_freq[num + 3] = append_freq.get(num + 3, 0) + 1
            else:
                return False
            freq[num] -= 1
        return True

print(Solution().isPossible([1, 2, 3, 3, 4, 5]))
print(Solution().isPossible([1, 2, 3, 3, 4, 4, 5, 5]))
print(Solution().isPossible([1, 2, 3, 4, 4, 5]))
