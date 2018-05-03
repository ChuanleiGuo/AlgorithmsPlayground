class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        char_num_pairs = {}
        for char in s:
            char_num_pairs[char] = char_num_pairs.get(char, 0) + 1

        res = 0
        has_odd = False
        for n in char_num_pairs.itervalues():
            if n % 2 == 0:
                res += n
            else:
                res += (n - 1)
                has_odd = True

        return res if not has_odd else res + 1
