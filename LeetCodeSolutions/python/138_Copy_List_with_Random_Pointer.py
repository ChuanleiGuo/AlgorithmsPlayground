class RandomListNode(object):
    def __init__(self, x):
        self.label = x
        self.next = None
        self.random = None


class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: RandomListNode
        :rtype: RandomListNode
        """
        if not head:
            return None
        mapping = {}
        p = head
        t = RandomListNode(0)
        pre = t

        while p:
            new_node = RandomListNode(p.label)
            mapping[p] = new_node
            pre.next = new_node
            p = p.next
            pre = pre.next

        p = head
        pre = t.next
        while p:
            if p.random:
                pre.random = mapping[p.random]
            p = p.next
            pre = pre.next

        return t.next
