class Solution(object):

    def __pre_process(self, s):
        n = len(s)
        if n == 0:
            return "^$"
        ret = "^"
        for i in range(n):
            ret += ("#" + s[i: i + 1])
        ret += "#$"
        return ret

    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        str = self.__pre_process(s)
        length = len(str)
        p = [0] * length
        center = 0
        right = 0
        for i in range(1, length - 1):
            i_mirror = center - (i - center)
            diff = right - i
            if diff >= 0:
                if p[i_mirror] < diff:
                    p[i] = p[i_mirror]
                else:
                    p[i] = diff
                    while str[i + p[i] + 1] == str[i - p[i] - 1]:
                        p[i] += 1
                    center = i
                    right = i + p[i]
            else:
                while str[i + p[i] + 1] == str[i - p[i] - 1]:
                    p[i] += 1
                center = i
                right = i + p[i]

        maxlen = 0
        centerIndex = 0
        for i in range(1, length - 1):
            if p[i] > maxlen:
                maxlen = p[i]
                centerIndex = i

        result = ""
        for i in range(centerIndex - maxlen + 1, centerIndex + maxlen):
            if not str[i] == "#":
                result += str[i]

        return result

str = "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa"
print Solution().longestPalindrome(str)