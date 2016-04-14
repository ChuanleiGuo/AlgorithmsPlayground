class Solution(object):

    def __factorial(self, n):
        if n == 1:
            return 1
        else:
            return n * self.__factorial(n - 1)

    def getPermutation(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        k = k - 1
        record = [1] * n
        result = [0] * n
        for i in range(n):
            record[i] += i

        if n == 1:
            return "1" if k == 0 else ""

        for i in range(1, n - 1):
            f = self.__factorial(n - i)
            idx = k / f
            result[i - 1] = record[idx]
            del record[idx]
            k = k % f

        result[n - 2] = record[k ^ 0]
        result[n - 1] = record[k ^ 1]

        rtn = "".join(str(i) for i in result)
        return rtn

print Solution().getPermutation(3, 3)
