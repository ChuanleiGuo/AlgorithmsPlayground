class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def dfs(tree):
            if tree is None:
                return 0

            left_depth = dfs(tree.left)
            if left_depth == -1:
                return -1

            right_depth = dfs(tree.right)
            if right_depth == -1:
                return -1

            return -1 if abs(left_depth - right_depth) > 1 else \
                max(left_depth, right_depth) + 1

        return not dfs(root) == -1
