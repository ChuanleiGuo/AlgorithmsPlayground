class Solution(object):
    def longestSubstring(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """

        def dfs(s, start, end, k):
            if end - start < 0:
                return 0
            if end - start < k:
                return 0
            count = [0] * 26
            for c in s[start: end]:
                count[ord(c) - ord('a')] += 1

            for idx, c in enumerate(count):
                if c == 0:
                    continue
                if c < k:
                    for j in range(start, end):
                        if s[j] == chr(ord('a') + idx):
                            left = dfs(s, start, j, k)
                            right = dfs(s, j + 1, end, k)
                            return max(left, right)
            return end - start

        return dfs(s, 0, len(s), k)
