class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s or len(s.strip()) < 1:
            return 0

        l = s.strip().split()
        return len(l[len(l) - 1])
