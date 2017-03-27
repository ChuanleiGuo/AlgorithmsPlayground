class Solution(object):
    def countDigitOne(self, n):
        """
        :type n: int
        :rtype: int
        """

        if n < 0:
            return 0

        count = 0
        factor = 1

        while n / factor:
            lower = n - (n / factor) * factor
            cur = (n / factor) % 10
            higher = n / (factor * 10)

            if cur == 0:
                count += higher * factor
            elif cur == 1:
                count += higher * factor + lower + 1
            else:
                count += (higher + 1) * factor

            factor *= 10
        return count
