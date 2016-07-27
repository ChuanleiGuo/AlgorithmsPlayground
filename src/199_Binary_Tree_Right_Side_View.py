class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):

    # bfs

    # def rightSideView(self, root):
    #     """
    #     :type root: TreeNode
    #     :rtype: List[int]
    #     """
    #     if root is None:
    #         return []
    #
    #     res = []
    #     queue = []
    #     queue.append(root)
    #     while len(queue) != 0:
    #         s_arr = []
    #         s = len(queue)
    #         for i in range(s):
    #             node = queue.pop(0)
    #             s_arr.append(node.val)
    #             if node.left:
    #                 queue.append(node.left)
    #             if node.right:
    #                 queue.append(node.right)
    #         res.append(s_arr)
    #     res = map(lambda l: l[-1], res)
    #     return res

    # dfs

    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        def rightview(cur, arr, depth):
            if cur is None:
                return

            if depth == len(arr):
                arr.append(cur.val)

            rightview(cur.right, arr, depth + 1)
            rightview(cur.left, arr, depth + 1)

        res = []
        rightview(root, res, 0)
        return res
