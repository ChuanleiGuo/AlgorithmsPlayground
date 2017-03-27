class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def detectCycle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None or  head.next is None or head.next.next is None:
            return None

        pointer1 = head.next
        pointer2 = head.next.next

        while pointer1 != pointer2:
            if pointer2.next is None or pointer2.next.next is None:
                return None

            pointer1 = pointer1.next
            pointer2 = pointer2.next.next

        pointer1 = head

        while pointer1 != pointer2:
            pointer1 = pointer1.next
            pointer2 = pointer2.next

        return pointer1
