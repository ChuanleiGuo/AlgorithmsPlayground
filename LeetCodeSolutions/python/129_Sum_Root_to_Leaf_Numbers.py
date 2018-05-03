class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def dfs(root, num, s):
            if root is None:
                return 0
            num = num * 10 + root.val

            if root.left is None and root.right is None:
                s = num
                return s
            s = dfs(root.left, num, s) + dfs(root.right, num, s)
            return s

        if root is None:
            return 0
        return dfs(root, 0, 0)
