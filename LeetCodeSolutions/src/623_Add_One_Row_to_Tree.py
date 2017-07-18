from collections import deque

class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def addOneRow(self, root, v, d):
        """
        :type root: TreeNode
        :type v: int
        :type d: int
        :rtype: TreeNode
        """
        if d == 1:
            new_root = TreeNode(v)
            new_root.left = root
            return new_root

        queue = deque()
        queue.append(root)
        for _ in range(d - 2):
            size = len(queue)
            for _ in range(size):
                front = queue.popleft()
                if front.left:
                    queue.append(front.left)
                if front.right:
                    queue.append(front.right)
        
        while len(queue):
            node = queue.popleft()
            temp = node.left
            node.left = TreeNode(v)
            node.left.left = temp

            temp = node.right
            node.right = TreeNode(v)
            node.right.right = temp

        return root
