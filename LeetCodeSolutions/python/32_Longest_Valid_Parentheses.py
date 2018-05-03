class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        stack = []
        res = 0
        for i in range(len(s)):
            if s[i] == '(':
                stack.append(i)
            else:
                if len(stack) != 0 and s[stack[-1]] == '(':
                    stack.pop()
                    res = max(i + 1 if len(stack) == 0 else i - stack[-1], res)
                else:
                    stack.append(i)
        return res

s = ')'
print Solution().longestValidParentheses(s)
s = '()'
print Solution().longestValidParentheses(s)