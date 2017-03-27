class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def reverseBetween(self, head, m, n):
        """
        :type head: ListNode
        :type m: int
        :type n: int
        :rtype: ListNode
        """
        start, end = m, n
        dummy = ListNode(0)
        dummy.next = head
        left_p = dummy
        for i in range(0, m - 1):
            left_p = left_p.next
            start -= 1
            end -= 1
        cur = left_p.next
        right_p = cur
        pre = None
        while end > 0:
            nxt = cur.next
            cur.next = pre
            pre = cur
            cur = nxt
            end -= 1
        right_p.next = cur
        left_p.next = pre

        return dummy.next
