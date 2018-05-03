# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def generateTrees(self, n):
        """
        :type n: int
        :rtype: List[TreeNode]
        """
        if n == 0:
            return []
        return self.__helper(1, n)

    def __helper(self, start, end):
        res = []
        if start > end:
            return [None]
        for i in range(start, end + 1):
            lefts = self.__helper(start, i - 1)
            rights = self.__helper(i + 1, end)
            for j in range(0, len(lefts)):
                for k in range(0, len(rights)):
                    root = TreeNode(i)
                    root.left = lefts[j]
                    root.right = rights[k]
                    res.append(root)
        return res
