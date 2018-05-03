class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        length = len(s)
        res = 0
        sign = 1
        stack = []

        i = 0
        while i < length:
            if s[i].isdigit():
                num = int(s[i])
                while i + 1 < length and s[i + 1].isdigit():
                    num = num * 10 + int(s[i + 1])
                    i += 1
                res += sign * num
            elif s[i] == '+':
                sign = 1
            elif s[i] == '-':
                sign = -1
            elif s[i] == '(':
                stack.append(res)
                stack.append(sign)
                res = 0
                sign = 1
            elif s[i] == ')':
                res = res * stack.pop() + stack.pop()

            i += 1

        return res
