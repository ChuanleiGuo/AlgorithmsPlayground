class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if len(s) % 2 == 1:
            return False
        stack = []
        for letter in s:
            if letter == '(' or letter == '[' or letter == '{':
                stack.append(letter)
            elif len(stack) != 0 and letter == ')':
                if stack[-1] == '(':
                    stack.pop()
                else:
                    return False
            elif len(stack) != 0 and letter == ']':
                if stack[-1] == '[':
                    stack.pop()
                else:
                    return False
            elif len(stack) != 0 and letter == '}':
                if stack[-1] == '{':
                    stack.pop()
                else:
                    return False
            else:
                stack.append(letter)

        return True if (len(stack) == 0) else False

s = '[][][][][][][]'
print Solution().isValid(s)

s = '[][{}]'
print Solution().isValid(s)

s = '[][}'
print Solution().isValid(s)

s = '[[][][][]'
print Solution().isValid(s)

s = ']'
print Solution().isValid(s)

s = ")}{({))[{{[}"
print Solution().isValid(s)