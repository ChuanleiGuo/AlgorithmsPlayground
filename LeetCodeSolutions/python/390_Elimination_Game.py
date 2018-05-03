class Solution(object):
    def lastRemaining(self, n):
        """
        :type n: int
        :rtype: int
        """
        left = 1
        remaining = n
        head = 1
        step = 1

        while remaining > 1:
            if left or remaining % 2 == 1:
                head += step
            remaining /= 2
            step *= 2

            left = not left
        return head
