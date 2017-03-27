class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def rotateRight(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """

        if not head:
            return head

        p, length = head, 1
        while p.next is not None:
            p = p.next
            length += 1
        p.next = head

        k %= length
        for i in range(length - k):
            p = p.next
        head = p.next
        p.next = None

        return head
