class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def __init__(self):
        self.ans = 0

    def maxPathSum(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def max_tree_sum(root_node):
            if root_node is None:
                return 0
            left = max_tree_sum(root_node.left)
            right = max_tree_sum(root_node.right)
            val = root_node.val
            if left > 0:
                val += left
            if right > 0:
                val += right
            self.ans = max(self.ans, val)
            return max(root_node.val,
                       left + root_node.val, right + root_node.val)

        if root is None:
            return 0
        self.ans = root.val
        max_tree_sum(root)
        return self.ans
