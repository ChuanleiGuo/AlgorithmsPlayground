class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        if not headA or not headB:
            return None

        p1 = headA
        p2 = headB
        while p1 != p2:
            p1 = headB if p1 is None else p1.next
            p2 = headA if p2 is None else p2.next

        return p1