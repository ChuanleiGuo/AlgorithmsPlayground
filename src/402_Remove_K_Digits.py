class Solution(object):
    def removeKdigits(self, num, k):
        """
        :type num: str
        :type k: int
        :rtype: str
        """
        l = len(num)
        if k == l:
            return "0"

        stack = []
        for c in num:
            while k > 0 and len(stack) > 0 and stack[-1] > c:
                stack.pop()
                k -= 1
            stack.append(c)
        
        while k > 0:
            stack.pop()
            k -= 1
        
        i = 0
        while i < len(stack) - 1 and stack[i] == '0':
            i += 1
        stack = stack[i:]
        return "".join(stack)


