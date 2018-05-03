class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def rob(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def robSub(node, hash_map):
            if node is None:
                return 0

            if node in hash_map:
                return hash_map[node]

            val = 0

            if node.left:
                val += robSub(node.left.left, hash_map) + robSub(node.left.right, hash_map)

            if node.right:
                val += robSub(node.right.left, hash_map) + robSub(node.right.right, hash_map)

            val = max(val + node.val, robSub(node.left, hash_map) + robSub(node.right, hash_map))
            hash_map[node] = val

            return val

        node_vals = {}
        return robSub(root, node_vals)
