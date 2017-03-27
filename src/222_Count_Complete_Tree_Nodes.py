class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def countNodes(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """

        def left_depth(r):
            depth = 0
            while r:
                r = r.left
                depth += 1
            return depth

        def right_depth(r):
            depth = 0
            while r:
                r = r.right
                depth += 1
            return depth

        if not root:
            return 0

        ldepth = left_depth(root)
        rdepth = right_depth(root)
        if ldepth == rdepth:
            return (1 << ldepth) - 1
        else:
            return 1 + self.countNodes(root.left) + self.countNodes(root.right)
