class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        len_a, len_b = len(a), len(b)
        length = max(len_a, len_b)
        carry = 0
        ans = ""

        for i in range(length):
            temp_a = int(a[len_a - 1 - i]) if len_a - 1 - i >= 0 else 0
            temp_b = int(b[len_b - 1 - i]) if len_b - 1 - i >= 0 else 0
            ans = str((temp_a + temp_b + carry) % 2) + ans
            carry = (temp_a + temp_b + carry) / 2

        if carry == 1:
            ans = "1" + ans

        return ans
