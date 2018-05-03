class Solution(object):
    def characterReplacement(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """
        start = 0
        counts = [0] * 26
        max_char_count = 0
        res = 0
        for end in range(len(s)):
            counts[ord(s[end]) - ord('A')] += 1
            max_char_count = max(counts[ord(s[end]) - ord('A')], max_char_count)

            while end - start - max_char_count + 1 > k:
                counts[ord(s[start]) - ord('A')] -= 1
                start += 1
                max_char_count = max(counts)

            res = max(res, end - start + 1)
        return res
