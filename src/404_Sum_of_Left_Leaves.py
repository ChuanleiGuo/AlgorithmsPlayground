class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def sumOfLeftLeaves(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def dfs(node, isleft):
            if not node:
                return 0
            if isleft and not node.left and not node.right:
                return node.val
            return dfs(node.left, True) + dfs(node.right, False)

        return dfs(root, False)
