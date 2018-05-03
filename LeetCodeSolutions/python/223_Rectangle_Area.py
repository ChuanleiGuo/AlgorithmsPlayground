class Solution(object):
    def computeArea(self, A, B, C, D, E, F, G, H):
        """
        :type A: int
        :type B: int
        :type C: int
        :type D: int
        :type E: int
        :type F: int
        :type G: int
        :type H: int
        :rtype: int
        """
        rect_one = (C - A) * (D - B)
        rect_two = (G - E) * (H - F)

        if A >= G or B >= H or C <= E or D <= F:
            return rect_one + rect_two

        l = min(C, G) - max(A, E)
        h = min(D, H) - max(B, F)
        return rect_one + rect_two - l * h
