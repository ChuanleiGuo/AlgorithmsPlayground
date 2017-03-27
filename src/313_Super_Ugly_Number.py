class Solution(object):
    def nthSuperUglyNumber(self, n, primes):
        """
        :type n: int
        :type primes: List[int]
        :rtype: int
        """
        ugly = [0] * n
        idxs = [0] * len(primes)
        vals = [1] * len(primes)

        next = 1
        for i in range(n):
            ugly[i] = next

            next = 2 ** 31 - 1
            for j in range(len(primes)):
                if vals[j] == ugly[i]:
                    vals[j] = ugly[idxs[j]] * primes[j]
                    idxs[j] += 1
                next = min(next, vals[j])

        return ugly[-1]
