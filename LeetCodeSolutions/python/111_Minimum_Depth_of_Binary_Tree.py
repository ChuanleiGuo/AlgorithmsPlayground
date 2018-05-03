class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def minDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        depth = 0
        if root is None:
            return 0

        if root.left is not None and root.right is not None:
            depth = min(self.minDepth(root.left), self.minDepth(root.right))
        elif root.left is not None:
            depth = self.minDepth(root.left)
        else:
            depth = self.minDepth(root.right)

        return depth + 1
