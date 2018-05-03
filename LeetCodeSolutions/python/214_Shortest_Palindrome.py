class Solution(object):
    def shortestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        builder = str(s)
        return builder[::-1][0: -self.__get_common_length(s)] + s

    def __get_common_length(self, s):
        rev = s[::-1]
        builder = s + '#' + rev
        p = [0] * len(builder)
        for i in range(1, len(p)):
            j = p[i - 1]
            while j > 0 and builder[i] != builder[j]:
                j = p[j - 1]
            if j == 0:
                p[i] = 1 if builder[i] == builder[0] else 0
            else:
                p[i] = j + 1
        return p[-1]
