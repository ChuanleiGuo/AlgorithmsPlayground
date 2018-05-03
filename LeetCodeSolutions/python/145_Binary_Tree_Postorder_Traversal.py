class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def postorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        res = []
        stack = []
        while root or len(stack):
            while root:
                stack.append(root)
                res.insert(0, root.val)
                root = root.right
            root = stack.pop()
            root = root.left
        return res
