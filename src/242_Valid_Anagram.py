class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        alpha = {}
        for c in s:
            alpha[c] = alpha.get(c, 0) + 1
        for c in t:
            alpha[c] = alpha.get(c, 0) - 1
        for v in alpha.values():
            if v != 0:
                return False

        return True
