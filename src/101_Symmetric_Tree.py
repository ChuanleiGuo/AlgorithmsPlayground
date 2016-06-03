class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def is_S(left, right):
            if left is None and right is None:
                return True
            if left is None or right is None:
                return False

            if left.val != right.val:
                return False

            return is_S(left.left, right.right) and is_S(right.left, left.right)

        if root is None:
            return True
        return is_S(root.left, root.right)
