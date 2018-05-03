class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def findTilt(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.res = 0
        def _post_order(node):
            if not node:
                return 0
            left, right = _post_order(node.left), _post_order(node.right)
            self.res += abs(left - right)
            return node.val + left + right
        _post_order(root)
        return self.res
