class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def pathSum(self, root, s):
        """
        :type root: TreeNode
        :type s: int
        :rtype: int
        """
        if not root:
            return 0
        return self.find_path(root, s) + self.pathSum(root.left, s) + \
               self.pathSum(root.right, s)

    def find_path(self, node, s):
        res = 0
        if not node:
            return res
        if s == node.val:
            res += 1

        res += self.find_path(node.left, s - node.val)
        res += self.find_path(node.right, s - node.val)
        return res
