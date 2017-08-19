class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def printTree(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[str]]
        """
        if not root:
            return [""]

        def depth(root):
            if not root:
                return 0
            return max(depth(root.left), depth(root.right)) + 1

        d = depth(root)
        res = [[""] * (2 ** d - 1) for _ in range(d)]

        def helper(node, d, pos):
            res[-d - 1][pos] = str(node.val)
            if node.left:
                helper(node.left, d - 1, pos - 2 ** (d - 1))
            if note.right:
                helper(node.right, d - 1, pos + 2 ** (d - 1))
        
        helper(root, d - 1, 2 ** (d - 1) - 1)

        return res
