class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class BSTIterator(object):
    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.q = []
        self.__all_left_into_stack(root)

    def hasNext(self):
        """
        :rtype: bool
        """
        if not self.q:
            return False
        return True

    def next(self):
        """
        :rtype: int
        """
        cur = self.q.pop()
        self.__all_left_into_stack(cur.right)
        return cur.val

    def __all_left_into_stack(self, node):
        while node:
            self.q.append(node)
            node = node.left
    # Your BSTIterator will be called like this:
    # i, v = BSTIterator(root), []
    # while i.hasNext(): v.append(i.next())
