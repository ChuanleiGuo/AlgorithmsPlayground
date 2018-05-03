class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        length = len(s)
        res = 0
        sign = '+'
        stack = []

        i = 0
        num = 0
        while i < length:
            if s[i].isdigit():
                num = num * 10 + int(s[i])
            if ((not s[i].isdigit()) and s[i] != ' ') or i == length - 1:
                if sign == '-':
                    stack.append(-num)
                if sign == '+':
                    stack.append(num)
                if sign == '*':
                    stack.append(stack.pop() * num)
                if sign == '/':
                    stack.append(int(float(stack.pop()) / num))

                sign = s[i]
                num = 0

            i += 1

        for i in stack:
            res += i

        return res
