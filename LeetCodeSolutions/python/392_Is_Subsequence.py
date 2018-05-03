class Solution(object):
    def isSubsequence(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(t) < len(s):
            return False

        if len(s) == 0:
            return True

        if len(t) < 1:
            return False

        tIdx, sIdx = 0, 0

        while tIdx < len(t):
            while tIdx < len(t) and s[sIdx] != t[tIdx]:
                tIdx += 1
            if tIdx > len(t):
                break

            sIdx += 1
            tIdx += 1

            if sIdx >= len(s):
                return True

        return False