class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    def __repr__(self):
        return "Node: %d" % self.val


class Solution(object):
    def zigzagLevelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        res = []
        queue = []
        is_odd = True

        if root is None:
            return res
        else:
            queue.append(root)

        while len(queue) != 0:
            s_list = []
            s = len(queue)

            for i in range(s):
                node = queue.pop(0)
                s_list.append(node.val)

                if node.left is not None:
                    queue.append(node.left)
                if node.right is not None:
                    queue.append(node.right)

            if not is_odd:
                s_list.reverse()

            is_odd = not is_odd
            res.append(s_list)

        return res
