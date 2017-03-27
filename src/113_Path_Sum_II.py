class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def pathSum(self, root, sum1):
        """
        :type root: TreeNode
        :type sum1: int
        :rtype: List[List[int]]
        """
        if root is None:
            return []
        stack = [(root, [root.val])]
        res = []
        while len(stack) != 0:
            temp, vals = stack.pop()
            if not temp.left and not temp.right:
                if sum(vals) == sum1:
                    res.append(vals)
            if temp.left:
                stack.append((temp.left, vals + [temp.left.val]))
            if temp.right:
                stack.append((temp.right, vals + [temp.right.val]))
        return res
