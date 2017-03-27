class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        if len(digits) < 1:
            return []
        dic = {
            '0': '',
            '1': '',
            '2': 'abc',
            '3': 'def',
            '4': 'ghi',
            '5': 'jkl',
            '6': 'mno',
            '7': 'pqrs',
            '8': 'tuv',
            '9': 'wxyz'
        }
        l = []
        result = []
        for i in range(len(digits)):
            key = digits[i]
            l.append(dic[key])
        self.dfs(result, l, "", len(digits))
        return result

    def dfs(self, result, l, s, length):
        if len(s) == length:
            result.append(s)
            return
        l_s = len(s)
        for i in range(len(l[l_s])):
            s += l[l_s][i]
            self.dfs(result, l, s, length)
            s = s[: len(s) - 1]

s = '23'
print Solution().letterCombinations(s)