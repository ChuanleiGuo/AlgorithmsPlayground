class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def flatten(self, root):
        """
        :type root: TreeNode
        :rtype: void Do not return anything, modify root in-place instead.
        """
        cur = root
        pre = None
        while cur is not None:
            if cur.left is None:
                cur = cur.right
            else:
                pre = cur.left
                while pre.right is not None:
                    pre = pre.right
                pre.right = cur.right
                cur.right = cur.left
                cur.left = None
