from itertools import combinations


class Solution:
    def validSquare(self, p1, p2, p3, p4):
        """
        :type p1: List[int]
        :type p2: List[int]
        :type p3: List[int]
        :type p4: List[int]
        :rtype: bool
        """
        def dist(p_tuple):
            p, q = p_tuple[0], p_tuple[1]
            return (p[0] - q[0]) ** 2 + (p[1] - q[1]) ** 2
        s = set(map(dist, combinations((p1, p2, p3, p4), 2)))
        return len(s) == 2 and 0 not in s
