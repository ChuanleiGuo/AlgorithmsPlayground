class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root is None:
            return []
        row_of_nodes = [root]
        res = []
        while len(row_of_nodes):
            length = len(row_of_nodes)
            val_max = -float("inf")
            for i in range(length):
                node = row_of_nodes.pop(0)
                val_max = max(val_max, node.val)
                if node.left:
                    row_of_nodes.append(node.left)
                if node.right:
                    row_of_nodes.append(node.right)
            res.append(val_max)
        return res
