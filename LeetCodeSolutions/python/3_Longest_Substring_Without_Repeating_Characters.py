class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if len(s) == 0:
            return 0
        if len(s) == 1:
            return 1

        last_pos = { s[0]: 0 }
        longest_sub = [1] * len(s)

        for i in range(1, len(s)):
            seen = last_pos.get(s[i], -1)
            if seen < i - longest_sub[i - 1]:
                longest_sub[i] = longest_sub[i - 1] + 1
            else:
                longest_sub[i] = i - seen
            last_pos[s[i]] = i
        return max(longest_sub)

str = 'abcabcbb'
print Solution().lengthOfLongestSubstring(str)