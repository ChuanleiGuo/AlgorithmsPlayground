class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        from collections import Counter
        char_nums = Counter(s)

        for i, c in enumerate(s):
            if char_nums[c] == 1:
                return i
        return -1
