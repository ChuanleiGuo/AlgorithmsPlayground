from random import randint


class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def __init__(self, head):
        """
        @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node.
        :type head: ListNode
        """
        self.head = head

    def getRandom(self):
        """
        Returns a random node's value.
        :rtype: int
        """
        c = self.head
        r = c.val

        i = 1
        while c.next is not None:
            c = c.next
            if randint(0, i) == i:
                r = c.val
            i += 1
        return r
