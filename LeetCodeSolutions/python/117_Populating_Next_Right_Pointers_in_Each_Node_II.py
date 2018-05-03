class TreeLinkNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        self.next = None


class Solution(object):
    def __get_next_left_most(self, cur):
        while cur:
            if cur.left:
                return cur, cur.left
            if cur.right:
                return cur, cur.right
            cur = cur.next
        return None, None

    def connect(self, root):
        """
        :type root: TreeLinkNode
        :rtype: nothing
        """
        cur = root
        pre = cur
        while cur:
            next_node, its_child = self.__get_next_left_most(cur.next)
            if cur.left:
                cur.left.next = cur.right if cur.right else its_child
            if cur.right:
                cur.right.next = its_child

            if next_node:
                cur = next_node
            else:
                cur = pre.left if pre.left else pre.right
                cur, _ = self.__get_next_left_most(cur)
                pre = cur
