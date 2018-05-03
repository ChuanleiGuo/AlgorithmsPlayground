class Solution(object):
    def convertToTitle(self, n):
        """
        :type n: int
        :rtype: str
        """
        import string
        dictionary = dict(zip(range(0, 26), string.uppercase))

        res = ''
        while n:
            m = (n - 1) % 26
            res = dictionary[m] + res
            n = (n - 1) / 26
        return res

