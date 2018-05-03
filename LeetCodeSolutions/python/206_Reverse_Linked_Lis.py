class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        # reverse linked-list iteratively
        # dummy = ListNode(0)
        # p = None
        # while head:
        #     p = head
        #     head = head.next
        #     p.next = dummy.next
        #     dummy.next = p
        # return dummy.next

        # reverse linked-list recursively
        if head is None:
            return None
        if head.next is None:
            return head
        node = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        return node
