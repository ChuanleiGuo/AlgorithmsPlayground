# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def partition(self, head, x):
        """
        :type head: ListNode
        :type x: int
        :rtype: ListNode
        """
        dummyLHead = dummyLTail = ListNode(0)
        dummyGHead = dummyGTail = ListNode(0)

        while head:
            if head.val < x:
                dummyLTail.next, dummyLTail = head, head
            else:
                dummyGTail.next, dummyGTail = head, head
            head = head.next

        dummyLTail.next, dummyGTail.next = dummyGHead.next, None
        return dummyLHead.next
