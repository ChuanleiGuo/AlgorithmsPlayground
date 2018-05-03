class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):

    def __init__(self):
        self.pre = None
        self.mistake1 = None
        self.mistake2 = None

    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: void Do not return anything, modify root in-place instead.
        """
        # mistake1 = mistake2 = pre = None

        def in_order_traverse(root):
            if root is None:
                return
            in_order_traverse(root.left)
            if self.pre is not None and self.pre.val >= root.val:
                if self.mistake1 is None:
                    self.mistake1 = self.pre
                    self.mistake2 = root
                else:
                    self.mistake2 = root

            self.pre = root
            in_order_traverse(root.right)

        in_order_traverse(root)

        if self.mistake1 and self.mistake2:
            self.mistake1.val, self.mistake2.val = self.mistake2.val, self.mistake1.val
