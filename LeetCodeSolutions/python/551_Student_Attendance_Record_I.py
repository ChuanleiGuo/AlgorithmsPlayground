from collections import Counter

class Solution(object):
    def checkRecord(self, s):
        """
        :type s: str
        :rtype: bool
        """
        a, l = 0, 0
        for char in s:
            if char == 'A':
                a += 1
            if char == 'L':
                l += 1
            else:
                l = 0
            if a > 1 or l > 2:
                return False
        return True 
