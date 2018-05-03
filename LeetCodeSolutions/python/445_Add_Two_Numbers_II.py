class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        s1, s2 = [], []

        while l1:
            s1.append(l1.val)
            l1 = l1.next

        while l2:
            s2.append(l2.val)
            l2 = l2.next

        s = 0
        res = ListNode(0)
        while s1 or s2:
            if s1:
                s += s1.pop()
            if s2:
                s += s2.pop()
            res.val = s % 10
            head = ListNode(s / 10)
            head.next = res
            res = head
            s /= 10
        return res if res.val != 0 else res.next
