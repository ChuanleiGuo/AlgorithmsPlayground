class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def levelOrderBottom(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        queue = []
        res = []

        if root is None:
            return res

        queue.append(root)

        while len(queue) != 0:
            s_l = []
            s = len(queue)
            for i in range(s):
                node = queue.pop(0)
                s_l.append(node.val)

                if node.left is not None:
                    queue.append(node.left)
                if node.right is not None:
                    queue.append(node.right)

            res.append(s_l)

        res.reverse()
        return res
