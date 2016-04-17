class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

'''
    回溯法
'''


class Solution1(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None or head.next is None:
            return head

        head_next = head.next
        head.next = self.swapPairs(head_next.next)
        head_next.next = head
        return head_next


'''
    双指针
'''


class Solution(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        left = ListNode(0)
        right = ListNode(0)
        is_first = True
        left.next = right
        rear = right
        right.next = head
        while right.next is not None and right.next.next is not None:
            left = right.next
            right = right.next.next
            left.next = right.next
            right.next = left
            left = right
            rear.next = left
            if is_first:
                is_first = False
                head = left
            right = right.next
            rear = right
        return head