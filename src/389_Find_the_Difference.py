class Solution(object):
    def findTheDifference(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        char_num = {}
        for c in s:
            char_num[c] = char_num.get(c, 0) + 1
        for c in t:
            if c not in char_num:
                return c
            elif char_num[c] == 0:
                return c
            else:
                char_num[c] -= 1
