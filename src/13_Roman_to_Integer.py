class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        dic = {
            'I': 1,
            'V': 5,
            'X': 10,
            'L': 50,
            'C': 100,
            'D': 500,
            'M': 1000
        }

        n = len(s)
        result = dic[s[n - 1]]
        for i in range(n - 2, -1, -1):
            if dic[s[i + 1]] <= dic[s[i]]:
                result += dic[s[i]]
            else:
                result -= dic[s[i]]
        return result