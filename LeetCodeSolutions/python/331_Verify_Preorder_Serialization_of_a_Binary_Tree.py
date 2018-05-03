class Solution(object):
    def isValidSerialization(self, preorder):
        """
        :type preorder: str
        :rtype: bool
        """
        nodes = preorder.split(',')
        degree = 1
        for node in nodes:
            degree -= 1
            if degree < 0:
                return False
            if node != '#':
                degree += 2
        return degree == 0
