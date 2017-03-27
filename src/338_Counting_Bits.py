class Solution(object):
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        bits = [0] * (num + 1)

        n = 1
        while n <= num:
            bits[n] = 1
            n *= 2

        subfactor = 2
        for i in range(3, num + 1):
            if bits[i] == 0:
                bits[i] = bits[i - subfactor] + 1
            else:
                subfactor = i

        return bits
