class Solution:
    def maximumSwap(self, num):
        """
        :type num: int
        :rtype: int
        """
        digits = list(str(num))
        buckets = [0] * 10
        for i in range(len(digits)):
            buckets[int(digits[i]) - 0] = i

        for i in range(len(digits)):
            for k in range(9, int(digits[i]) - 0, -1):
                if buckets[k] > i:
                    digits[i], digits[buckets[k]] = digits[buckets[k]], digits[i]
                    return int(''.join(digits))
        return num
