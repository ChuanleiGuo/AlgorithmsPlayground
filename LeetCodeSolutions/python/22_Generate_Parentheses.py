class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        def recur(result, string, left, right):
            if left == 0 and right == 0:
                result.append(string)
                return
            if left > 0:
                recur(result, string + '(', left - 1, right)
            if right > left:
                recur(result, string + ')', left, right - 1)

        result = []
        recur(result, '', n, n)
        return result

n = 3
print Solution().generateParenthesis(n)