class Solution(object):
    def magicalString(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n <= 0: return 0
        if n <= 3: return 1
        res = [0] * (n + 1)
        res[0], res[1], res[2] = 1, 2, 2
        head = 2; tail = 3
        total = 1; num = 1
        while tail < n:
            for i in range(res[head]):
                res[tail] = num
                if num == 1 and tail < n:
                    total += 1
                tail += 1
            num ^= 3
            head += 1
        return total
