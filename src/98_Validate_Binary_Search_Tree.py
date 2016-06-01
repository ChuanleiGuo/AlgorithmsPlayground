# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """

        def in_order_traverse(root):
            if root is None:
                return
            in_order_traverse(root.left)
            in_order.append(root.val)
            in_order_traverse(root.right)

        in_order = []
        in_order_traverse(root)
        for i in range(1, len(in_order)):
            if in_order[i] <= in_order[i - 1]:
                return False
        return True
