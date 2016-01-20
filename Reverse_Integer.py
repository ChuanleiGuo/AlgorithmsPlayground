class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        s = str(abs(x))
        s = s[::-1]
        num = int(s)
        if num > 2**31 - 1:
            return 0
        if x > 0:
            return num
        else:
            return -num

num = 123
print Solution().reverse(num)
num = -123
print Solution().reverse(num)
num = 1000000003
print Solution().reverse(num)
num = 1563847412
print Solution().reverse(num)
num = 32768
print Solution().reverse(num)