class TreeLinkNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        self.next = None


class Solution(object):
    def connect(self, root):
        """
        :type root: TreeLinkNode
        :rtype: nothing
        """
        cur = root
        next_left_most = None
        if not cur:
            return
        while cur.left:
            next_left_most = cur.left
            while cur:
                cur.left.next = cur.right
                cur.right.next = None if cur.next is None else cur.next.left
                cur = cur.next
            cur = next_left_most
