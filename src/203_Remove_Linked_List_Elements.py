class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
        if not head:
            return None

        dummy = ListNode(0)
        dummy.next = head

        pre = dummy
        cur = pre.next

        while cur:
            if cur.val == val:
                pre.next = cur.next
                cur = pre.next
                continue
            pre = pre.next
            cur = pre.next

        return dummy.next

l = ListNode(1)
cur = l
l.next = ListNode(2)
cur = l.next
cur.next = ListNode(6)
cur = cur.next
cur.next = ListNode(3)
cur = cur.next
cur.next = ListNode(6)
