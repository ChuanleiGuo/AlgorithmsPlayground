class Solution(object):
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        import string
        dictionary = dict(zip(string.uppercase, range(26)))
        res = 0
        for char in s:
            num = dictionary[char]
            res = res * 26 + (num + 1)
        return res
