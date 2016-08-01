class Solution(object):
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        __hash_map = set()
        res = n

        while res != 1:
            if res in __hash_map:
                return False
            else:
                __hash_map.add(res)
                tmp = 0
                while res != 0:
                    tmp += (res % 10) ** 2
                    res /= 10
                res = tmp
        return True
