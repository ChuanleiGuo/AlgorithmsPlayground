class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def oddEvenList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head:
            odd, even, even_head = head, head.next, head.next

            while even and even.next:
                odd.next = even.next
                even.next = even.next.next
                odd = odd.next
                even = even.next

            odd.next = even_head

        return head
