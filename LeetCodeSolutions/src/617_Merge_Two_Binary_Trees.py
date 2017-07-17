class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def mergeTrees(self, t1, t2):
        """
        :type t1: TreeNode
        :type t2: TreeNode
        :rtype: TreeNode
        """
        if t1 is None and t2 is None:
            return None

        val1 = 0 if t1 is None else t1.val
        val2 = 0 if t2 is None else t2.val

        root = TreeNode(val1 + val2)
        left = self.mergeTrees(None if t1 is None else t1.left,
                               None if t2 is None else t2.left)
        right = self.mergeTrees(None if t1 is None else t1.right,
                                None if t2 is None else t2.right)
        root.left, root.right = left, right

        return root
