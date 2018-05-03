class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def sortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None or head.next is None:
            return head

        pre = head
        slow = head
        fast = head
        while fast and fast.next:
            pre = slow
            slow = slow.next
            fast = fast.next.next

        pre.next = None

        l1 = self.sortList(head)
        l2 = self.sortList(slow)

        return self.merge(l1, l2)

    def merge(self, l1, l2):
        l = ListNode(0)
        p = l
        while l1 and l2:
            if l1.val < l2.val:
                p.next = l1
                l1 = l1.next
            else:
                p.next = l2
                l2 = l2.next

            p = p.next

        if l1:
            p.next = l1

        if l2:
            p.next = l2

        return l.next
