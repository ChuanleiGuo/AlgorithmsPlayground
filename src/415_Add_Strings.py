class Solution(object):
    def addStrings(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        res = []
        carry = 0
        i, j = len(num1) - 1, len(num2) - 1
        while i >= 0 or j >= 0 or carry == 1:
            x = int(num1[i]) if i >= 0 else 0
            y = int(num2[j]) if j >= 0 else 0
            res.append((x + y + carry) % 10)
            carry = (x + y + carry) / 10

            i -= 1
            j -= 1
        res.reverse()
        return "".join(map(str, res))
