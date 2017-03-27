class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if len(s) == 0:
            return True
        s1 = filter(lambda c: c.isdigit() or c.isalpha(), s)
        s1 = s1.lower()
        i, j = 0, len(s1) - 1
        while i <= j:
            if s1[i] != s1[j]:
                return False
            i += 1
            j -= 1
        return True
