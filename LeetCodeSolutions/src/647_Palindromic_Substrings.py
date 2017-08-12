class Solution:

    def countSubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        count = 0

        def extend_palindromic(string, left, right):
            nonlocal count
            while left >= 0 and right < len(string) and s[left] == s[right]:
                count += 1
                left, right = left - 1, right + 1

        if s is None or len(s) == 0:
            return 0

        for i in range(len(s)):
            extend_palindromic(s, i, i)
            extend_palindromic(s, i, i + 1)
        return count
