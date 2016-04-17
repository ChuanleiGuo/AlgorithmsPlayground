class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        length = len(digits)
        carry = 1

        for i in range(length - 1, -1, -1):
            if digits[i] + carry <= 9:
                digits[i] += carry
                carry = 0
            else:
                digits[i] = 0
                carry = 1

        if carry == 1:
            digits.append(0)
            for i in range(len(digits) - 2, -1, -1):
                digits[i + 1] = digits[i]
            digits[0] = 1

        return digits
