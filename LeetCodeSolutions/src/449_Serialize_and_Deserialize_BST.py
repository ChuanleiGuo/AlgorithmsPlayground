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
        res = ""
        stack = []
        if root is None:
            return res
        stack.append(root)
        while len(stack):
            r = stack.pop()
            res += str(r.val) + ","
            if r.right:
                stack.append(r.right)
            if r.left:
                stack.append(r.left)
        return res

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        def get_node(queue):
            if not queue:
                return None
            root = TreeNode(int(queue.pop(0)))
            small_queue = []
            while len(queue) and int(queue[0]) < root.val:
                small_queue.append(queue.pop(0))
            root.left = get_node(small_queue)
            root.right = get_node(queue)
            return root

        if not data:
            return None

        q = data.split(",")[0: -1]
        return get_node(q)
