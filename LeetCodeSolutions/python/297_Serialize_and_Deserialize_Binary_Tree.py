from collections import deque


class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Codec:
    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return ''
        queue = deque()
        queue.append(root)
        res = ''
        while len(queue):
            node = queue.popleft()
            if not node:
                res += 'n '
                continue
            res += (str(node.val) + ' ')
            queue.append(node.left)
            queue.append(node.right)

        return res

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        if data == '':
            return None
        queue = deque()
        values = data.split()
        root = TreeNode(int(values[0]))
        queue.append(root)

        i = 1

        while i < len(values):
            parent = queue.popleft()
            if values[i] != 'n':
                left = TreeNode(int(values[i]))
                parent.left = left
                queue.append(left)

            i += 1

            if values[i] != 'n':
                right = TreeNode(int(values[i]))
                parent.right = right
                queue.append(right)

            i += 1

        return root
