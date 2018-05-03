class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        queue = []
        res = []
        queue.append(root)

        if root is None:
            return res

        while len(queue) != 0:
            s_arr = []
            s = len(queue)
            for i in range(s):
                node = queue.pop(0)
                s_arr.append(node.val)
                if node.left is not None:
                    queue.append(node.left)
                if node.right is not None:
                    queue.append(node.right)
            res.append(s_arr)
        return res
