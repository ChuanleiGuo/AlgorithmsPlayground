from collections import deque

class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def averageOfLevels(self, root):
        """
        :type root: TreeNode
        :rtype: List[float]
        """
        queue = deque()
        res = []
        queue.append(root)
        while len(queue): 
            n = len(queue)
            s = 0
            for i in range(n):
                node = queue.popleft()
                s += node.val
                if node.left: 
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            res.append(s / n)
        return res
