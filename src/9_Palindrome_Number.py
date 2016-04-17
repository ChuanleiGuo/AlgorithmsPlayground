class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if x < 0:
            return False
        s = str(x)
        i, j = 0, len(s) - 1
        while i < j:
            if s[i] == s[j]:
                i += 1
                j -= 1
            if not s[i] == s[j]:
                return False
        return True

num = 12321
print Solution().isPalindrome(num)
num = -12321
print Solution().isPalindrome(num)
num = -1
print Solution().isPalindrome(num)
num = -2147447412
print Solution().isPalindrome(num)