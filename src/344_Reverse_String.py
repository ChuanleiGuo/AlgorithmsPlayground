class Solution(object):
    def reverseString(self, s):
        """
        :type s: str
        :rtype: str
        """
        begin, end = 0, len(s) - 1
        array = list(s)
        while begin <= end:
            array[begin], array[end] = array[end], array[begin]
            begin += 1
            end -= 1
        return "".join(array)
