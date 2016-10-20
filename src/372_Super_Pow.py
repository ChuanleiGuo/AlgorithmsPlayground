class Solution(object):

    _BASE = 1337

    def __powmod(self, a, n):
        a %= Solution._BASE
        res = 1
        for i in xrange(n):
            res = (res * a) % Solution._BASE
        return res

    def superPow(self, a, b):
        """
        :type a: int
        :type b: List[int]
        :rtype: int
        """
        if not b:
            return 1
        last_digit = b.pop(-1)
        return self.__powmod(self.superPow(a, b), 10) * \
               self.__powmod(a, last_digit) % Solution._BASE
